package app;

import java.util.Scanner;
import java.util.InputMismatchException;
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
                System.out.println("\n==== FinTrack ====");
                System.out.println("1. Adicionar transação");
                System.out.println("2. Listar todas as transações");
                System.out.println("3. Mostrar saldo atual");
                System.out.println("4. Excluir transação");
                System.out.println("5. Sair do sistema");
                System.out.print("Escolha uma opção: ");

                opc = input.nextInt();
                input.nextLine();

                switch (opc) {
                    case 1:
                        System.out.print("Descrição: ");
                        String desc = input.nextLine();

                        System.out.print("Valor: ");
                        double valor = input.nextDouble();
                        input.nextLine();

                        if (valor <= 0) {
                            throw new EntradaInvalidaException("Valor deve ser maior que zero.");
                        }

                        System.out.print("Tipo [Receita/Despesa]: ");
                        String tipo = input.nextLine();

                        if (!tipo.equalsIgnoreCase("receita") && !tipo.equalsIgnoreCase("despesa")) {
                            throw new EntradaInvalidaException("Tipo inválido! Digite 'Receita' ou 'Despesa'.");
                        }

                        Transacao transacao = new Transacao(desc, valor, tipo);
                        finTracker.addTransacao(transacao);
                        System.out.println("Transação adicionada com sucesso.");
                        break;

                    case 2:
                        System.out.println("=== TRANSAÇÕES ===");
                        finTracker.listarTransacoes();
                        break;

                    case 3:
                        System.out.println("Saldo atual: " + util.Formatador.formatarMoeda(finTracker.calcularSaldo()));
                        break;

                    case 4:
                        System.out.print("Informe o índice da transação: ");
                        int indice = input.nextInt();
                        input.nextLine();

                        if (indice < 0) {
                            throw new EntradaInvalidaException("O índice não pode ser negativo.");
                        }

                        finTracker.removerTransacao(indice);
                        break;

                    case 5:
                        System.out.println("Encerrando operações...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar um número válido.");
                input.nextLine();
            } catch (EntradaInvalidaException e) {
                System.out.println("Erro de Validação: " + e.getMessage());
            }
        }
        input.close();
    }
}