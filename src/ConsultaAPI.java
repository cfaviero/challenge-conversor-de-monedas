import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public Parametro cambioMoneda(Monedas moneda, Monedas monedaACambiar, double numero) throws IOException, InterruptedException {

    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/cb8425e30b5dab759c139bcb/pair/" + "/" + moneda + "/" + monedaACambiar + "/" + numero);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String jsonString = response.body();

        Gson gson = new Gson();
        Parametro parametro = gson.fromJson(jsonString, Parametro.class);
        return parametro;
    }

}