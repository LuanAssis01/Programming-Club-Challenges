package entities;

import java.rmi.server.UID;
import java.util.NoSuchElementException;

public class Conta {

    private UID idConta;
    private Double amount;

    public Conta(Double amount) {
        this.amount = amount;
        this.idConta = new UID();

    }

    public Double getAmount() {
        return amount;
    }

    public Double getSaldo() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public UID getIdConta() {
        return idConta;
    }

    public Double deposito(Double value) {
        if (value < 0)
            throw new NoSuchElementException("Não é possível depositar um valor negativo!");
        return this.amount += value;
    }

    public Double sacar(Double value) {
        if (value < 0)
            throw new NoSuchElementException("Não é possível sacar um valor negativo!");
        return this.amount -= value;
    }

    public void transferir(Conta destino, Double value) {
        if (value < 0)
            throw new NoSuchElementException("Não é possível transferir um valor negativo!");

        if (this.amount < value)
            throw new NoSuchElementException("Saldo insuficiente para a transferência!");

        this.amount -= value;
        destino.deposito(value);
    }

    @Override
    public String toString() {
        return "Conta [amount=" + amount + ", transferencia=" + "]";
    }
}
