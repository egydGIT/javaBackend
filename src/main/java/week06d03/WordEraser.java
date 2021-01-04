package week06d03;

public class WordEraser {
    /*
    Junior
    A WordEraser osztályban legyen egy eraseWord(String words, String word) metódus,
    mely az első paraméter szöveget úgy változtatja meg, hogy a második paraméter összes előforulását kitörli belőle.
    A words paraméterben a szavak szóközzel vannak elválasztva.
    A metódus térjen vissza a törölni kívánt szavak nélküli Stringgel.
    (Mellőzzük a replace és replaceAll használatát!)
     */

    public String eraseWord(String words, String word) {
        String [] wordsArray = words.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w: wordsArray) {
            if (!w.equals(word)) {
                sb.append(w + " ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String words = "A kva java tanulás kva jó!";
        WordEraser wordEraser = new WordEraser();
        System.out.println(wordEraser.eraseWord(words, "kva"));
    }

}
