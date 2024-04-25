import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class APICliente {

    private static final HttpClient httpClient = HttpClient.newBuilder().build();
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/0b0866a8e6ead9bf51cf6e4d/latest/BRL";

    public String getJsonResponse() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public Map<String, Double> obterTaxasCambio() throws URISyntaxException, IOException, InterruptedException {
        String jsonResposta = getJsonResponse();
        return extrairTaxasCambio(jsonResposta);
    }

    private Map<String, Double> extrairTaxasCambio(String jsonResposta) {
        Map<String, Double> taxasCambio = new HashMap<>();

        // Usando Gson para analisar o JSON
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResposta, JsonObject.class);

        // Obtendo o objeto "conversion_rates" do JSON
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        // Iterando sobre as entradas do objeto "conversion_rates" para obter as taxas de câmbio
        for (Map.Entry<String, JsonElement> entry : conversionRates.entrySet()) {
            String codigoMoeda = entry.getKey();
            double taxaCambio = entry.getValue().getAsDouble();
            taxasCambio.put(codigoMoeda, taxaCambio);
        }

        return taxasCambio;
    }
}
