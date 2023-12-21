public abstract class Enemy(
    agility: Int,
    damageResistance: Int,
    experiencePoints: Int,
    goldPoints: Int,
    hitPoints: HitPoints,
    magicPoints: MagicPoints,
    name: String,
    pattern: Int,
    statusResistance: Int,
    strength: Strength
) : NPCEnemy(
    agility = agility,
    damageResistance = damageResistance,
    experiencePoints = experiencePoints,
    goldPoints = (goldPoints * (((0..255).random() and 0x3F) + 0xC0)) shr 8,
    hitPoints = hitPoints - (((0..255).random() * hitPoints) shr 10),
    magicPoints = magicPoints,
    name = name,
    pattern = pattern,
    statusResistance = statusResistance,
    strength = strength,
) {
    protected open fun checkSpecialAttackPrimaryCondition(combatant: Combatant): Boolean {
        return true
    }

    protected open fun checkSpecialAttackSecondaryCondition(combatant: Combatant): Boolean {
        return true
    }

    protected open val specialAttackPrimary: Action<Combatant>? = null
    private final val specialAttackPrimaryChance: Int
        get() = (((0..255).random() and 0x30) shr 4)

    private final val specialAttackPrimaryThreshold: Int = ((pattern and 0x30) shr 4)

    protected open val specialAttackSecondary: Action<Combatant>? = null

    private final val specialAttackSecondaryChance: Int
        get() = ((0..255).random() and 0x03)

    private final val specialAttackSecondaryThreshold: Int = (pattern and 0x03)

    public final fun attack(combatant: Combatant) {
        if ((specialAttackPrimary != null) && (specialAttackPrimaryChance < specialAttackPrimaryThreshold)) {
            if (checkSpecialAttackPrimaryCondition(combatant)) {
                specialAttackPrimary!!.use(combatant)
            }
        } else if ((specialAttackSecondary != null) && (specialAttackSecondaryChance < specialAttackSecondaryThreshold)) {
            if (checkSpecialAttackSecondaryCondition(combatant)) {
                specialAttackSecondary!!.use((combatant))
            }
        } else {
            Attack<Enemy, Combatant>(this).use(combatant)
        }
    }
}

public final class EnemyMagician : Enemy(
    agility = 12,
    damageResistance = 1,
    experiencePoints = 4,
    goldPoints = 1,
    hitPoints = 13,
    magicPoints = 2,
    name = "Magician",
    pattern = 2,
    statusResistance = 0,
    strength = 11
), InvokerSpellHurt {
    override fun checkSpecialAttackPrimaryCondition(combatant: Combatant): Boolean {
        return (0..1).random() == 1
    }

    override val specialAttackPrimary: Action<Combatant> = SpellHurt(this)
}

public final class EnemyWarlock : Enemy(
    agility = 22,
    damageResistance = 9,
    experiencePoints = 2,
    goldPoints = 1,
    hitPoints = 30,
    magicPoints = 18,
    name = "Warlock",
    pattern = 18,
    statusResistance = 4,
    strength = 28
), InvokerSpellHurt, InvokerSpellSleep {
    override val specialAttackPrimary: Action<Combatant> = SpellSleep(this)
    override val specialAttackSecondary: Action<Combatant> = SpellHurt(this)
}

public final class EnemyWolfLord : Enemy(
    agility = 36,
    damageResistance = 1,
    experiencePoints = 2,
    goldPoints = 2,
    hitPoints = 38,
    magicPoints = 96,
    name = "Wolflord",
    pattern = 96,
    statusResistance = 7,
    strength = 50
), InvokerSpellStopSpell {
    override fun checkSpecialAttackPrimaryCondition(combatant: Combatant): Boolean {
        return !combatant.statusStopSpell && ((0..1).random() == 1)
    }

    override val specialAttackPrimary: Action<Combatant> = SpellStopSpell(this)
}
