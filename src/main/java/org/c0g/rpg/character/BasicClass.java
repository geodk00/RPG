package org.c0g.rpg.character;

public class BasicClass implements PlayerClass {
    private final int healthBase;
    private final int healthLevel;
    private final int strengthBase;
    private final int strengthLevel;
    private final int dexterityBase;
    private final int dexterityLevel;
    private final int intelligenceBase;
    private final int intelligenceLevel;
    private final String name;

    public BasicClass(String name, int healthBase, int healthLevel, int strengthBase, int strengthLevel, int dexterityBase, int dexterityLevel, int intelligenceBase, int intelligenceLevel) {
        this.name = name;
        this.healthBase = healthBase;
        this.healthLevel = healthLevel;
        this.strengthBase = strengthBase;
        this.strengthLevel = strengthLevel;
        this.dexterityBase = dexterityBase;
        this.dexterityLevel = dexterityLevel;
        this.intelligenceBase = intelligenceBase;
        this.intelligenceLevel = intelligenceLevel;
    }

    @Override
    public int getHealth(int level) {
        return healthBase + (healthLevel * (level - 1));
    }

    @Override
    public int getStrength(int level) {
        return strengthBase + (strengthLevel * (level - 1));
    }

    @Override
    public int getDexterity(int level) {
        return dexterityBase + (dexterityLevel * (level - 1));
    }

    @Override
    public int getIntelligence(int level) {
        return intelligenceBase + (intelligenceLevel * (level - 1));
    }

    @Override
    public String getName() {
        return name;
    }
}
