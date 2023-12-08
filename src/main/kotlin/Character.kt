public abstract class Character(
    agility: Int,
    hitPoints: Int,
    magicPoints: Int,
    public open var name: String,
    strength: Int,
) {

    public final val agility: Int
        get() = agilityMaximum

    public final var agilityMaximum: Int = 0
        set(value) {
            field = maxOf(0, value)
        }

    public abstract val attackScore: Int

    public abstract val defenseScore: Int

    public final val hasHitPoints: Boolean
        get() = (hitPoints > 0)

    public final val hasMagicPoints: Boolean
        get() = (magicPoints > 0)

    public final var hitPoints: Int = 0
        set(value) {
            field = minOf(hitPointsMaximum, maxOf(0, value))
        }

    public final var hitPointsMaximum: Int = 0
        set(value) {
            field = maxOf(0, value)
        }

    public final var magicPoints: Int = 0
        set(value) {
            field = minOf(magicPointsMaximum, maxOf(0, value))
        }

    public final var magicPointsMaximum: Int = 0
        set(value) {
            field = maxOf(0, value)
        }

    public final var statusSleep: Boolean = false
    public final var statusStopSpell: Boolean = false
    public final val strength: Int
        get() = strengthMaximum

    public final var strengthMaximum: Int = 0
        set(value) {
            field = maxOf(0, value)
        }

    public final var turnsSleep: Int = 0
        set(value) {
            field = maxOf(0, value)
        }

    public final var turnsStopSpell: Int = 0
        set(value) {
            field = maxOf(0, value)
        }

    init {
        this.agilityMaximum = agility
        this.hitPointsMaximum = hitPoints
        this.hitPoints = this.hitPointsMaximum
        this.magicPointsMaximum = magicPoints
        this.magicPoints = this.magicPointsMaximum
        this.strengthMaximum = strength
    }
}
