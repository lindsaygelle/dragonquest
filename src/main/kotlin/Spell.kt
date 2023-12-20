public abstract class Spell<A : AttributeMagicPoints, B>(
    protected final val a: A,
    public final override val name: String,
) : Action<B>

public class SpellHurt<A : TraitHurtInvoker, B : TraitHurtReceiver>(a: A) : Spell<A, B>(a = a, name = "HURT") {
    private final fun check(b: B): Boolean {
        return a.hurtRequirement >= b.hurtResistance
    }

    override fun use(b: B) {
        if (check(b)) {
            b.hitPoints -= a.hurtValue / b.hurtScale
            a.magicPoints -= 2
        }
    }
}
