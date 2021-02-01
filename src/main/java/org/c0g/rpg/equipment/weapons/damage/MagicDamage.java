package org.c0g.rpg.equipment.weapons.damage;

public class MagicDamage implements DamageStrategy{
    private static final int BASE_DAMAGE = 25;
    private static final int LEVEL_DAMAGE = 2;

    @Override
    public int calculateDamage(int strength, int dexterity, int intelligence, int level) {
        return calculateBaseDamage(level) + (3 * intelligence);
    }

    @Override
    public int calculateBaseDamage(int level) {
        return BASE_DAMAGE + (LEVEL_DAMAGE * (level - 1));
    }
}
