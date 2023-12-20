fun main() {
    val e = EnemyMagician()
    val p = Player()
    println(p.hitPoints)
    e.spells.forEach {
        it.use(p)
    }
    println(p.hitPoints)
}
