public open class Shield(
    defense: Int,
    name: Name,
) : ItemDefense(defense = minOf(20, defense), name = name.toString()) {
    public enum class Name {
        SMALLSHIELD,
        LARGESHIELD,
        SILVERSHIELD,
    }
}
