public abstract class Character(
    public var agilityMaximum: Int,
    category: Actor.Category,
    public var experiencePointsMaximum: Int,
    public var goldPointsMaximum: Int,
    public var hitPointsMaximum: Int,
    public var magicPointsMaximum: Int,
    name: String,
    public var strengthMaximum: Int,
) : Actor(
    category, 
    name) {
    //public abstract var abilities: Array<Ability>
    public abstract val agility: Int
    public abstract val sleepResistance: Int
    public abstract val strength: Int
    public var hitPoints: Int = hitPointsMaximum
    public var magicPoints: Int = magicPointsMaximum
    public final val isAlive: Boolean
        get() = hitPoints > 0
    public var isAsleep: Boolean = false
}
