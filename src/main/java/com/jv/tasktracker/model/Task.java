package com.jv.tasktracker.model;

import java.time.LocalDate;


public class Task {
    private int id;
    private String descricao;
    private Status status;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;

    public Task(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.status = Status.TODO;
        this.dataCriacao = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    public Task(){

    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }

    public void setDataAtualizacao(LocalDate dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    private void atualizarData() {
        this.dataAtualizacao = LocalDate.now();
    }
}