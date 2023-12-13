public abstract class Character(
    protected final var actions: MutableList<Action>,
    agility: UInt,
    category: Category,
    experiencePoints: UInt,
    goldPoints: UInt,
    hitPoints: UInt,
    magicPoints: UInt,
    name: String,
    strength: UInt,
) : Actor(
    category = category, name = name
) {

    public abstract val attackScore: Int

    public final val agility: Int
        get() = agilityMaximum

    private final var agilityMaximum: Int = 0
        set(value) {
            field = maxOf(0, value)
        }

    public abstract val defenseScore: Int

    public final var experiencePoints: Int = experiencePoints.toInt()

    public final var goldPoints: Int = goldPoints.toInt()

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

    public abstract val hurtResistance: Int

    public final var magicPoints: Int = 0
        set(value) {
            field = minOf(magicPointsMaximum, maxOf(0, value))
        }

    public final var magicPointsMaximum: Int = 0
        set(value) {
            field = maxOf(0, value)
        }

    public abstract val sleepResistance: Int

    public final var statusSleep: Boolean = false

    public final var statusStopSpell: Boolean = false

    public abstract val stopSpellResistance: Int

    public final val strength: Int
        get() = strengthMaximum

    private final var strengthMaximum: Int = 0
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
        this.agilityMaximum = agility.toInt()
        this.hitPointsMaximum = hitPoints.toInt()
        this.hitPoints = this.hitPointsMaximum
        this.magicPointsMaximum = magicPoints.toInt()
        this.magicPoints = this.magicPointsMaximum
        this.strengthMaximum = strength.toInt()
    }
}
