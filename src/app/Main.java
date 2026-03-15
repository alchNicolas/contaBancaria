package app;

import model.Cartao;
import model.Conta;
import service.CotacaoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        Conta conta = new Conta("Peter Parker", "Corrente", 3500);
        Cartao cartao = new Cartao();

        System.out.println("***********************");
        System.out.println("Titular da conta: " + conta.getNome());
        System.out.println("Tipo de conta: " + conta.getTipoConta());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("***********************");

        String menu = """
                \nOperações
                
                1- Consultar saldos
                2- Depositar
                3- Fazer transferencia
                4- Gerar cartão virtual
                5- Consulta cotações
                6- Sair
                
                Digite a opção desejada:
                """;

        while (opcao != 6) {
            System.out.println(menu);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.exibirSaldo();
                    break;

                case 2:
                    System.out.println("Valor recebido: ");
                    double valorAReceber = scanner.nextDouble();

                    conta.depositar(valorAReceber);

                    conta.exibirSaldo();
                    break;

                case 3:
                    System.out.println("Informe o valor que deseja transferir: ");
                    double valorAEnviar = scanner.nextDouble();

                    conta.transferir(valorAEnviar);

                    conta.exibirSaldo();
                    break;

                case 4:
                    cartao.exibirCartao(conta.getNome());
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.println("Digite a moeda ( Ex: USD-BRL):");
                    String moeda = scanner.nextLine();

                    CotacaoService.consultarMoeda(moeda);
                    break;

                case 6:
                    System.out.println("Programa encerrado");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente");
                    break;
            }
        }
    }
}