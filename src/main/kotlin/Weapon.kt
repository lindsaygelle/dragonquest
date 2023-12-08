public open class Weapon(
    attack: Int,
    name: Name,
) : ItemAttack(attack = minOf(40, attack), name = name.toString()) {
    public enum class Name {
        BAMBOSPEAR,
        OAKENCLUB,
        COPPERSWORD,
        IRONAXE,
        STEELBROADSWORD,
        FIREBLADE,
        ERDRICKSSWORD,
    }
}
