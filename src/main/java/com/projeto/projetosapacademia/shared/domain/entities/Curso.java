package com.projeto.projetosapacademia.shared.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor()
@Getter()
@Setter()
@Entity()
@Table(name = "curso")
public final class Curso {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crs_id")
    private Long id;

    @Column(name = "crs_nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "crs_email", nullable = false, length = 80)
    private String descricao;

    @Column(name = "aln_data_criacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        this.dataCriacao = now;
    }
}