package interfacedefaultmethods;

public class Printer {

    Printable printable;

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for ( int i = 0; i < printable.getLength(); i++) {
            if (printable.getColor(i).equals(Printable.DEFAULT_COLOUR_BLACK)) {
                stringBuilder.append(printable.getPage(i)).append("\n");
            }
            if (!printable.getColor(i).equals(Printable.DEFAULT_COLOUR_BLACK)) {
                stringBuilder.append("[" + printable.getColor(i) + "]").append(printable.getPage(i)).append("\n");
            }
        }
        return stringBuilder.toString();
    }

}
