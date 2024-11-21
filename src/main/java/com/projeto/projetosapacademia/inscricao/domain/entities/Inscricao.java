package com.projeto.projetosapacademia.inscricao.domain.entities;

import java.util.Date;

import com.projeto.projetosapacademia.shared.domain.entities.Aluno;
import com.projeto.projetosapacademia.shared.domain.entities.Curso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor()
@NoArgsConstructor()
@Getter()
@Setter()
@Entity()
@Table(name = "inscricao")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ins_aln_id", referencedColumnName = "aln_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "ins_crs_id", referencedColumnName = "crs_id", nullable = false)
    private Curso curso;

    @Column(name = "ins_data_inscricao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInscricao;

    @PrePersist
    public void prePersist() {
        this.dataInscricao = new Date();
    }
}
