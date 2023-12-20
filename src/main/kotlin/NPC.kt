public abstract class NPCEnemy(
    agility: Int,
    damageResistance: Int,
    hitPoints: HitPoints,
    magicPoints: MagicPoints,
    name: String,
    statusResistance: Int,
    strength: Strength
) : Combatant(
    agility = minOf(255, maxOf(3, agility)),
    hitPoints = minOf(160, maxOf(3, hitPoints)),
    magicPoints = magicPoints,
    name = name,
    strength = minOf(140, maxOf(5, strength)),
) {
    public override val attackValue: Int
        get() = strength

    private final val damageResistance: Int = minOf(52, maxOf(1, damageResistance))

    public override val defenseValue: Int
        get() = agility / 2

    public final override val hurtResistance: Int

    public override val hurtScale: Int
        get() = 1

    private final val statusResistance: Int = minOf(255, maxOf(0, statusResistance))

    init {
        this.hurtResistance = (this.statusResistance shr 4) and 0xF
    }
}
