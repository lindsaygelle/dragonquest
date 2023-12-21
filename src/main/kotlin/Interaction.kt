public abstract class Interaction<A : AttributeName, B : AttributeName>(
    protected open val a: A, public final override val name: String
) : Action<B> {
    protected open fun after(b: B) {}
    protected abstract fun apply(b: B)
    protected open fun before(b: B) {}
    protected abstract fun check(b: B): Boolean
    public final override fun use(b: B) {
        println("${a.name} used $name against ${b.name}")
        before(b)
        if (check(b)) {
            println("${a.name}'s $name worked against ${b.name}")
            apply(b)
        }
        after(b)
    }
}
