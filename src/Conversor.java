import com.google.gson.Gson;

import java.io.IOException;

public class Conversor {
    private String codigoAconvertir;
    private String codigoDestino;
    private double cantidad;
    private double resultado;
    private double conversionRate;

    public Conversor(String codigoAconvertir, String codigoDestino, double cantidad) throws IOException, InterruptedException {
        this.codigoAconvertir = codigoAconvertir;
        this.codigoDestino = codigoDestino;
        this.cantidad = cantidad;

        Http http = new Http(codigoAconvertir);
        //System.out.println(http.getJson());
        Gson gson = new Gson();
        Divisa divisa = gson.fromJson(http.getJson(), Divisa.class);
        conversionRate = divisa.getConversion_rates().get(codigoDestino);
        resultado = cantidad * conversionRate;

        System.out.println(
                "\nUn " + codigoAconvertir + " vale " + conversionRate
                        + " " + codigoDestino + "\nPor lo tanto " + cantidad + " " + codigoAconvertir +
                        " equivalen a " + resultado + " " + codigoDestino
        );

    }
}