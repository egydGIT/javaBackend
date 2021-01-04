package week05d02;

public class ChangeLetter {

    /*
    2020-11-24 (week05d02)
        A ChangeLetter osztályban írj meg egy String changeVowels(String) metódust,
        mely kicseréli a paraméterként átadott szövegben az angol magánhangzókat csillag (*) karakterre.
     */

    public String changeVowels(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a'
                    || str.charAt(i) == 'e'
                    || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                stringBuilder.append("*");
            }
            else {
                stringBuilder.append(str.substring(i, i+1));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ChangeLetter changeLetter = new ChangeLetter();
        System.out.println(changeLetter.changeVowels("apple"));
        System.out.println(changeLetter.changeVowels("colombus"));
    }

}
