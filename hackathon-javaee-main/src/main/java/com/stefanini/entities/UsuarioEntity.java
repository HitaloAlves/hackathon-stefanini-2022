package com.stefanini.entities;

import com.stefanini.dto.UsuarioDTO;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;



@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private Long idUsuario;

@Column(nullable = false, length = 50)
private String nome;

@Column(unique = true, nullable = false, length = 20)
private String login;

@Column(nullable = false)
private String email;

@Column(nullable = false)
private String senha;

@Column(name = "data_nascimento")
private LocalDate dataNascimento;

@CreationTimestamp
@Column(name = "data_criacao", nullable = false, updatable = false)
private LocalDateTime dataCriacao;

@UpdateTimestamp
@Column(name = "data_atualizacao")
private LocalDateTime dataAtualizacao;

public UsuarioEntity(){
}

public UsuarioEntity(UsuarioDTO usuarioDTO){
    this.idUsuario = usuarioDTO.getIdUsuario();
    this.nome = usuarioDTO.getNome();
    this.login = usuarioDTO.getLogin();
    this.email = usuarioDTO.getEmail();
    this.senha = usuarioDTO.getSenha();
    this.dataNascimento = usuarioDTO.getDataNascimento();
    this.dataCriacao = usuarioDTO.getDataCriacao();
    this.dataAtualizacao = usuarioDTO.getDataAtualizacao();
}

public Long getIdUsuario() {
    return idUsuario;
}

public void setIdUsuario(Long id) {
    this.idUsuario = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
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

public LocalDate getDataNascimento() {
    return dataNascimento;
}

public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
}

public LocalDateTime getDataCriacao() {
    return dataCriacao;
}

public void setDataCriacao(LocalDateTime dataCriacao) {
    this.dataCriacao = dataCriacao;
}

public LocalDateTime getDataAtualizacao() {
    return dataAtualizacao;
}

public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
}

}