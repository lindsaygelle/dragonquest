public abstract class Action(
    public final val category: Category,
    public final val name: String) {
    public final enum class Category {
        Attack,
        Defend,
        Run,
        Spell,
    }
}
