package br.com.ebac.stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

public class Aplicacao {

    public static void main(String[] args) {

        Empresa empresaA = new Empresa(
                "Empresa A",
                List.of(
                        new Funcionario(
                                "Ana",
                                LocalDate.of(1975, 1, 1),
                                new BigDecimal("3000.00"),
                                TipoContrato.CLT),

                        new Funcionario(
                                "Bruno",
                                LocalDate.of(1980, 6, 15),
                                new BigDecimal("3000.01"),
                                TipoContrato.CLT),

                        new Funcionario(
                                "Carlos",
                                LocalDate.of(1974, 12, 31),
                                new BigDecimal("2500.00"),
                                TipoContrato.PJ)
                )
        );

        Empresa empresaB = new Empresa(
                "Empresa B",
                List.of(
                        new Funcionario(
                                "Amanda",
                                LocalDate.of(1985, 12, 31),
                                new BigDecimal("2800.00"),
                                TipoContrato.PJ),

                        new Funcionario(
                                "Beatriz",
                                LocalDate.of(1986, 1, 1),
                                new BigDecimal("2000.00"),
                                TipoContrato.CLT)
                )
        );

        List<Empresa> empresas = List.of(empresaA, empresaB);

        System.out.println("Funcionários encontrados:");

        EmpresaUtil.filtrarFuncionarios(empresas)
                .forEach(System.out::println);

        List<Integer> numeros = List.of(
                -4, -3, 0, 1, 2, 3, 4, 5, 6, 10
        );

        int somaPares = EmpresaUtil.somarNumerosPares(numeros);

        System.out.println();
        System.out.println("Soma dos números pares: " + somaPares);

        // Confere também os casos sem valores para somar.
        System.out.println("Lista vazia: "
                + EmpresaUtil.somarNumerosPares(List.<Integer>of()));

        System.out.println("Somente ímpares: "
                + EmpresaUtil.somarNumerosPares(List.of(1, 3, 5)));

        LocalDate dataReferencia = LocalDate.of(2026, 11, 23);

// Cria 35 funcionários elegíveis, com salários de
// R$ 1.000,00 até R$ 35.000,00.
        List<Funcionario> funcionariosRanking = IntStream.rangeClosed(1, 35)
                .mapToObj(numero -> new Funcionario(
                        "Funcionário " + numero,
                        LocalDate.of(2005, 1, 1),
                        BigDecimal.valueOf(numero * 1000L).setScale(2),
                        TipoContrato.CLT))
                .toList();

        Empresa empresaRanking = new Empresa(
                "Empresa Ranking",
                funcionariosRanking
        );

// Os salários altos ajudam a detectar uma filtragem incorreta.
        Empresa empresaLimites = new Empresa(
                "Empresa Limites",
                List.of(
                        new Funcionario(
                                "CLT com exatamente 25 anos",
                                LocalDate.of(2001, 11, 23),
                                new BigDecimal("99000.00"),
                                TipoContrato.CLT),

                        new Funcionario(
                                "PJ com menos de 25 anos",
                                LocalDate.of(2005, 1, 1),
                                new BigDecimal("98000.00"),
                                TipoContrato.PJ),

                        new Funcionario(
                                "CLT na véspera dos 25 anos",
                                LocalDate.of(2001, 11, 24),
                                new BigDecimal("50000.00"),
                                TipoContrato.CLT)
                )
        );

        List<BigDecimal> maioresSalarios =
                EmpresaUtil.obterMaioresSalariosClt(
                        List.of(empresaRanking, empresaLimites),
                        dataReferencia
                );

        System.out.println();
        System.out.println("Maiores salários CLT — menos de 25 anos:");

        maioresSalarios.forEach(salario ->
                System.out.println("R$ " + salario.toPlainString()));

        System.out.println("Quantidade: " + maioresSalarios.size());

        Empresa empresaTesteFinal = new Empresa(
                "Empresa Teste Final",
                List.of(
                        new Funcionario(
                                "Ana",
                                LocalDate.of(2005, 1, 1),
                                new BigDecimal("3000.00"),
                                TipoContrato.CLT),

                        new Funcionario(
                                "Bruno",
                                LocalDate.of(2004, 1, 1),
                                new BigDecimal("4500.00"),
                                TipoContrato.CLT),

                        new Funcionario(
                                "Carlos",
                                LocalDate.of(2003, 1, 1),
                                new BigDecimal("3000.00"),
                                TipoContrato.CLT),

                        new Funcionario(
                                "Daniela",
                                LocalDate.of(2005, 1, 1),
                                new BigDecimal("9000.00"),
                                TipoContrato.PJ)
                )
        );

        System.out.println();
        System.out.println("Ranking com menos de 30 elegíveis:");

        System.out.println(
                EmpresaUtil.obterMaioresSalariosClt(
                        List.of(empresaTesteFinal),
                        dataReferencia
                )
        );

        System.out.println("Ranking sem empresas:");

        System.out.println(
                EmpresaUtil.obterMaioresSalariosClt(
                        List.<Empresa>of(),
                        dataReferencia
                )
        );
    }
}