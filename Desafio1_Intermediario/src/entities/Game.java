package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

    private String palavra;
    private List<String> listaCaracteres = new ArrayList<>();

    public Game() {
        this.palavra = generatorPalavras();
    }

    private String generatorPalavras() {
        String[] palavras = { "Banana", "Maçã", "Livro", "Escola", "Casa", "Gato", "Cachorro", "Sol", "Bola", "Amigo" };
        Collections.shuffle(Arrays.asList(palavras));
        return palavras[0];
    }

    public String getPalavra() {
        return palavra;
    }

    public String brincadeira(String letra) {
        if (letra.length() == 1 && Character.isLetter(letra.charAt(0))) {
            if (getPalavra().contains(letra)) {
                addListaCaracteres(letra);
                if (isPalavraCorreta()) {
                    return "Parabéns, você acertou a palavra '" + getPalavra() + "'!";
                } else {
                    return "A letra '" + letra + "' está presente na palavra!";
                }
            } else {
                return "A letra '" + letra + "' não está presente na palavra!";
            }
        } else {
            return "Por favor, digite uma letra válida!";
        }
    }
    
    private boolean isPalavraCorreta() {
        String palavraAtual = getPalavra().toLowerCase();
        for (String letra : getListaCaracteres()) {
            palavraAtual = palavraAtual.replace(letra.toLowerCase(), "");
        }
        return palavraAtual.isEmpty();
    }

    public void addListaCaracteres(String letra) {
        listaCaracteres.add(letra);
    }

    public List<String> getListaCaracteres() {
        return listaCaracteres;
    }
}
