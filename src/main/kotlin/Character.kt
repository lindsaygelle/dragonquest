public abstract class Character(
    public var agility: Int,
    public var goldPointsMaximum: Int,
    public var experiencePointsMaximum: Int,
    public var hitPointsMaximum: Int,
    public var magicPointsMaximum: Int,
    name: String,
    public var strength: Int,
) : Actor(name) {
    public abstract val category: CharacterCategory
    public abstract var experiencePoints: Int
    public abstract var goldPoints: Int
    public var hitPoints: Int = hitPointsMaximum
    public var magicPoints: Int = magicPointsMaximum
    public final val isAlive: Boolean
        get() = hitPoints > 0
}

public enum class CharacterCategory {
    Enemy,
    Player
}
