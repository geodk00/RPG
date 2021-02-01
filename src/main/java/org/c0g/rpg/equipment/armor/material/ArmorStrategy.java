package org.c0g.rpg.equipment.armor.material;

public interface ArmorStrategy {
    public int getHealth(int level);
    public int getStrength(int level);
    public int getDexterity(int level);
    public int getIntelligence(int level);
}
