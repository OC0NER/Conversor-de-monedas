import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Interfaz interfaz = new Interfaz();

        interfaz.muestraBienvenida();
        int salir = 1;
        while(salir != 2) {

            try{
                interfaz.muestraOpciones();
                interfaz.solicitaCodigoAconvertir();
                if (interfaz.getCodigoAConvertir().equalsIgnoreCase("SALIR")){
                    break;
                }
                interfaz.solicitaCodigoDestino();
                interfaz.solicitaCantidad();
                Conversor conversor = new Conversor(interfaz.getCodigoAConvertir(), interfaz.getCodigoDestino(), interfaz.getCantidad());
                salir = interfaz.continuar();
            } catch (Exception e) {
                System.out.println("""
                        \n
                        *********************************
                         Por favor ingresa datos válidos
                        *********************************
                        """);

            }

        }

        interfaz.muestraDespedida();

    }
}

