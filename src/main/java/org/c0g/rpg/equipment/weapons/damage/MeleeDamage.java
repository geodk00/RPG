package org.c0g.rpg.equipment.weapons.damage;

public class MeleeDamage implements DamageStrategy{
    private static final int BASE_DAMAGE = 15;
    private static final int LEVEL_DAMAGE = 2;

    @Override
    public int calculateDamage(int strength, int dexterity, int intelligence, int level) {
        return (int)(calculateBaseDamage(level) + strength * 1.5);
    }

    @Override
    public int calculateBaseDamage(int level) {
        return (BASE_DAMAGE + (LEVEL_DAMAGE * (level - 1)));
    }
}
