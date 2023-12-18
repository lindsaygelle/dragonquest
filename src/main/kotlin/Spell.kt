public abstract class Spell<A : TraitMagicPoints, B>(name: String) : Action<A, B>(name = name), SetterMagicPoints {
    protected abstract val magicPoints: Int
    protected abstract fun apply(a: A, b: B)
    protected abstract fun check(a: A, b: B): Boolean
    public final override fun use(a: A, b: B) {
        setMagicPoints(a, a.magicPoints - magicPoints)
        if (check(a, b)) {
            apply(a, b)
        }
    }
}

public open class SpellHurt<A, B> : Spell<A, B>(name = "Hurt"),
    SetterHitPoints where B : TraitHurtResistance, A : TraitHurtScore, A : TraitMagicPoints, B : TraitHitPoints {
    protected override val magicPoints: Int = 2
    protected final override fun apply(a: A, b: B) {
        setHitPoints(b, b.hitPoints - a.hurtScore)
    }

    protected override fun check(a: A, b: B): Boolean {
        val hurtValue =  (0..15).random()
        return hurtValue >= b.hurtResistance
    }
}
