public open class Enemy(
    agility: Int,
    damageResistance: Int,
    hitPoints: Int,
    magicPoints: Int,
    public override final var name: String,
    statusResistance: Int,
    strength: Int,
) :
    Character(
        agility = minOf(255, maxOf(3, agility)),
        hitPoints = minOf(160, maxOf(3, hitPoints)),
        magicPoints = magicPoints,
        name = name,
        strength = minOf(140, maxOf(5, strength)),
    ) {

    public final override val attackScore: Int
        get() = strength

    public final var damageResistance: Int = maxOf(0, minOf(5, damageResistance))
    public final override val defenseScore: Int
        get() = (agility / 2)

    public final val hurtResistance: Int

    public final val sleepResistance: Int
    public final val statusResistance: Int = maxOf(0, minOf(255, statusResistance))
    public final val stopSpellResistance: Int

    init {
        hurtResistance = (this.damageResistance and 0xF)
        sleepResistance = (this.statusResistance shr 4) and 0xF
        stopSpellResistance = (this.statusResistance and 0xF)
    }
}
