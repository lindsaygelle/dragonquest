public open class Attack<A : InvokerAttack, B : ReceiverAttack>(
    protected final override val a: A,
) : Interaction<A, B>(
    a = a, name = "ATTACK"
) {
    public final enum class Name {
        EXCELLENT,
        LESSER,
        STANDARD
    }

    override fun apply(b: B) {
        b.hitPoints = b.hitPoints
    }

    override fun check(b: B): Boolean {
        return true
    }
}
