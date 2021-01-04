package week05d02;

public class ChangeLetterTutorial {

    private static final String VOWELS = "aeiou";
    private static final String REPLACED_CHAR = "*";

    public String ChangeVowels(String target) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            String c = target.substring(i, i+1);
            if (VOWELS.contains(c)) {
                stringBuilder.append(REPLACED_CHAR);
            }
            else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }


}
