package org.c0g.rpg.character;

import org.c0g.rpg.equipment.InventoryItem;

public interface PlayerCharacter {
    void equip(InventoryItem item);
    int calculateDamage();
    int xpToNextLevel();
    void addXp(int xpAmount);
    int getPlayerLevel();
    int getHealth();
    int getStrength();
    int getDexterity();
    int getIntelligence();
    String getPlayerClass();
}
