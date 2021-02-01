package org.c0g.rpg.equipment.armor;

import org.c0g.rpg.equipment.EquipmentSlot;
import org.c0g.rpg.equipment.InventoryItem;
import org.c0g.rpg.equipment.armor.material.*;

public class ArmorFactory {
    public static InventoryItem createArmor(String name, int level, EquipmentSlot equipmentSlot, ArmorType armorType) {
        if (armorType == null)
            throw new UnsupportedOperationException();

        ArmorStrategy armorMaterial = null;
        switch (armorType) {
            case CLOTH -> armorMaterial = new ClothMaterial();
            case PLATE -> armorMaterial = new PlateMaterial();
            case LEATHER -> armorMaterial = new LeatherMaterial();
        }
        return new BasicArmor(level, name, armorType, equipmentSlot, armorMaterial);
    }
}
