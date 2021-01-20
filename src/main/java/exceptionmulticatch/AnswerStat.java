package exceptionmulticatch;

public class AnswerStat {

    BinaryStringConverter binaryStringConverter;
    private String answers;

    public AnswerStat(BinaryStringConverter binaryStringConverter, String answers) {
        this.binaryStringConverter = binaryStringConverter;
        this.answers = answers;
    }

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    int answerTruePercent(String answers) {
        boolean[] booleans = binaryStringConverter.binaryStringToBooleanArray(answers);
        int counterTrue = 0;
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i] == true) {
                counterTrue++;
            }
        }
        // int counterFalse = booleans.length - counterTrue;
        int statistic = Math.round(counterTrue * 100 / booleans.length);
        return statistic;
    }

    public boolean[] convert(String answers) {
        try {
            boolean[] booleans = binaryStringConverter.binaryStringToBooleanArray(answers);
            return booleans;
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException(ex);
        }
    }

    public String getAnswers() {
        return answers;
    }



    public static void main(String[] args) {
        AnswerStat answerStat = new AnswerStat(new BinaryStringConverter());
        System.out.println(answerStat.answerTruePercent("1111001001"));
    }
}
