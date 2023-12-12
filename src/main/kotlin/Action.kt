public abstract class Action(
    public final val name: String,
) {
    public enum class Result {
        NONE,
        OK,
    }

    public abstract fun invoke(invoker: Character, receivers: List<Character>): Result
}


public open class Attack: Action(
    name = "Attack"
) {
    public override fun invoke(invoker: Character, receivers: List<Character>): Result {
        receivers[0].hitPoints-=invoker.attackScore
        return Result.OK
    }
}

public open class Kamikaze : Action(
    name = "Kamikaze"
) {
    public override fun invoke(invoker: Character, receivers: List<Character>): Result {
        invoker.hitPoints = 0
        for (receiver in receivers) {
            receiver.hitPoints--
            println("${name} HIT ${receiver.name} DOING 1 DMG")
        }
        return Result.OK
    }
}
