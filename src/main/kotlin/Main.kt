fun main() {
    val slime = Enemy(
        actions = mutableListOf(Attack()),
        agility = 1u,
        damageResistance = 1u,
        experiencePoints = 2u,
        goldPoints = 1u,
        hitPoints = 13u,
        magicPoints = 0u,
        name = "Slime",
        statusResistance = 15u,
        strength = 5u,
    )
    val slime2 = Enemy(
        actions = mutableListOf(Attack()),
        agility = 1u,
        damageResistance = 1u,
        experiencePoints = 2u,
        goldPoints = 1u,
        hitPoints = 3u,
        magicPoints = 0u,
        name = "Slime2",
        statusResistance = 15u,
        strength = 5u,
    )
    slime2.category = Actor.Category.PLAYER
    val battle = CategoryBattle(mutableListOf(slime, slime2))
    battle.run()
}
