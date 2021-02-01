package org.c0g.rpg.equipment.weapons.damage;

public interface DamageStrategy {
    public int calculateDamage(int strength, int dexterity, int intelligence, int level);
    public int calculateBaseDamage(int level);
}
