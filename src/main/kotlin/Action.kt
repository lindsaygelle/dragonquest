public interface Action<B> {
    public val name: String
    public fun use(b: B)
}
