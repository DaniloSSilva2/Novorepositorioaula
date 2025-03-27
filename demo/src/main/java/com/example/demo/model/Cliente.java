package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToOne(cascade = CascadeType.ALL) 
    private Endereco endereco;





}
