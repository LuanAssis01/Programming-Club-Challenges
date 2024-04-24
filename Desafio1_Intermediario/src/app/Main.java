package app;

import java.util.Scanner;
import entities.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo da forca!");
        System.out.print("Para começar, digite uma letra: ");
        String letra = scanner.next();
        System.out.println();
        System.out.println(game.brincadeira(letra));

        System.out.println();

        int n = 5;
        boolean acertouPalavra = false;

        for (int i = 0; i < 5; i++) {
            System.out.println("Você tem mais " + n + " tentativas para acertar a palavra!");
            n--;

            System.out.println();

            System.out.print("Digite uma letra novamente: ");
            letra = scanner.next();
            String resultado = game.brincadeira(letra);
            System.out.println();
            System.out.println(resultado);

            if (resultado.contains("Parabéns")) {
                acertouPalavra = true;
                break;
            }

            System.out.print("Você já sabe qual é a palavra? (S/N) ");
            char cont = scanner.next().charAt(0);
            scanner.nextLine(); // Consumir o caractere de quebra de linha

            if (cont == 'S' || cont == 's') {
                System.out.print("Digite a palavra correta: ");
                String palavraCorreta = scanner.nextLine();
                game.brincadeira(palavraCorreta);
                break;
            }

            System.out.println();
        }

        if (acertouPalavra) {
            System.out.println("Parabéns, você acertou a palavra!");
        } else {
            System.out.println("Você não acertou a palavra. Mais sorte na próxima vez!");
        }

        scanner.close();
    }
}
