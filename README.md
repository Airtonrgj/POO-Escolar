# POO-Escolar
# Projeto POO – Coleções Java

## 1. Descrição do Projeto

Este projeto implementa um sistema de gerenciamento escolar usando **Programação Orientada a Objetos (POO)** e coleções em Java (`List`, `Set` e `Map`).
O sistema permite:

* Gerenciar estudantes e suas matrículas.
* Gerenciar disciplinas, garantindo unicidade e ordenação.
* Registrar notas dos estudantes por disciplina.
* Consultar médias individuais, médias por disciplina e rankings de estudantes.

O projeto segue os requisitos do documento **“Trabalho de POO — Coleções Java”**, contemplando as Partes A, B, C e D.

---

## 2. Estrutura do Projeto

| Classe                | Responsabilidade                                                                                      |
| --------------------- | ----------------------------------------------------------------------------------------------------- |
| `Estudante`           | Representa um estudante com nome e matrícula (ID).                                                    |
| `ListaEstudantes`     | Gerencia a coleção de estudantes (`List`). Permite adicionar, remover, buscar e ordenar.              |
| `Disciplina`          | Representa uma disciplina com código e nome. Implementa `Comparable` e garante unicidade pelo código. |
| `CadastroDisciplinas` | Gerencia disciplinas (`Set`) evitando duplicatas por código e nome. Mantém a ordem de inserção.       |
| `Matricula`           | Representa a matrícula de um estudante em uma disciplina com a nota obtida.                           |
| `HistoricoNotas`      | Gerencia notas por estudante (`Map<String, List<Matricula>>`). Calcula médias e rankings.             |
| `Main`                | Classe principal. Contém menus interativos para gerenciar estudantes, disciplinas e gerar relatórios. |

---

## 3. Como Rodar

1. Compile todas as classes:

```bash
javac *.java
```

2. Execute o programa:

```bash
java Main
```

3. Utilize o menu interativo:

* **1 – Gerenciar Estudantes:** adicionar, remover, listar ou ordenar estudantes.
* **2 – Gerenciar Disciplinas:** adicionar, remover ou listar disciplinas.
* **3 – Consultas e Relatórios:** exibir notas, médias, alunos aprovados e ranking.
* **4 – Sair:** encerra o sistema.

---

## 4. Detalhes das Classes

### Estudante

* **Atributos:**

    * `nome` (String)
    * `matricula` (String) – funciona como ID único
* **Métodos principais:**

    * `getNome()` / `getMatricula()`
    * `equals()` e `hashCode()` baseados em matrícula
    * `toString()` retorna `"Matrícula: X, Nome: Y"`

---

### ListaEstudantes

* **Coleção:** `ArrayList<Estudante>`
* **Funcionalidades:**

    * Adicionar, remover por matrícula.
    * Buscar estudantes por nome (case-insensitive).
    * Ordenar estudantes por nome.
    * Obter estudante por índice ou matrícula.

---

### Disciplina

* **Atributos:**

    * `codigo` (String)
    * `nome` (String)
* **Funcionalidades:**

    * `Comparable` pelo código da disciplina.
    * `equals()` e `hashCode()` baseados no código.
    * `toString()` exibe `"codigo - nome"`.

---

### CadastroDisciplinas

* **Coleção:** `LinkedHashSet<Disciplina>` (mantém ordem de inserção)
* **Funcionalidades:**

    * Adicionar disciplina (ignora duplicatas por código ou nome).
    * Verificar existência de disciplina pelo código.
    * Remover disciplina pelo código.
    * Obter todas as disciplinas em ordem de inserção.

---

### Matricula

* **Atributos:**

    * `codigoDisciplina` (String)
    * `nota` (double)
* **Funcionalidades:**

    * Apenas getters para acesso aos atributos.

---

### HistoricoNotas

* **Coleção:** `Map<String, List<Matricula>>`
* **Funcionalidades:**

    * Adicionar matrícula de um estudante.
    * Obter matrículas e nota específica.
    * Remover matrícula de estudante por disciplina.
    * Calcular média do estudante.
    * Calcular média da disciplina.
    * Listar top N estudantes por média.

---

### Main

* **Menus Interativos:**

    1. Gerenciar Estudantes
    2. Gerenciar Disciplinas
    3. Consultas e Relatórios (médias, aprovados, top N)
    4. Sair

* **Dados iniciais:**

    * Dataset de 20 estudantes, 6 disciplinas e matrículas com notas.
    * Demonstra todas as funcionalidades do sistema.

---

## 5. Exemplos de Relatórios

### Médias por Estudante

```
Ana: MAT101(8.5), PRG201(9.0), ING310(6.0) Média: 7.83
Bruno: PRG201(7.0), MAT101(5.0), EGS410(9.0) Média: 7.00
...
```

### Médias por Disciplina

```
MAT101: 6.85
PRG201: 7.65
BD301: 6.87
...
```

### Top 3 Estudantes por Média

```
1) Kevin - 9.90
2) Rafael - 9.80
3) Ana - 7.83
```

### Alunos com média ≥ 8.0

```
Kevin (9.90)
Rafael (9.80)
Ana (7.83) -> se >= 8.0, não aparece
```

---

#INTEGRANTES

Pedro Henrique Rodrigues Jacques Pinheiro //
Gabriel do Rego Lima Menezes //
Henrique França de Souza Medeiros Maranguape //
José Airton Rodrigues Galdino Júnior 