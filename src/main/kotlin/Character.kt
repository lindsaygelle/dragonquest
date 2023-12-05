abstract class Character(
    public var agility: Int,
    public var goldPoints: Int,
    public var experiencePoints: Int,
    public var hitPointsMaximum: Int,
    public var magicPointsMaximum: Int,
    public final val name: String,
    public var strength: Int,
) {
    public var hitPoints: Int = hitPointsMaximum
    public var magicPoints: Int = magicPointsMaximum
}
