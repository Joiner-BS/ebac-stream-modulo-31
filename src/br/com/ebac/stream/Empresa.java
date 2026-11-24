package br.com.ebac.stream;

import java.util.List;

public class Empresa {

    private final String nome;
    private final List<Funcionario> funcionarios;

    public Empresa(String nome, List<Funcionario> funcionarios) {
        this.nome = nome;

        // Guarda uma cópia não modificável da lista recebida.
        this.funcionarios = List.copyOf(funcionarios);
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}