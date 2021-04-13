package abstractclass.gamecharacter;

public class BattleField {

    private int round;

    public boolean oneHitMy(Character attacker, Character defender) {
        attacker.primaryAttack(defender);
        attacker.secondaryAttack(defender);
        return  (attacker.isAlive() && defender.isAlive());
    }

    private boolean oneHit(Character attacker, Character defender) {
        if (attacker.isAlive() && defender.isAlive()) {
            attacker.primaryAttack(defender);
            attacker.secondaryAttack(defender);
        }
        return attacker.isAlive() && defender.isAlive();
    }

    public Character fightMy(Character one, Character other) {
        while (one.isAlive() || other.isAlive()) {
            oneHitMy(one, other);
            oneHitMy(other, one);
            round++;
        }
        if (one.isAlive()) {
            return one;
        }
        else {
            return other;
        }
    }

    public Character fight(Character one, Character other) {
        while(oneHit(one, other) && oneHit(other, one))
        {
            round++;
        }

        return one.isAlive() ? one : other;
    }

    public int getRound() {
        return round;
    }
}
