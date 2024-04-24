package app;

import java.util.Locale;
import java.util.Scanner;
import entities.Converter;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();

        System.out.println("Bem vindo ao meu programa!");
        System.out.print("Informe o número que voce deseja converter para outra base: ");
        Double num = scanner.nextDouble();

        try {
            while (true) {
                System.out.println("1 - base binária");
                System.out.println("2 - base octal");
                System.out.println("3 - base decimal");
                System.out.println("4 - base hexadecimal");
                System.out.println("5 - base digitar um número novamente");
                System.out.println("6 - sair do programa");
                System.out.print("Escolha para qual base voce deseja converter o número: ");
                int escolha = 0;
                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println(converter.convertBinario(num));
                        break;
                    case 2:
                        System.out.println(converter.convertOctal(num));
                        break;
                    case 3:
                        System.out.println(converter.convertDecimal(num));
                        break;
                    case 4:
                        System.out.println(converter.convertHexadecimal(num));
                        break;
                    case 5:
                        System.out.println("Informe o número que voce deseja converter para outra base");
                        num = scanner.nextDouble();
                        break;
                    case 6:
                        System.out.println("Saindo do programa...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
