package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String senha;
    private List<Conta> listConta = new ArrayList<>();

    public Cliente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void addConta(Conta conta) {
        listConta.add(conta);
    }

    public void removeConta(Conta conta) {
        listConta.remove(conta);
    }

    public List<Conta> getListConta() {
        return listConta;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", senha=" + senha + ", listConta=" + listConta + "]";
    }
}
