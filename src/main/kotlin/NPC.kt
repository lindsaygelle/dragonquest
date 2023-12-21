import kotlin.math.exp

public abstract class NPCEnemy(
    agility: Int,
    damageResistance: Int,
    experiencePoints: Int,
    goldPoints: Int,
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
), AttributeExperiencePoints, AttributeGoldPoints {
    public override val attackValue: Int
        get() = strength

    private final val damageResistance: Int = minOf(52, maxOf(1, damageResistance))

    public override val defenseValue: Int
        get() = agility / 2

    public final override var experiencePoints: ExperiencePoints = minOf(100, maxOf(0, experiencePoints))

    public final override var goldPoints: GoldPoints = minOf(200, maxOf(2, goldPoints))

    public final override val hurtResistance: Int = (this.damageResistance shr 4) and 0xF

    public override val hurtScale: Int
        get() = 1

    public final override val sleepResistance: Int

    private final val statusResistance: Int = minOf(255, maxOf(0, statusResistance))

    public final override val stopSpellResistance: Int

    init {
        this.sleepResistance = (this.statusResistance shr 4) and 0xF
        this.stopSpellResistance = (this.statusResistance and 0xF)
    }
}
