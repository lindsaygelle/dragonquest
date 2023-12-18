public abstract class Action<A, B>(public final val name: String) {
    public abstract fun use(a: A, b: B)
}
