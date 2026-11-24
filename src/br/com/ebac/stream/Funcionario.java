package br.com.ebac.stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Funcionario {

    private final String nome;
    private final LocalDate dataNascimento;
    private final BigDecimal salario;
    private final TipoContrato tipoContrato;

    public Funcionario(
            String nome,
            LocalDate dataNascimento,
            BigDecimal salario,
            TipoContrato tipoContrato) {

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.tipoContrato = tipoContrato;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    // A data de referência permite testar a idade com uma data fixa.
    public int calcularIdade(LocalDate dataReferencia) {
        return Period.between(dataNascimento, dataReferencia).getYears();
    }

    @Override
    public String toString() {
        return nome
                + " | Nascimento: " + dataNascimento
                + " | Salário: R$ " + salario.toPlainString()
                + " | Contrato: " + tipoContrato;
    }
}