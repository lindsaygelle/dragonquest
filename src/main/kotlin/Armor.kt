public open class Armor(
    defense: Int,
    name: Name,
) : ItemDefense(defense = minOf(28, defense), name = name.toString()) {
    public enum class Name {
        CLOTHES,
        LEATHERARMOR,
        CHAINMAIL,
        HALFPLATE,
        FULLPLATE,
        MAGICARMOR,
        ERDRICKSAMOR,
    }
}
