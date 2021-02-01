package org.c0g.rpg.equipment.armor;

import org.c0g.rpg.equipment.InventoryItem;

public interface Armor extends InventoryItem {
    public int getHealth();
    public int getStrength();
    public int getDexterity();
    public int getIntelligence();
}
