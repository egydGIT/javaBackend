package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {

    public static final int SECONDARY_DAMAGE_MULTIPLIER = 2;

    public AxeWarrior(Point position, Random random) {
        super(position, random);
    }

    private int getActualSecondaryDamage() {
        // return getRandom().nextInt(getActualPrimaryDamage() * 2) + 1;
        return (int)(Math.random() * SECONDARY_DAMAGE_MULTIPLIER * getActualPrimaryDamage());
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if (this.getPosition().distance(enemy.getPosition()) <= 2) {
            hit(enemy, getActualSecondaryDamage());
        }
    }
}
