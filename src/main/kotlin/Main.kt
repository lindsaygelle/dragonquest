fun main() {
    val slime1 = Enemy(
        agility = 1u,
        damageResistance = 1u,
        experiencePoints = 2u,
        goldPoints = 1u,
        hitPoints = 13u,
        magicPoints = 10u,
        name = "Slime",
        statusResistance = 15u,
        strength = 5u,
    )
    val slime2 = Enemy(
        agility = 1u,
        damageResistance = 1u,
        experiencePoints = 2u,
        goldPoints = 1u,
        hitPoints = 3u,
        magicPoints = 0u,
        name = "Slime2",
        statusResistance = 0u,
        strength = 5u,
    )
    slime2.category = Actor.Category.PLAYER
    println("${slime1.magicPoints}/${slime1.magicPointsMaximum}")
    SpellHurt<Character, Character>().use(slime1, slime2)
    println("$slime2: ${slime2.hasHitPoints} ${slime2.hitPoints}/${slime2.hitPoints}")
    println("${slime1.magicPoints}/${slime1.magicPointsMaximum}")

}
