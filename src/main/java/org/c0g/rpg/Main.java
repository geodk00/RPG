package org.c0g.rpg;

import org.c0g.rpg.character.*;
import org.c0g.rpg.equipment.InventoryItem;
import org.c0g.rpg.equipment.EquipmentSlot;
import org.c0g.rpg.equipment.armor.ArmorFactory;
import org.c0g.rpg.equipment.weapons.WeaponFactory;
import org.c0g.rpg.equipment.armor.material.ArmorType;
import org.c0g.rpg.equipment.weapons.*;


public class Main {
    public static void main(String[] args) {
        //Create three characters
        PlayerCharacter playerWarrior = CharacterFactory.createCharacter("Bob", PlayerCharacterClass.WARRIOR);
        System.out.println(playerWarrior);

        PlayerCharacter playerMage = CharacterFactory.createCharacter("Alice", PlayerCharacterClass.MAGE);
        System.out.println(playerMage);

        PlayerCharacter playerRanger = CharacterFactory.createCharacter("Sally", PlayerCharacterClass.RANGER);
        System.out.println(playerRanger);

        //add xp to the warrior
        playerWarrior.addXp(2000);
        System.out.println(playerWarrior);

        //create three weapons of different types and equip them. the ranger will fail because of level check
        InventoryItem melee = WeaponFactory.createWeapon("Great Axe of the Exiled", 5, WeaponType.MELEE);
        InventoryItem ranged = WeaponFactory.createWeapon("Long Bow of the Lone Wolf", 10, WeaponType.RANGED);
        InventoryItem magic = WeaponFactory.createWeapon("Magic Wand of Ni", 1, WeaponType.MAGIC);

        System.out.println(melee);
        System.out.println(ranged);
        System.out.println(magic);

        playerWarrior.equip(melee);
        playerRanger.equip(ranged);
        playerMage.equip(magic);

        //Create three armor pieces and equip them on the warrior
        InventoryItem clothArmorLegs = ArmorFactory.createArmor("Cloth Leggings of the Magi", 4, EquipmentSlot.LEGS, ArmorType.CLOTH);
        InventoryItem plateArmorChest = ArmorFactory.createArmor("Plate Chest of the Juggernaut", 2, EquipmentSlot.BODY, ArmorType.PLATE);
        InventoryItem leatherArmorCap = ArmorFactory.createArmor("Cap of the Fox", 3, EquipmentSlot.HEAD, ArmorType.LEATHER);

        System.out.println(clothArmorLegs);
        System.out.println(plateArmorChest);
        System.out.println(leatherArmorCap);

        System.out.println(playerWarrior);
        System.out.println("Damage: " + playerWarrior.calculateDamage());

        playerWarrior.equip(clothArmorLegs);
        playerWarrior.equip(plateArmorChest);
        playerWarrior.equip(leatherArmorCap);

        System.out.println(playerWarrior);
        System.out.println("Damage: " + playerWarrior.calculateDamage());

        playerWarrior.equip(ranged);

        System.out.println(playerWarrior);
        System.out.println("Damage: " + playerWarrior.calculateDamage());
    }
}
