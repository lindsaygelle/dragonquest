public open class Player(
    agility: Int = 1,
    hitPoints: HitPoints = 10,
    magicPoints: MagicPoints = 10,
    name: String = "Player",
    strength: Strength = 10,
) : Combatant(
    agility = agility, hitPoints = hitPoints, magicPoints = magicPoints, name = name, strength = strength
), AttributeArmorValue, AttributeShieldValue, AttributeWeaponValue, TraitHurtInvoker {

    public override val armorValue: Int
        get() = 0

    public override val attackValue: Int
        get() = strength + weaponValue

    public override val defenseValue: Int
        get() = (agility / 2) + armorValue + shieldValue

    public override val hurtRequirement: Int
        get() = (0..15).random()

    public override val hurtResistance: Int = 0

    public override val hurtValue: Int
        get() = ((0..256).random() and 0x07) + 0x05

    public override val hurtScale: Int
        get() = 1

    public override val shieldValue: Int
        get() = 0

    public override val weaponValue: Int
        get() = 0
}
