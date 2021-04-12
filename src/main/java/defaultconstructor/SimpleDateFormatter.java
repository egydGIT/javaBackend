package defaultconstructor;

public class SimpleDateFormatter {

    public static final String SEPARATOR = "-";   // statikus attr. - így elkerülhető az elírás
    private CountryCode defaultCountry;           // alapértelmezett országkód attr. deklarálás

    public SimpleDateFormatter() {                // alapértelmezett országkód beállítása par.nélküli konstruktorban
        this.defaultCountry = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {     // dátumot az alapérelmezett országkód alapján állítja be
        return formatDateStringByCountryCode(defaultCountry, simpleDate);
    }
                                                                // dátumot a par-ben átadott orsz.kód alapján állítja be
    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        if (countryCode == CountryCode.HU) {
            return simpleDate.getYear() + SEPARATOR + simpleDate.getMonth() + SEPARATOR + simpleDate.getDay();
        } else if (countryCode == CountryCode.EN) {
            return simpleDate.getDay() + SEPARATOR + simpleDate.getMonth() + SEPARATOR + simpleDate.getYear();
        } else {
            return simpleDate.getMonth() + SEPARATOR + simpleDate.getDay() + SEPARATOR + simpleDate.getYear();
        }
    }

    public static void main(String[] args) {
        SimpleDate simpleDate = new SimpleDate();
        simpleDate.setDate(2020, 12, 8);
        System.out.println("toString: " + simpleDate);                       // toString: 2020, 12, 8
                                                                             // formatDateString: 2020-12-8
        System.out.println("formatDateString: " + new SimpleDateFormatter().formatDateString(simpleDate));
        System.out.println("formatDateStringByCountryCode: "
                + new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.US, simpleDate));
    }                                                                       // formatDateStringByCountryCode: 12-8-2020
}
