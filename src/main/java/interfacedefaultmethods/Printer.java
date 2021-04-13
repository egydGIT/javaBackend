package interfacedefaultmethods;

public class Printer {

    Printable printable;

    public String printMy() {
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

    public String print(Printable printable) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < printable.getLength(); i++) {
            if (!Printable.DEFAULT_COLOUR_BLACK.equals(printable.getColor(i))) {
                sb.append("["  + printable.getColor(i) + "]");
            }
            sb.append(printable.getPage(i)).append("\n");
        }
        return sb.toString();
    }

}
