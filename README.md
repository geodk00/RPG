# Task 3 - RPG
This is an implementation of the RPG system described in task 3.

## Characters
The player characters are implemented using an interface (`PlayerCharacter`) and a concrete implementation of it (`BasicCharacter`)

A `PlayerCharacter` implementation has:
 - A name
 - A level
 - Experience Points
 - A Character Class
 - Equipment slots (armor/weapons)
 - Stats (Health, Strength, Intelligence & Dexterity)

The `PlayerCharacterClass` enum defines the available classes. `BasicCharacter` delegates all calculations of stats (using the strategy pattern) to the interface `PlayerClass`.

`PlayerClass` has a concrete implementation in `BasicClass`. 

The predefined classes (warrior, mage, ranger) are solely defined by data in the `CharacterFactory` class, which contains a static factory method. 

## Items
Items implement the interfaces `Weapon` and `Armor` which both inherit from the interface `InventoryItem`. This allows for the `equip()` method of `PlayerCharacter` to accept both weapons and armor.

Both armor and weapons use the Strategy Pattern. The implementations of the interfaces, `BasicArmor` and `BasicWeapon` delegate the actual computation to implementations of `ArmorStrategy` and `DamageStrategy`.

They also both use enums to define the different kinds of items (material for armor and weapon type for weapons) as well as static factory methods to create instances of them.

## NOTE
I have kept comments to a minimum since everything should be self-explanatory 

Some of my stats are slightly different, since I calculate them as base + (level - 1 * per_level) instead of base + (level * pr_level), since I think this way fits the description of "base" and "per level" better.