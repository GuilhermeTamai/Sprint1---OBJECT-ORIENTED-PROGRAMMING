# 🌱 VeroAI

## 📌 Sobre o Projeto

Este projeto tem como objetivo desenvolver um sistema de monitoramento e priorização de roçada de vegetação em rodovias. A proposta é simular o crescimento da vegetação ao longo de trechos rodoviários e auxiliar na identificação de áreas críticas, otimizando a atuação das equipes de manutenção.

O sistema foi desenvolvido como parte da disciplina Object-Oriented Programming (OOP), com foco na aplicação prática dos conceitos fundamentais de programação orientada a objetos, com a utlização da linguagem Java.

---

## 👥 Integrantes do Grupo
- Vitor Komura – RM563694  
- Caio Castelão – RM563630  
- Mirella Mascarenhas – RM562092  
- Guilherme Tamai – RM563276  
- André Gouveia – RM564219  
- André Nobrega– RM561754

---

## 🤔 Perguntas Reflexivas

### ❓ Por que `TrechoRodovia` é uma classe e "BR-116 KM 10 ao 15" é um objeto?

**Resposta:**  
`TrechoRodovia` é considerada uma classe porque define um modelo geral para representar qualquer trecho de rodovia, especificando quais informações devem existir (como quilômetro inicial, quilômetro final e nível de vegetação) e quais ações podem ser realizadas. Já "BR-116 KM 10 ao 15" é um objeto porque representa um caso específico desse modelo, com valores próprios e concretos dentro do sistema.


### ❓ Como um método difere de uma função solta em programação estruturada?

**Resposta:**  
A principal diferença está no contexto em que cada um é utilizado. Uma função, na programação estruturada, é independente e não está diretamente vinculada a um conjunto específico de dados. Já um método faz parte de uma classe e está associado a um objeto, podendo acessar e modificar diretamente seus atributos. Na prática, isso torna o método mais integrado ao estado do objeto com o qual ele trabalha.


### ❓ Se o `nivelVegetacao` fosse público, que tipo de "quebra" no sistema um programador descuidado poderia causar?

**Resposta:**  
Se o atributo fosse público, qualquer parte do código poderia alterá-lo livremente, inclusive atribuindo valores inválidos, como números negativos. Isso comprometeria a consistência dos dados e poderia gerar resultados incorretos em cálculos ou decisões do sistema. Ao manter esse atributo encapsulado, é possível garantir que apenas valores válidos sejam definidos, preservando a integridade das informações.
