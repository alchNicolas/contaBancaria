import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String nome = "Peter Parker";
        String conta = "Corrente";
        double saldo = 2500.00;
        int opcao = 0;
        double valorAReceber;
        double valorAEnviar ;
        int digitos = 16;
        int codigoCvc = 397;
        String moeda;

        long min = (long) Math.pow(10, digitos - 1);
        long max = (long) Math.pow(10, digitos) - 1;

        SecureRandom secureRandom = new SecureRandom();
        long numeroDoCartao = secureRandom.nextLong((max - min) + 1) + min;



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
                    System.out.println("Nome do titular: " + nome +
                            "\nNúmero do cartão: " + numeroDoCartao +
                            "\nValidade: 05/2036" +
                            "\nCVC: " + codigoCvc);
                    break;

                case 5:
                    scanner.nextLine(); // limpa o ENTER que ficou no buffer

                    System.out.println("Digite a moeda para consulta (Ex: USD-BRL):");
                    moeda = scanner.nextLine();
                    if (moeda ==""){
                        System.out.println("Não encontrei, digite novamente");
                    }else {
                        String endereco = "https://economia.awesomeapi.com.br/json/last/" + moeda;

                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(endereco))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());
                        System.out.println(response.body());
                        break;
                    }

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
