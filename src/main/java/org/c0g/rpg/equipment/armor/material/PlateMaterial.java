package org.c0g.rpg.equipment.armor.material;

public class PlateMaterial implements ArmorStrategy{
    private static final int HP_BASE = 30;
    private static final int HP_LVL = 12;
    private static final int STR_BASE = 3;
    private static final int STR_LVL = 2;
    private static final int DEX_BASE = 1;
    private static final int DEX_LVL = 1;
    private static final int INT_BASE = 0;
    private static final int INT_LVL = 0;

    @Override
    public int getHealth(int level) {
        return (HP_BASE + ((level - 1) * HP_LVL));
    }

    @Override
    public int getStrength(int level) {
        return (STR_BASE + ((level - 1) * STR_LVL));
    }

    @Override
    public int getDexterity(int level) {
        return (DEX_BASE + ((level - 1) * DEX_LVL));
    }

    @Override
    public int getIntelligence(int level) {
        return (INT_BASE + ((level - 1) * INT_LVL));
    }
}
