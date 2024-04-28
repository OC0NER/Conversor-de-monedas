import java.util.Map;

public class Divisa {
    // Éste result es el resultado de la peticion a la api, puede ser "success" o "error"
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;
    private double conversionRate;

    public String getResult() {
        return result;
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}
