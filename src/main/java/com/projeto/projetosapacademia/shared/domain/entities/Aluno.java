package com.projeto.projetosapacademia.shared.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
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
@Table(name = "aluno")
@SecondaryTable(name = "inscricao", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ins_aln_id", referencedColumnName = "aln_id"))
public final class Aluno {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aln_id")
    private Long id;

    @Column(name = "aln_nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "aln_registro_academico", nullable = false, length = 50)
    private String registroAcademico;

    @Column(name = "aln_email", nullable = false, length = 80)
    private String email;

    @Column(name = "aln_data_cadastro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        this.dataCadastro = now;
    }
}
