public abstract class Spell<A, B : AttributeName>(
    protected final override val a: A,
    name: Name,
) : Interaction<A, B>(a = a, name = name.toString()),
    AttributeMagicPoints where A : AttributeMagicPoints, A : AttributeName {
    public final enum class Name {
        HURT, SLEEP, STOPSPELL,
    }

    override fun before(b: B) {
        a.magicPoints -= magicPoints
    }
}

public final class SpellHurt<A : TraitSpellHurtInvoker, B : TraitSpellHurtReceiver>(a: A) :
    Spell<A, B>(a = a, name = Name.HURT) {
    public override var magicPoints: MagicPoints = 2

    protected final override fun check(b: B): Boolean {
        return a.hurtRequirement >= b.hurtResistance
    }

    protected final override fun apply(b: B) {
        b.hitPoints -= a.hurtValue / b.hurtScale
    }
}

public final class SpellSleep<A : TraitSpellSleepInvoker, B : TraitSpellSleepReceiver>(a: A) :
    Spell<A, B>(a = a, name = Name.SLEEP) {
    public override var magicPoints: MagicPoints = 2

    protected final override fun check(b: B): Boolean {
        return a.sleepRequirement >= b.sleepResistance
    }

    protected final override fun apply(b: B) {
        b.statusSleep = true
    }
}

public final class SpellStopSpell<A : TraitSpellStopSpellInvoker, B : TraitSpellStopSpellReceiver>(a: A) :
    Spell<A, B>(a = a, name = Name.STOPSPELL) {
    public final override var magicPoints: MagicPoints = 2

    protected final override fun check(b: B): Boolean {
        return a.stopSpellRequirement >= b.stopSpellResistance
    }

    protected final override fun apply(b: B) {
        b.statusStopSpell = true
    }
}
