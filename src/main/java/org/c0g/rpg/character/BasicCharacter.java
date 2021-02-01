package org.c0g.rpg.character;

import org.c0g.rpg.equipment.armor.Armor;
import org.c0g.rpg.equipment.InventoryItem;
import org.c0g.rpg.equipment.EquipmentSlot;
import org.c0g.rpg.equipment.weapons.Weapon;

public class BasicCharacter implements PlayerCharacter {
    private final PlayerClass playerClass;
    private final String name;
    private int playerLevel;
    private int xp;

    private Weapon weapon;
    private Armor head;
    private Armor body;
    private Armor legs;

    public BasicCharacter(PlayerClass playerClass, String name) {
        if (playerClass == null || name == null)
            throw new UnsupportedOperationException();

        this.playerLevel = 1;
        this.xp = 0;
        this.playerClass = playerClass;
        this.name = name;
    }

    @Override
    public void equip(InventoryItem item) {
        if (item.getLevel() > getPlayerLevel()) {
            System.out.println("Minimum level requirement not met");
        } else if (item.getSlot() == EquipmentSlot.WEAPON && item instanceof Weapon) {
            this.weapon = (Weapon)item;
        } else if (item.getSlot() == EquipmentSlot.HEAD && item instanceof Armor) {
            this.head = (Armor)item;
        } else if (item.getSlot() == EquipmentSlot.BODY && item instanceof Armor) {
            this.body = (Armor)item;
        } else if (item.getSlot() == EquipmentSlot.LEGS && item instanceof Armor) {
            this.legs = (Armor)item;
        } else {
            System.out.println("Invalid item");
        }
    }

    @Override
    public int calculateDamage() {
        if (weapon == null)
            return 0;
        return weapon.getDamage(getStrength(), getDexterity(), getIntelligence());
    }

    //Calculated as compound interest
    @Override
    public int xpToNextLevel() {
       return (int)(100 * Math.pow(1.1, (playerLevel - 1)));
    }

    @Override
    public void addXp(int xpAmount) {
        xp += xpAmount;

        while(xp > xpToNextLevel()) {
            xp -= xpToNextLevel();
            playerLevel++;
        }
    }

    @Override
    public int getPlayerLevel() {
        return playerLevel;
    }

    @Override
    public int getHealth() {
        int hitPoints = 0;
        if (playerClass != null)
            hitPoints += playerClass.getHealth(playerLevel);
        if (head != null)
            hitPoints += head.getHealth();
        if (body != null)
            hitPoints += body.getHealth();
        if (legs != null)
            hitPoints += legs.getHealth();
        return hitPoints;
    }

    @Override
    public int getStrength() {
        int strength = 0;
        if (playerClass != null)
            strength += playerClass.getStrength(playerLevel);
        if (head != null)
            strength += head.getStrength();
        if (body != null)
            strength += body.getStrength();
        if (legs != null)
            strength += legs.getStrength();
        return strength;
    }

    @Override
    public int getDexterity() {
        int dexterity = 0;
        if (playerClass != null)
            dexterity += playerClass.getDexterity(playerLevel);
        if (head != null)
            dexterity += head.getDexterity();
        if (body != null)
            dexterity += body.getDexterity();
        if (legs != null)
            dexterity += legs.getDexterity();
        return dexterity;
    }

    @Override
    public int getIntelligence() {
        int intelligence = 0;
        if (playerClass != null)
            intelligence += playerClass.getIntelligence(playerLevel);
        if (head != null)
            intelligence += head.getIntelligence();
        if (body != null)
            intelligence += body.getIntelligence();
        if (legs != null)
            intelligence += legs.getIntelligence();
        return intelligence;
    }

    @Override
    public String getPlayerClass() {
        return playerClass.getName();
    }

    @Override
    public String toString() {
        return String.format("%s details:%n" +
                "Name: %s%n" +
                "HP: %3d%n" +
                "Str: %3d%n" +
                "Dex: %3d%n" +
                "Int: %3d%n" +
                "Lvl: %3d%n" +
                "XP to next: %3d%n" +
                "Weapon: %s%n" +
                "Head: %s%n" +
                "Body: %s%n" +
                "Legs: %s%n",
                getPlayerClass(), name, getHealth(), getStrength(),
                getDexterity(), getIntelligence(), getPlayerLevel(), xpToNextLevel(),
                weapon == null? "None":weapon.getName(),
                head == null? "None":head.getName(),
                body == null? "None":body.getName(),
                legs == null? "None":legs.getName() );
    }






}
