# FinTrack 💰

O **FinTrack** é uma aplicação de console simples e eficiente desenvolvida em Java para o gerenciamento de finanças pessoais. O sistema permite ao utilizador registar receitas e despesas, visualizar o saldo atualizado em tempo real, listar o histórico de transações e remover registos através de um menu interativo no terminal.

Este projeto foi construído seguindo boas práticas de Orientação a Objetos (POO) e uma estrutura de pacotes organizada para facilitar a manutenção e legibilidade do código.

---

## ✨ Funcionalidades

- **➕ Adicionar Transação:** Registo de movimentações financeiras informando a descrição, o valor e o tipo.
- **🔍 Validar Entradas:** Tratamento de erros para impedir valores negativos ou tipos inválidos, garantindo a integridade dos dados.
- **📋 Listar Transações:** Exibição detalhada de todo o histórico de movimentações com indexação numérica.
- **📊 Saldo Atualizado:** Cálculo automático e dinâmico do saldo consolidado (Receitas - Despesas).
- **💱 Formatação de Moeda:** Exibição dos valores monetários formatados automaticamente no padrão brasileiro (`R$`) utilizando localização (`Locale`).
- **❌ Excluir Transação:** Remoção de registos específicos do histórico com base no seu índice.

---

## 📁 Estrutura de Pacotes

O código está dividido de forma lógica em pacotes, promovendo uma arquitetura limpa e de fácil compreensão:

```text
src/
├── app/
│   └── Main.java                     # Ponto de entrada do sistema e gestão do menu de console.
├── controller/
│   └── FinTracker.java               # Controlador responsável pela lógica de negócio e gestão da lista.
├── exceptions/
│   └── EntradaInvalidaException.java # Exceção personalizada para capturar dados inconsistentes.
├── model/
│   ├── Transacao.java                # Classe base que representa uma movimentação financeira.
│   └── TransacaoMensal.java          # Extensão de Transacao (Herança) que inclui suporte ao mês vigente.
└── util/
    └── Formatador.java               # Classe utilitária para formatação de valores em moedas (pt-BR).
