package controlselection.accents;

public class WhithoutAccents {
    // Saját megoldás (csak kisbetűs):
    public char changeAccent(char c) {
        char charToConsole;

        switch (c) {
            case 'á':
                charToConsole = 'a';
                break;
            case 'é':
                charToConsole = 'e';
                break;
            case 'í':
                charToConsole = 'i';
                break;
            case 'ó', 'ö', 'ő':
                charToConsole = 'o';
                break;
            case 'ú', 'ü', 'ű' :
                charToConsole = 'u';
                break;
            case 'a', 'e', 'i', 'o', 'u',
                'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z':
                charToConsole = c;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
        return charToConsole;
    }

    // Solution megoldás:
    public static final String LETTERS_WITH_ACCENTS = "áéíóöőúüűÁÉÍÓÖŐÚÜŰ";

    public static final String LETTERS_WITHOUT_ACCENTS = "aeiooouuuAEIOOOUUU";

    public char convertToCharWithoutAccents(char c) {
        int index = LETTERS_WITH_ACCENTS.indexOf(c);
        if (index >= 0) {
            return LETTERS_WITHOUT_ACCENTS.charAt(index);
        }
        else {
            return c;
        }
    }

    public static void main(String[] args) {
        // Saját megoldás:
        System.out.println(new WhithoutAccents().changeAccent('á'));
        System.out.println(new WhithoutAccents().changeAccent('é'));
        System.out.println(new WhithoutAccents().changeAccent('ü'));
        System.out.println(new WhithoutAccents().changeAccent('a'));
        System.out.println(new WhithoutAccents().changeAccent('t'));

        // Solution megoldás:
        System.out.println(new WhithoutAccents().convertToCharWithoutAccents('á'));
        System.out.println(new WhithoutAccents().convertToCharWithoutAccents('é'));
        System.out.println(new WhithoutAccents().convertToCharWithoutAccents('ü'));
        System.out.println(new WhithoutAccents().convertToCharWithoutAccents('a'));
        System.out.println(new WhithoutAccents().convertToCharWithoutAccents('t'));
    }
}
