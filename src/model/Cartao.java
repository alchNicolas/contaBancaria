package model;

import java.security.SecureRandom;

public class Cartao {

    private long numero;
    private int cvc;
    private String validade;

    public Cartao() {

        SecureRandom secureRandom = new SecureRandom();

        long min = (long) Math.pow(10, 15);
        long max = (long) Math.pow(10, 16) - 1;

        numero = secureRandom.nextLong(max - min) + 1 + min;
        cvc = secureRandom.nextInt(900) + 100;
        validade = "06/2036";
    }

    public String formatarNumero() {

        String numeroStr = String.valueOf(numero);

        return numeroStr.replaceAll("(.{4})", "$1").trim();
    }

    public void exibirCartao(String nome) {

        System.out.println("Nome: " + nome);
        System.out.println("Número: " + formatarNumero());
        System.out.println("Validade: " + validade);
        System.out.println("CVC: " + cvc);

    }
}
