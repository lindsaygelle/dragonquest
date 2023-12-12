public abstract class Actor(
    public open var category: Category,
    public open var name: String,
) {
    public enum class Category {
        NPC,
        PLAYER,
    }
}
