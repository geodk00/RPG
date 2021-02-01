package org.c0g.rpg.equipment.weapons;

import org.c0g.rpg.equipment.InventoryItem;

public interface Weapon extends InventoryItem {
    int getDamage(int strength, int dexterity, int intelligence);
}
