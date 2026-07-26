package controller;

import model.Transacao;
import java.util.ArrayList;

public class FinTracker {
    private final ArrayList<Transacao> transacoes = new ArrayList<>();

    public void addTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void listarTransacoes() {
        for (int i = 0; i < transacoes.size(); i++) {
            System.out.println(i+1 + ". " + transacoes.get(i));
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
