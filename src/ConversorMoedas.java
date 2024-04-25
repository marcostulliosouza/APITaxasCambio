import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class ConversorMoedas {

    private Map<String, Double> taxasCambio;

    public ConversorMoedas() throws IOException, InterruptedException, URISyntaxException {
        this.taxasCambio = obterTaxasCambio();
    }

    private Map<String, Double> obterTaxasCambio() throws IOException, InterruptedException, URISyntaxException {
        APICliente cliente = new APICliente();
        String jsonResposta = cliente.getJsonResponse();
        return extrairTaxasCambio(jsonResposta);
    }

    private Map<String, Double> extrairTaxasCambio(String jsonResposta) {
        Map<String, Double> taxasCambio = new HashMap<>();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResposta, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        for (Map.Entry<String, JsonElement> entry : conversionRates.entrySet()) {
            String codigoMoeda = entry.getKey();
            double taxaCambio = entry.getValue().getAsDouble();
            taxasCambio.put(codigoMoeda, taxaCambio);
        }
        return taxasCambio;
    }

    public double converterUSDParaBRL(double valorUSD) {
        return valorUSD / taxasCambio.get("USD");
    }

    public double converterBRLParaUSD(double valorBRL) {
        return valorBRL * taxasCambio.get("USD");
    }

    public double converterEURParaBRL(double valorEUR) {
        return valorEUR / taxasCambio.get("EUR");
    }

    public double converterBRLParaEUR(double valorBRL) {
        return valorBRL * taxasCambio.get("EUR");
    }
}
