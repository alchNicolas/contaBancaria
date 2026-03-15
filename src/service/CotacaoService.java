package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CotacaoService {

    public static void consultarMoeda(String moeda) {

        try {
            String endereco = "https://economia.awesomeapi.com.br/json/last/" + moeda;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Cotação encontrada: ");
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println("Erro ao consultar moeda");
        }
    }
}
