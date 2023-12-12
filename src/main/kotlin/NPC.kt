public abstract class NPC(
    actions: MutableList<Action>,
    agility: UInt,
    damageResistance: UInt,
    experiencePoints: UInt,
    goldPoints: UInt,
    hitPoints: UInt,
    magicPoints: UInt,
    name: String,
    statusResistance: UInt,
    strength: UInt,
) : Character(
    actions = actions,
    agility = minOf(255u, maxOf(3u, agility)),
    category = Category.NPC,
    experiencePoints = experiencePoints,
    goldPoints = goldPoints,
    hitPoints = minOf(160u, maxOf(3u, hitPoints)),
    magicPoints = magicPoints,
    name = name,
    strength = minOf(140u, maxOf(5u, strength)),
) {

    public final override val attackScore: Int
        get() = strength

    public final override val defenseScore: Int
        get() = (agility / 2)

    public final var damageResistance: Int = maxOf(0u, minOf(5u, damageResistance)).toInt()

    public final val hurtResistance: Int
        get() = (this.damageResistance and 0xF)

    public final val sleepResistance: Int
        get() = (this.statusResistance shr 4 and 0xF)

    public final val statusResistance: Int = maxOf(0u, minOf(255u, statusResistance)).toInt()

    public final val stopSpellResistance: Int
        get() = (this.statusResistance and 0xF)
}
