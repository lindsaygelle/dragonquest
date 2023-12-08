public open class Item(public final val category: Category, public final val name: String) {
    public enum class Category {
        ATTACK,
        DEFENSE,
        HEAL,
        MAGIC,
    }
}

public open class ItemAttack(attack: Int, name: String) :
    Item(category = Category.ATTACK, name = name) {
    public final val attack: Int = maxOf(0, attack)
}

public open class ItemDefense(defense: Int, name: String) :
    Item(category = Category.DEFENSE, name = name) {
    public final val defense: Int = maxOf(0, defense)
}

public open class ItemHeal(hitPoints: Int, name: String) :
    Item(category = Category.HEAL, name = name) {
    public final val hitPoints: Int = maxOf(0, hitPoints)
}

public open class ItemMagic(magicPoints: Int, name: String) :
    Item(category = Category.MAGIC, name = name) {
    public final val magicPoints: Int = maxOf(0, magicPoints)
}
