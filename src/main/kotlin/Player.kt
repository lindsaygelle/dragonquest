public open class Player(
    agility: Int,
    public final var armor: Armor?,
    hitPoints: Int,
    magicPoints: Int,
    name: String,
    public final var shield: Shield?,
    strength: Int,
    public final var weapon: Weapon?,
) :
    Character(
        agility = agility,
        hitPoints = hitPoints,
        magicPoints = magicPoints,
        name = name,
        strength = strength,
    ) {

    public final override val attackScore: Int
        get() = (strength + weaponPoints)

    public final val armorPoints: Int
        get() = (armor?.defense ?: 0)

    public final override val defenseScore: Int
        get() = ((agility / 2) + (armorPoints + shieldPoints))

    public final val shieldPoints: Int
        get() = (shield?.defense ?: 0)

    public final val weaponPoints: Int
        get() = (weapon?.attack ?: 0)
}
