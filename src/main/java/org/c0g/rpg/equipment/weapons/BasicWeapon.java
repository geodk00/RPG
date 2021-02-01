package org.c0g.rpg.equipment.weapons;

import org.c0g.rpg.equipment.EquipmentSlot;
import org.c0g.rpg.equipment.weapons.damage.DamageStrategy;

public class BasicWeapon implements Weapon{
    private final int level;
    private final String name;
    private final WeaponType weaponType;
    private final DamageStrategy damageStrategy;

    public BasicWeapon(int level, String name, WeaponType weaponType, DamageStrategy damageStrategy) {
        if (damageStrategy == null || weaponType == null)
            throw new UnsupportedOperationException();

        this.level = level;
        this.name = name;
        this.weaponType = weaponType;
        this.damageStrategy = damageStrategy;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public EquipmentSlot getSlot() {
        return EquipmentSlot.WEAPON;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage(int strength, int dexterity, int intelligence) {
        return damageStrategy.calculateDamage(strength, dexterity, intelligence, level);
    }

    @Override
    public String toString() {
        return String.format("Item stats for: %s%nWeapon type: %s%nWeapon level: %d%nDamage: %d%n", name, weaponType, level, damageStrategy.calculateBaseDamage(level));
    }
}
