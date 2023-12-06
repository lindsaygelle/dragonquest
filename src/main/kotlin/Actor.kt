public abstract class Actor(
    public final val category: Category,
    public final val name: String) {
    public final enum class Category {
        NPC,
        Player
    }
}
