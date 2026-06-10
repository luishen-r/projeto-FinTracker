package controller;

import model.Transacao;
import java.util.ArrayList;

public class FinTracker {
    private ArrayList<Transacao> transacoes = new ArrayList<>();

    public void addTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void listarTransacoes() {
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
    }

    public double calcularSaldo() {
        double saldo = 0;

        for (Transacao transacao : transacoes) {

            if (transacao.getTipo().equalsIgnoreCase("receita")) {
                saldo += transacao.getValor();
            } else {
                saldo -= transacao.getValor();
            }
        }

        return saldo;
    }

    public void removerTransacao(int indice) {
        if (indice >= 0 && indice < transacoes.size()) {
            transacoes.remove(indice);
        }
    }
}
