import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        int seleccionDeUsuario;

        while (true) {

//Home
            System.out.println(""" 
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                    
                    CONVER$OR DE DIVI$A$

                    Opciones de conversión:
                                    
                    1) Dólar => Peso Mexicano
                    2) Peso Mexicano => Dólar
                    3) Real Brasileño => Peso Mexicano
                    4) Peso Mexicano => Real Brasileño
                    5) Peso Argentino => Peso Mexicano
                    6) Peso Mexicano => Peso Argentino
                    7) Salir
                                    
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$     
                    ¿Qué opción desea? """);

            try {

//Entradas usuario
                seleccionDeUsuario = Integer.valueOf(entrada.nextLine());
                if (seleccionDeUsuario == 7) break;
                System.out.println("\nIngrese la cantidad a convertir: ");
                var montoAConvertir = Double.valueOf(entrada.nextLine());

                String parDivisas = switch (seleccionDeUsuario) {
                    case 1 -> "USD/MXN";
                    case 2 -> "MXN/USD";
                    case 3 -> "BRL/MXN";
                    case 4 -> "MXN/BRL";
                    case 5 -> "ARS/MXN";
                    case 6 -> "MXN/ARS";
                    default -> "";
                };

                URI direccion = URI.create("https://v6.exchangerate-api.com/v6/deaba5995f7f49ca093f1eed/pair/" + parDivisas);

// Cliente http
                HttpClient client = HttpClient.newHttpClient();
//Solicitud http
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(direccion)
                        .build();
// Respuesta http
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
                String baseCode = jsonObject.get("base_code").getAsString();
                String targetCode = jsonObject.get("target_code").getAsString();

                System.out.println("La conversión de " + parDivisas + " es: " + conversionRate);
                System.out.println("Por lo tanto " + montoAConvertir + " " + baseCode + " => " + montoAConvertir * conversionRate + " " + targetCode);
                System.out.println("\nDesea continuar? \n1)Sí \n7)Salir");
                seleccionDeUsuario = Integer.valueOf(entrada.nextLine());
            } catch (Exception e){
                System.out.println("Ocurrió un error del tipo " + e.getMessage());
            }
        }

        System.out.println("¡¡Hasta luego!!");

    }
}
