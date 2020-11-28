package controlselection.consonant;

public class ToConsonant {

    // Az én megoldésom:
    public char toConsonant(char c) {
        char charToConsole;

        switch (c) {
            case 'a':
                charToConsole = 'b';
                break;
            case 'e':
                charToConsole = 'f';
                break;
            case 'i':
                charToConsole = 'j';
                break;
            case 'o':
                charToConsole = 'p';
                break;
            case 'u':
                charToConsole = 'v';
                break;
            case 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z':
                charToConsole = c;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
        return charToConsole;
    }

    // Solution megoldás:
    public static final String VOWELS = "aeiou";

    public char convertToConsonant(char c) {
        if (VOWELS.indexOf(c) >= 0) {
            return (char) (c + 1);
        }
        else {
            return c;
        }
    }


    public static void main(String[] args) {
        ToConsonant toConsonant = new ToConsonant();

        // Az én megoldésom:
        System.out.println(toConsonant.toConsonant('a'));
        System.out.println(toConsonant.toConsonant('i'));
        System.out.println(toConsonant.toConsonant('l'));
        System.out.println(toConsonant.toConsonant('s'));

        // Solution megoldás:
        System.out.println(toConsonant.convertToConsonant('b'));
        System.out.println(toConsonant.convertToConsonant('e'));

    }

}
