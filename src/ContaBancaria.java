import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = "Peter Parker";
        String conta = "Corrente";
        double saldo = 2500.00;
        int opcao = 0;
        double valorAReceber;
        double valorAEnviar ;


        System.out.println("***********************");
        System.out.println("\nNome do cliente: " + nome);
        System.out.println("Tipo conta: " + conta);
        System.out.println("Saldo atual: " + saldo);
        System.out.println("\n***********************");

        String menu = """
                    \nOperações
                    
                    1- Consultar saldos
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    
                    Digite a opção desejada:
                    """;

        while (opcao != 4) {
            System.out.println(menu);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("O seu saldo atual é: " + saldo);
                    break;

                case 2:
                    System.out.println("Valor recebido: ");
                    valorAReceber = scanner.nextDouble();
                    saldo += valorAReceber;
                    System.out.println("Saldo atualizado R$ " + saldo);
                    break;

                case 3:
                    System.out.println("Informe o valor que deseja transferir: ");
                    valorAEnviar = scanner.nextDouble();
                    if (valorAEnviar > saldo) {
                        System.out.println("Não há saldo suficiente para fazer essa transferência");
                    } else {
                        saldo -= valorAEnviar;
                        System.out.println("Saldo atualizado R$ " + saldo);
                    }

                    break;

                case 4:
                    System.out.println("Programa encerrado");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente");
                    break;
            }
        }


    }
}
