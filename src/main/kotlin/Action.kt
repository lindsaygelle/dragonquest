import kotlin.random.Random

public abstract class Action(
    public final val category: Category,
    public final val name: String,
) {
    public final enum class Category {
        Attack, Spell,
    }

    public abstract fun perform(invoker: Character, receiver: Any): Boolean
}

public abstract class ActionSpell(
    name: String,
) : Action(
    Action.Category.Spell,
    name,
) {
    protected abstract fun apply(invoker: Character, receiver: Character): Unit
    public final override fun perform(invoker: Character, receiver: Any): Boolean {
        if (receiver is Character) {
            apply(invoker, receiver)
            return true
        }
        return false
    }
}

public class SpellSleep : ActionSpell("Sleep") {
    override fun apply(invoker: Character, receiver: Character): Unit {
        // Generate a random number (sleepChance).
        // When sleepChance is greater or equal to receiver.sleepResistance the spell is successful.
        val sleepChance: Int =
            if (receiver.category == Actor.Category.Player) Random.nextInt(0, 2)
            else Random.nextInt(0, 16)
        val sleepResistance: Int = receiver.sleepResistance
        receiver.isSleep = sleepChance >= sleepResistance
    }
}
