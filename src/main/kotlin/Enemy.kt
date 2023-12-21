public fun calculateSpellHurtEnemy(): Int {
    return ((0..256).random() and 0x07) + 0x03
}

public fun calculateSpellStopSpellEnemy(): Int {
    return (0..1).random()
}

public abstract class Enemy(
    agility: Int,
    damageResistance: Int,
    experiencePoints: Int,
    goldPoints: Int,
    hitPoints: HitPoints,
    magicPoints: MagicPoints,
    name: String,
    statusResistance: Int,
    strength: Strength
) : NPCEnemy(
    agility = agility,
    damageResistance = damageResistance,
    experiencePoints = experiencePoints,
    goldPoints = (goldPoints * (((0..256).random() and 0x3F) + 0xC0)) shr 8,
    hitPoints = hitPoints - (((0..256).random() * hitPoints) shr 10),
    magicPoints = magicPoints,
    name = name,
    statusResistance = statusResistance,
    strength = strength,
) {
    protected abstract val combatSpells: Map<Spell.Name, Action<Combatant>>

    public abstract fun attack(combatant: Combatant)
}

public final class EnemyMagician : Enemy(
    agility = 12,
    damageResistance = 1,
    experiencePoints = 4,
    goldPoints = 1,
    hitPoints = 13,
    magicPoints = 2,
    name = "Magician",
    statusResistance = 0,
    strength = 11
), TraitSpellHurtInvoker {

    override val combatSpells: Map<Spell.Name, Action<Combatant>> = mapOf(Spell.Name.HURT to SpellHurt(this))

    override val hurtRequirement: Int = 1

    override val hurtValue: Int
        get() = calculateSpellHurtEnemy()

    public override fun attack(combatant: Combatant) {
        combatSpells[Spell.Name.HURT]?.use(combatant) // TODO implement check
    }
}

public final class EnemyWarlock : Enemy(
    agility = 22,
    damageResistance = 9,
    experiencePoints = 2,
    goldPoints = 1,
    hitPoints = 30,
    magicPoints = 18,
    name = "Warlock",
    statusResistance = 4,
    strength = 28
), TraitSpellHurtInvoker, TraitSpellSleepInvoker {

    override val combatSpells: Map<Spell.Name, Action<Combatant>> =
        mapOf(Spell.Name.HURT to SpellHurt(this), Spell.Name.SLEEP to SpellSleep(this))

    override val hurtRequirement: Int = 1
    override val hurtValue: Int
        get() = calculateSpellHurtEnemy()

    override val sleepRequirement: Int = 1

    public override fun attack(combatant: Combatant) {
        combatSpells[Spell.Name.SLEEP]?.use(combatant)
    }
}

public final class EnemyWolfLord : Enemy(
    agility = 36,
    damageResistance = 1,
    experiencePoints = 2,
    goldPoints = 2,
    hitPoints = 38,
    magicPoints = 96,
    name = "Wolflord",
    statusResistance = 7,
    strength = 50
), TraitSpellStopSpellInvoker {

    override val combatSpells: Map<Spell.Name, Action<Combatant>> = mapOf(Spell.Name.STOPSPELL to SpellStopSpell(this))
    final override val stopSpellRequirement: Int
        get() = calculateSpellStopSpellEnemy()

    override fun attack(combatant: Combatant) {
        combatSpells[Spell.Name.STOPSPELL]?.use(combatant)
    }
}
