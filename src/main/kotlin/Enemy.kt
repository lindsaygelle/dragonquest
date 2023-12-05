import kotlin.random.Random

public open class Enemy(
    agility: Int,
    override var experiencePoints: Int,
    experiencePointsMaximum: Int,
    public override var goldPoints: Int,
    goldPointsMaximum: Int,
    hitPointsMaximum: Int,
    magicPointsMaximum: Int,
    name: String,
    strength: Int,
) : Character(
    agility,
    goldPointsMaximum,
    experiencePointsMaximum,
    hitPointsMaximum,
    magicPointsMaximum,
    name,
    strength) {
    public final override val category: CharacterCategory = CharacterCategory.Enemy
    public final val experienceReward: Int
        get() = Random.nextInt(experiencePoints, experiencePointsMaximum+1)
}

public final class EnemySlime: Enemy(
    agility = 5,
    experiencePoints = 1,
    experiencePointsMaximum = 1,
    goldPoints = 1,
    goldPointsMaximum = 1,
    hitPointsMaximum = 5,
    magicPointsMaximum = 0,
    name = "Slime",
    strength = 5
)
