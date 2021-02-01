package org.c0g.rpg.equipment.weapons;

import org.c0g.rpg.equipment.InventoryItem;
import org.c0g.rpg.equipment.weapons.BasicWeapon;
import org.c0g.rpg.equipment.weapons.WeaponType;
import org.c0g.rpg.equipment.weapons.damage.MagicDamage;
import org.c0g.rpg.equipment.weapons.damage.MeleeDamage;
import org.c0g.rpg.equipment.weapons.damage.RangedDamage;

public class WeaponFactory {
    public static InventoryItem createWeapon(String name, int level, WeaponType weaponType) {
        InventoryItem item = null;
        switch(weaponType) {
            case MAGIC -> item = new BasicWeapon(level, name, weaponType, new MagicDamage());
            case MELEE -> item = new BasicWeapon(level, name, weaponType, new MeleeDamage());
            case RANGED -> item = new BasicWeapon(level, name, weaponType, new RangedDamage());
        }
        return item;
    }

}
