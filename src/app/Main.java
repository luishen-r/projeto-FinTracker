package app;

import java.util.Scanner;
import controller.FinTracker;
import model.Transacao;
import exceptions.EntradaInvalidaException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        FinTracker finTracker = new FinTracker();
        int opc = 0;

        while (opc != 5) {
            try {

                System.out.println("==== FinTrack ====");
                System.out.println("1. Adicionar transação");
                System.out.println("2. Listar todas as transações");
                System.out.println("3. Mostrar saldo atual");
                System.out.println("4. Excluir transação");
                System.out.println("5. Sair do sistema");

                opc = input.nextInt();
                input.nextLine();

                switch (opc) {
                    case 1:
                        System.out.println("Descrição: ");
                        String desc = input.nextLine();

                        System.out.println("Valor: R$");
                        double valor = input.nextDouble();
                        input.nextLine();
                        if (valor <= 0) {
                            throw new EntradaInvalidaException("Valor deve ser maior que zero.");
                        }

                        System.out.println("Tipo[Receita/Despesa]: ");
                        String tipo = input.nextLine();

                        Transacao transacao = new Transacao(desc, valor, tipo);
                        finTracker.addTransacao(transacao);

                        System.out.println("Transação adicionada com sucesso.");

                        break;
                    case 2:
                        System.out.println("==================");
                        finTracker.listarTransacoes();
                        System.out.println("==================");
                        break;
                    case 3:
                        System.out.println("==================");
                        System.out.println("Saldo atual: R$" + finTracker.calcularSaldo());
                        System.out.println("==================");
                        break;
                    case 4:
                        System.out.println("================================");
                        System.out.println("Informe o índice da transação: ");
                        int indice = input.nextInt();
                        if (indice < 0) {
                            throw new EntradaInvalidaException("Indice deve ser maior/igual que zero");
                        }
                        finTracker.removerTransacao(indice);
                        System.out.println("Transação removida com sucesso.");
                        System.out.println("================================");
                        break;
                    case 5:
                        System.out.println("Encerrando operações...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());
                input.nextLine();

                System.out.println("Entrada invalida. Digite novamente.");
                input.nextLine();
            }
        }
    }
}
