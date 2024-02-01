package com.example.Igreja.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Igreja")
public class IgrejaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 100)
    @NotBlank
    private String nome;

    @Column(length = 14,unique = true)
    @NotBlank
    private String CNPj;
 
    @Column(length = 100)
    @NotBlank
    private String cidade;

    @Column(length = 100)
    private String estado;

    @Column(length = 20)
    @NotBlank
    private String login;

    @Column(length = 100,unique = true)
    @Email
    private String email;

    @Column(length = 20)
    @NotBlank
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPj() {
        return CNPj;
    }

    public void setCNPj(String cNPj) {
        CNPj = cNPj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    

   
}
