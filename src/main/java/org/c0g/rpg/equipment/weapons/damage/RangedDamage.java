package org.c0g.rpg.equipment.weapons.damage;

public class RangedDamage implements DamageStrategy{
    private static final int BASE_DAMAGE = 5;
    private static final int LEVEL_DAMAGE = 3;

    @Override
    public int calculateDamage(int strength, int dexterity, int intelligence, int level) {
        return calculateBaseDamage(level) + (2 * dexterity);
    }

    @Override
    public int calculateBaseDamage(int level) {
        return BASE_DAMAGE + (LEVEL_DAMAGE * (level - 1));
    }
}
