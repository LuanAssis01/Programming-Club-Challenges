package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import entities.Cliente;
import entities.Conta;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-Vindo!");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a senha da sua conta: ");
        String senhaConta = scanner.nextLine();

        Cliente cliente = new Cliente(nome, senhaConta);
        List<Cliente> listCliente = new ArrayList<>();
        Conta conta = new Conta(0.0);
        listCliente.add(cliente);

        int escolha = 0;
        Double value = 0.0;

        try {
            while (true) {
                System.out.println("1 - Depósito");
                System.out.println("2 - Saque");
                System.out.println("3 - Transferência");
                System.out.println("4 - Verificar saldo da conta");
                System.out.println("5 - Criar nova conta");
                System.out.println("6 - Sair");

                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.print("Informe o valor que você deseja depositar na sua conta: ");
                        value = scanner.nextDouble();
                        conta.deposito(value);
                        System.out.println("Depósito realizado com sucesso!");
                        break;
                    case 2:
                        System.out.print("Informe o valor que você deseja sacar da sua conta: ");
                        value = scanner.nextDouble();
                        conta.sacar(value);
                        System.out.println("Saque realizado com sucesso!");
                        break;
                    case 3:
                        System.out.print("Informe o valor que você deseja transferir: ");
                        value = scanner.nextDouble();

                        // Exibe as contas do cliente para que ele escolha a conta de origem da
                        // transferência
                        System.out.println("Escolha a conta de origem da transferência:");
                        for (int i = 0; i < cliente.getListConta().size(); i++) {
                            System.out.println((i + 1) + " - " + cliente.getListConta().get(i));
                        }

                        System.out.print("Escolha o número da conta de origem: ");
                        int escolhaContaOrigem = scanner.nextInt();

                        if (escolhaContaOrigem <= 0 || escolhaContaOrigem > cliente.getListConta().size()) {
                            System.out.println("Escolha inválida.");
                            break;
                        }

                        Conta contaOrigem = cliente.getListConta().get(escolhaContaOrigem - 1);

                        System.out.print("Informe o nome do destinatário: ");
                        String nomeDestinatario = scanner.next();

                        Cliente clienteDestino = null;
                        for (Cliente c : listCliente) {
                            if (c.getNome().equals(nomeDestinatario)) {
                                clienteDestino = c;
                                break;
                            }
                        }

                        if (clienteDestino != null) {
                            Conta contaDestino = null;
                            System.out.println("Escolha a conta de destino da transferência:");
                            for (int i = 0; i < clienteDestino.getListConta().size(); i++) {
                                System.out.println((i + 1) + " - " + clienteDestino.getListConta().get(i));
                            }

                            System.out.print("Escolha o número da conta de destino: ");
                            int escolhaContaDestino = scanner.nextInt();

                            if (escolhaContaDestino <= 0
                                    || escolhaContaDestino > clienteDestino.getListConta().size()) {
                                System.out.println("Escolha inválida.");
                                break;
                            }

                            contaDestino = clienteDestino.getListConta().get(escolhaContaDestino - 1);

                            try {
                                contaOrigem.transferir(contaDestino, value);
                                System.out.println("Transferência realizada com sucesso para " + nomeDestinatario);
                            } catch (NoSuchElementException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Cliente de destino não encontrado.");
                        }
                        break;
                    case 4:
                       
                        System.out.println("Escolha a conta para verificar o saldo:");
                        for (int i = 0; i < cliente.getListConta().size(); i++) {
                            System.out.println((i + 1) + " - " + cliente.getListConta().get(i));
                        }

                        System.out.print("Escolha o número da conta: ");
                        int escolhaConta = scanner.nextInt();

                        if (escolhaConta <= 0 || escolhaConta > cliente.getListConta().size()) {
                            System.out.println("Escolha inválida.");
                            break;
                        }

                        Conta contaSelecionada = cliente.getListConta().get(escolhaConta - 1);
                        System.out.println("Saldo da conta: " + contaSelecionada.getSaldo());
                        break;

                    case 5:
                        System.out.print("Digite seu nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Informe a senha da sua conta: ");
                        String novaSenha = scanner.nextLine();

                        Cliente novoCliente = new Cliente(novoNome, novaSenha);
                        Conta novaConta = new Conta(0.0);
                        novoCliente.addConta(novaConta);
                        listCliente.add(novoCliente);

                        System.out.println("Nova conta criada com sucesso para " + novoNome);
                        break;

                    case 6:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("ERRO: Digite um valor válido!");
        } finally {
            scanner.close();
        }

    }
}
