public abstract class Enemy<T : Combatant>(
    agility: Int,
    damageResistance: Int,
    hitPoints: HitPoints,
    magicPoints: MagicPoints,
    name: String,
    statusResistance: Int,
    strength: Strength
) : NPCEnemy(
    agility = agility,
    damageResistance = damageResistance,
    hitPoints = (hitPoints - (((0..256).random() * hitPoints) shr 10)),
    magicPoints = magicPoints,
    name = name,
    statusResistance = statusResistance,
    strength = strength,
) {
    public abstract val spells: List<Action<T>>
}

public final class EnemyMagician : Enemy<Player>(
    agility = 12,
    damageResistance = 1,
    hitPoints = 13,
    magicPoints = 2,
    name = "Magician",
    statusResistance = 0,
    strength = 11
), TraitHurtInvoker {
    override val hurtRequirement: Int
        get() = 1

    override val hurtValue: Int
        get() = ((0..256).random() and 0x07) + 0x03

    override val spells: List<Action<Player>> = listOf(SpellHurt(this))
}
