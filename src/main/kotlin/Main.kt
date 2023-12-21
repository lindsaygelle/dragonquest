fun main() {
    val magician = EnemyMagician()
    val warlock = EnemyWarlock()
    val wolfLord = EnemyWolfLord()
    val p = Player()

    listOf(magician, warlock, wolfLord).forEach { it ->
        it.attack(p)
    }
}
