import kotlin.random.Random

public open class Enemy(
    agilityMaximum: Int,
    experiencePointsMaximum: Int,
    goldPointsMaximum: Int,
    hitPointsMaximum: Int,
    magicPointsMaximum: Int,
    name: String,
    public final val statusResistanceMaximum: Int,
    strengthMaximum: Int,
) : Character(
    agilityMaximum,
    Actor.Category.NPC,
    experiencePointsMaximum,
    goldPointsMaximum,
    // Dragonlord can always have the maximum hit points. Everyone else is scaled.
    // This feels kinda clunky to have here. But it allows me to keep Character clean.
    if (name == "Dragonlord") hitPointsMaximum else hitPointsMaximum - ((Random.nextInt(
        0,
        256
    ) * hitPointsMaximum) shr 10),
    magicPointsMaximum,
    name,
    strengthMaximum
) {
    public final override val agility: Int
        // Calculate agility to be currently the max.
        // Could implement scaling and changes based on battle conditions.
        get() = agilityMaximum

    // Calculate using gold scaling formula. Replace when experience formula is found.
    public final val experienceReward: Int =
        (((Random.nextInt(0, 64) + 0xC0) * experiencePointsMaximum) / 256) + 1


    // goldReward uses the Dragon Quest gold formula (GP * ((0..63 & 0x3F) + 0xC0)) >> 8
    // Add 1 for some reward? Could toggle this as some difficulty scaling thing.
    public final val goldReward: Int =
        (((Random.nextInt(0, 64) + 0xC0) * goldPointsMaximum) / 256) + 1

    public final override val sleepResistance: Int =
        (statusResistanceMaximum shr 4) and 0xF // Get first nibble (nybble) of statusResistanceMaximum.

    public final override val strength: Int
        // Calculate strength to be currently the max.
        // Could implement scaling and changes based on battle conditions.
        get() = strengthMaximum
}
