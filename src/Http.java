import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {
    private String codigoAconvertir;
    private String json;

    public Http(String codigoAconvertir) {
        this.codigoAconvertir = codigoAconvertir;
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/deaba5995f7f49ca093f1eed/latest/" + codigoAconvertir);
        // Cliente Http
        HttpClient client = HttpClient.newHttpClient();
        //Solicitud Http
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        // Respuesta Http
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        json = response.body();
    }

    public String getJson() {
        return json;
    }
}
