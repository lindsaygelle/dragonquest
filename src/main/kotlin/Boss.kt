public abstract class Boss(
    actions: MutableList<Action>,
    agility: UInt,
    damageResistance: UInt,
    hitPoints: UInt,
    magicPoints: UInt,
    name: String,
    statusResistance: UInt,
    strength: UInt,
) : NPC(
    actions = actions,
    agility = agility,
    damageResistance = damageResistance,
    experiencePoints = 0u,
    goldPoints = 0u,
    hitPoints = hitPoints,
    magicPoints = magicPoints,
    name = name,
    statusResistance = statusResistance,
    strength = strength,
) {
    protected abstract fun nextPhase(): Boss
}
