public open class Player(
    agility: Int = 1,
    experiencePoints: ExperiencePoints = 0,
    goldPoints: GoldPoints = 0,
    hitPoints: HitPoints = 10,
    magicPoints: MagicPoints = 10,
    name: String = "Player",
    strength: Strength = 10,
) : Combatant(
    agility = agility, hitPoints = hitPoints, magicPoints = magicPoints, name = name, strength = strength
), AttributeArmorValue, AttributeExperiencePoints, AttributeGoldPoints, AttributeShieldValue, AttributeWeaponValue,
    TraitSpellHurtInvoker, TraitSpellSleepInvoker, TraitSpellStopSpellInvoker {

    public final override val armorValue: Int
        get() = 0

    public final override val attackValue: Int
        get() = strength + weaponValue

    public final override val defenseValue: Int
        get() = (agility / 2) + (armorValue + shieldValue)

    public override var experiencePoints: ExperiencePoints = experiencePoints
        set(value) {
            if ((field + value) >= experiencePointsMaximum) {
                // TODO
                // Level Up
                // Carry points forward to next level
            }
            field = value
        }

    private final var experiencePointsMaximum: ExperiencePoints = 10
        set(value) {
            field = maxOf(0, value)
        }
    public override var goldPoints: GoldPoints = goldPoints
        set(value) {
            field = maxOf(0, value)
        }

    public final override val hurtRequirement: Int
        get() = (0..15).random()

    public final override val hurtResistance: Int = 0

    public final override val hurtValue: Int
        get() = ((0..256).random() and 0x07) + 0x05

    public final override val hurtScale: Int
        get() = 1

    public final override val shieldValue: Int
        get() = 0

    override val sleepRequirement: Int
        get() = (0..15).random()

    public final override val sleepResistance: Int = 0 // Need to add armor check

    override val stopSpellRequirement: Int
        get() = (0..15).random()

    public final override val stopSpellResistance: Int = 1 // Need to add armor check

    public final override val weaponValue: Int
        get() = 0
}
