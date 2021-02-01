package org.c0g.rpg.character;

public class CharacterFactory {
    //Ranger
    private static final int RANGER_HEALTH_BASE = 120;
    private static final int RANGER_HEALTH_LEVEL = 20;
    private static final int RANGER_STRENGTH_BASE = 5;
    private static final int RANGER_STRENGTH_LEVEL = 2;
    private static final int RANGER_DEXTERITY_BASE = 10;
    private static final int RANGER_DEXTERITY_LEVEL = 5;
    private static final int RANGER_INTELLIGENCE_BASE = 2;
    private static final int RANGER_INTELLIGENCE_LEVEL = 1;

    //Mage
    private static final int MAGE_HEALTH_BASE = 100;
    private static final int MAGE_HEALTH_LEVEL = 15;
    private static final int MAGE_STRENGTH_BASE = 2;
    private static final int MAGE_STRENGTH_LEVEL = 1;
    private static final int MAGE_DEXTERITY_BASE = 3;
    private static final int MAGE_DEXTERITY_LEVEL = 2;
    private static final int MAGE_INTELLIGENCE_BASE = 10;
    private static final int MAGE_INTELLIGENCE_LEVEL = 5;

    //Warrior
    private static final int WARRIOR_HEALTH_BASE = 150;
    private static final int WARRIOR_HEALTH_LEVEL = 30;
    private static final int WARRIOR_STRENGTH_BASE = 10;
    private static final int WARRIOR_STRENGTH_LEVEL = 5;
    private static final int WARRIOR_DEXTERITY_BASE = 3;
    private static final int WARRIOR_DEXTERITY_LEVEL = 2;
    private static final int WARRIOR_INTELLIGENCE_BASE = 1;
    private static final int WARRIOR_INTELLIGENCE_LEVEL = 1;

    public static PlayerCharacter createCharacter(String name, PlayerCharacterClass playerCharacterClass) {
        if (playerCharacterClass == null)
            throw new UnsupportedOperationException();

        PlayerClass playerClass = null;
        switch(playerCharacterClass) {
            case MAGE -> playerClass = new BasicClass("Mage", MAGE_HEALTH_BASE, MAGE_HEALTH_LEVEL, MAGE_STRENGTH_BASE, MAGE_STRENGTH_LEVEL, MAGE_DEXTERITY_BASE, MAGE_DEXTERITY_LEVEL, MAGE_INTELLIGENCE_BASE, MAGE_INTELLIGENCE_LEVEL);
            case RANGER -> playerClass = new BasicClass("Ranger", RANGER_HEALTH_BASE, RANGER_HEALTH_LEVEL, RANGER_STRENGTH_BASE, RANGER_STRENGTH_LEVEL, RANGER_DEXTERITY_BASE, RANGER_DEXTERITY_LEVEL, RANGER_INTELLIGENCE_BASE, RANGER_INTELLIGENCE_LEVEL);
            case WARRIOR -> playerClass = new BasicClass("Warrior", WARRIOR_HEALTH_BASE, WARRIOR_HEALTH_LEVEL, WARRIOR_STRENGTH_BASE, WARRIOR_STRENGTH_LEVEL, WARRIOR_DEXTERITY_BASE, WARRIOR_DEXTERITY_LEVEL, WARRIOR_INTELLIGENCE_BASE, WARRIOR_INTELLIGENCE_LEVEL);
        }

        return new BasicCharacter(playerClass, name);
    }
}
