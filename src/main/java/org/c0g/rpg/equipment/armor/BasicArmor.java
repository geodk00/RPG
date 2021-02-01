package org.c0g.rpg.equipment.armor;

import org.c0g.rpg.equipment.EquipmentSlot;
import org.c0g.rpg.equipment.armor.material.ArmorStrategy;
import org.c0g.rpg.equipment.armor.material.ArmorType;

public class BasicArmor implements Armor{
    private static final double SCALE_BODY = 1.0;
    private static final double SCALE_HEAD = 0.8;
    private static final double SCALE_LEGS = 0.6;

    private final int level;
    private final String name;
    private final ArmorType type;
    private final EquipmentSlot slot;
    private final ArmorStrategy material;

    public BasicArmor(int level, String name, ArmorType type, EquipmentSlot slot, ArmorStrategy material) {
        if (slot == EquipmentSlot.WEAPON || material == null)
            throw new UnsupportedOperationException();

        this.name = name;
        this.type = type;
        this.slot = slot;
        this.level = level;
        this.material = material;
    }

    private double getScale() {
        double scale;

        switch(slot) {
            case BODY -> scale = SCALE_BODY;
            case HEAD -> scale = SCALE_HEAD;
            case LEGS -> scale = SCALE_LEGS;
            default -> scale = 1;
        }
        return scale;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public EquipmentSlot getSlot() {
        return slot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        if (material != null)
            return (int)(getScale() * material.getHealth(level));
        return 0;
    }

    @Override
    public int getStrength() {
        if (material != null)
            return (int)(getScale() * material.getStrength(level));
        return 0;
    }

    @Override
    public int getDexterity() {
        if (material != null)
            return (int)(getScale() * material.getDexterity(level));
        return 0;
    }

    @Override
    public int getIntelligence() {
        if (material != null)
            return (int)(getScale() * material.getIntelligence(level));
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Item stats for: %s%nArmor Type: %s%nSlot: %s%nArmor level: %d%nBonus HP: %d%nBonus Str: %d%nBonus Dex: %d%nBonus Int: %d%n", name, type, slot, level, getHealth(), getStrength(), getDexterity(), getIntelligence());
    }
}
