package br.com.ebac.stream;

import java.math.BigDecimal;
import java.util.List;

import java.time.LocalDate;
import java.util.Comparator;

public class EmpresaUtil {

    public static List<Funcionario> filtrarFuncionarios(
            List<Empresa> empresas) {

        BigDecimal salarioLimite = new BigDecimal("3000.00");

        return empresas.stream()

                // Transforma a stream de empresas em uma stream
                // com os funcionários de todas elas.
                .flatMap(empresa -> empresa.getFuncionarios().stream())

                // Inclui os dois anos-limite: 1975 e 1985.
                .filter(funcionario -> {
                    int ano = funcionario.getDataNascimento().getYear();
                    return ano >= 1975 && ano <= 1985;
                })

                // compareTo retorna zero quando os valores são iguais
                // e um número negativo quando o salário é menor.
                .filter(funcionario ->
                        funcionario.getSalario()
                                .compareTo(salarioLimite) <= 0)

                // Reúne os funcionários aprovados em uma lista.
                .toList();
    }

    public static int somarNumerosPares(List<Integer> numeros) {

        return numeros.stream()

                // Seleciona os números divisíveis por 2.
                .filter(numero -> numero % 2 == 0)

                // Converte Stream<Integer> em IntStream.
                .mapToInt(Integer::intValue)

                // Soma os valores selecionados.
                .sum();
    }

    public static List<BigDecimal> obterMaioresSalariosClt(
            List<Empresa> empresas,
            LocalDate dataReferencia) {

        return empresas.stream()

                // Acessa os funcionários de todas as empresas.
                .flatMap(empresa -> empresa.getFuncionarios().stream())

                // Seleciona somente funcionários CLT.
                .filter(funcionario ->
                        funcionario.getTipoContrato() == TipoContrato.CLT)

                // Quem tem exatamente 25 anos fica fora.
                .filter(funcionario ->
                        funcionario.calcularIdade(dataReferencia) < 25)

                // Extrai o salário de cada funcionário selecionado.
                .map(Funcionario::getSalario)

                // Ordena os salários do maior para o menor.
                .sorted(Comparator.reverseOrder())

                // Retorna no máximo 30 salários.
                .limit(30)

                .toList();
    }
}