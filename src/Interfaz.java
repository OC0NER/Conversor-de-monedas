import java.util.Scanner;

public class Interfaz {
    Scanner lectura = new Scanner(System.in);

    private String codigoAConvertir = "inicio";
    private String codigoDestino;
    private double cantidad;
    private int continuar;

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public String getCodigoAConvertir() {
        return codigoAConvertir;
    }

    public double getCantidad() {
        return cantidad;
    }

    private String bienvenida = """
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
   
                    CONVER$OR DE DIVI$A$
    
            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            """;


    private String ejemplosDeCodigos = """

            Ejemplos de códigos de moneda:
            
            * Código de moneda        * Nombre de la moneda
                 
             ARS             =>         Peso Argentino
             AUD             =>         Dólar Australiano
             SYP             =>         Libra Siria
             VES             =>         Bolívar Soberano venezolano
             USD             =>         Dólar Estadounidense
             MXN             =>         Peso Mexicano
             .
             .
             . etc.         
             
             Si deseas salir escribe "SALIR"
             
            """;

    void muestraBienvenida() {
        System.out.println(bienvenida);
    }

    void muestraOpciones() {
        System.out.println(ejemplosDeCodigos);
    }

    void solicitaCodigoAconvertir() {
        System.out.println("Ingresa el codigo de la moneda de origen: ");
        codigoAConvertir = lectura.next().toUpperCase();
    }

    void solicitaCodigoDestino () {
        System.out.println("Ingresa el codigo de la moneda de destino: ");
        codigoDestino = lectura.next().toUpperCase();
    }

    void solicitaCantidad() {
        System.out.println("¿Cuántos " + codigoAConvertir + " deseas convertir a " + codigoDestino + " ? ");
        cantidad = lectura.nextDouble();
    }

    int continuar() {
        System.out.println("\n¿Desea continuar? \n Continuar: Presione 1\n Salir: Presione 2 ");
        continuar = lectura.nextInt();
        System.out.println(continuar);
        return continuar;
    }

    void muestraDespedida() {
        System.out.println(
                """
                   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                            Gracias por usar

                           CONVER$OR DE DIVI$A$

                           !! Hasta luego !!
                   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                """);
    }

}