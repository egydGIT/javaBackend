package collectionslist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {

    private int lotteryType;

    private int ballCount;

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType != 5 && lotteryType != 6 ) {
            throw new IllegalArgumentException("This type of lottery does not exist.");
        }
        if (lotteryType == 5 && ballCount != 90) {
            throw new IllegalArgumentException("Lottery 5 contains 90 balls.");
        }
        if (lotteryType == 6 && ballCount != 45) {
            throw new IllegalArgumentException("Lottery 6 contains 45 balls.");
        }

//        List<Integer> balls = new ArrayList<>();                           // random.nextInt()-el helyettesítem
//        for (int i = 0; i < ballCount; i++) {
//            balls.add(i);
//        }
//        Collections.shuffle(balls);

        Random random = new Random(8);                                  // seed a teszt miatt
        List<Integer> winnerNumbers = new ArrayList<>();
        int count = winnerNumbers.size();
        while (winnerNumbers.size() == 0 || winnerNumbers.size() < lotteryType) {
            int number = random.nextInt(ballCount) +1;
            if (!winnerNumbers.contains(number)) {
                winnerNumbers.add(number);
            }
        } count++;
        Collections.sort(winnerNumbers);
        return winnerNumbers;

    }


    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        System.out.println(lottery.selectWinningNumbers(5, 90));
        System.out.println(lottery.selectWinningNumbers(6, 45));
    }
}
