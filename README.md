# Exercício módulo 31 — Stream API

Projeto Java para praticar o processamento de coleções em memória
com Stream API.

## Tecnologias

- Java 25
- IntelliJ IDEA

## Estrutura

- TipoContrato: tipos de contratação.
- Funcionario: dados do funcionário e cálculo da idade.
- Empresa: nome e lista de funcionários.
- EmpresaUtil: métodos de processamento com Stream API.
- Aplicacao: exemplos de execução e verificação dos resultados.

## Funcionalidades

### 1. Filtrar funcionários

Seleciona funcionários de todas as empresas nascidos entre 1975
e 1985, inclusive, com salário menor ou igual a R$ 3.000,00.

Operações utilizadas: flatMap, filter e toList.

### 2. Somar números pares

Recebe uma lista de inteiros e retorna a soma dos números pares.
Retorna zero quando a lista está vazia ou não contém pares.

Operações utilizadas: filter, mapToInt e sum.

### 3. Obter os maiores salários CLT

Recebe uma lista de empresas e uma data de referência.
Retorna até 30 salários de funcionários CLT com menos de 25 anos,
ordenados do maior para o menor.

Salários repetidos são preservados.
A idade é calculada pela data de nascimento.

Operações utilizadas: flatMap, filter, map, sorted, limit e toList.

## Verificações realizadas

- Inclusão dos anos-limite 1975 e 1985.
- Inclusão do salário de exatamente R$ 3.000,00.
- Exclusão de funcionários fora dos critérios.
- Soma de pares positivos, negativos e zero.
- Soma em lista vazia e em lista somente com ímpares.
- Exclusão de contratos diferentes de CLT no ranking.
- Exclusão de funcionários com exatamente 25 anos.
- Inclusão de funcionário na véspera de completar 25 anos.
- Ordenação decrescente e limite de 30 salários.
- Preservação de salários iguais.
- Ranking com menos de 30 elegíveis e com lista vazia.

Os testes de idade utilizam a data fixa de 23/11/2026.

## Como executar

1. Abra o projeto no IntelliJ IDEA.
2. Configure o JDK 25.
3. Execute o método main da classe:
   br.com.ebac.stream.Aplicacao
4. Confira os resultados no console.

Não é necessário configurar banco de dados ou bibliotecas externas.