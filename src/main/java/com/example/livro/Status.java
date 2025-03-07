package com.example.livro;

import lombok.Getter;

import java.util.List;

@Getter
public enum Status {
    DISPONIVEL(0),
    EM_EMPRESTIMO(1),
    RESERVADO(2);

    private final int valor;

    Status(int valor) {
        this.valor = valor;
    }

    public static Status fromValor(int valor) {
        for (Status status : Status.values()) {
            if (status.valor == valor) {return status;}
        }  throw new IllegalArgumentException("Valor inválido: " + valor);
    }

    public static Status fromStatus(String statusLivro) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(statusLivro)) {
                return status;            }
        }  throw new IllegalArgumentException("Status inválido: " + statusLivro);
    }
}
