public abstract class Combatant(
    agility: Int,
    hitPoints: HitPoints,
    magicPoints: MagicPoints,
    public override var name: String,
    strength: Strength,
) : ActorCombatant {

    public final override var agility: Agility = agility
        set(value) {
            field = maxOf(0, value)
        }

    public final override var hitPoints: HitPoints = 0
        set(value) {
            field = minOf(hitPointsMaximum, maxOf(0, value))
            println("$name: ${hitPoints}/${hitPointsMaximum}")
        }

    public final override var hitPointsMaximum: HitPoints = 0
        set(value) {
            field = maxOf(0, value)
        }

    public final override var magicPoints: MagicPoints = 0
        set(value) {
            field = minOf(magicPointsMaximum, maxOf(0, value))
        }

    public final override var magicPointsMaximum: MagicPoints = 0
        set(value) {
            field = maxOf(0, value)
        }

    public override var statusSleep: Boolean = false

    public override var statusStopSpell: Boolean = false

    public final override var strength: Strength = strength
        set(value) {
            field = maxOf(0, value)
        }

    init {
        this.hitPointsMaximum = hitPoints
        this.hitPoints = this.hitPointsMaximum
        this.magicPointsMaximum = magicPoints
        this.magicPoints = this.magicPointsMaximum
    }
}
