public abstract class Spell(
    magicPoints: UInt,
    name: String
) : Action(name = name) {
    private final val magicPoints = magicPoints.toInt()

    protected final override fun canUse(character: Character): Boolean {
        return (character.magicPoints - magicPoints) > 0
    }
}

public open class Hurt : Spell(magicPoints = 2u, name = "Hurt") {
    protected override fun apply(a: Character, b: Character) {
        println("${a.name} HURT ${b.name}")
    }
    protected override fun canApply(a: Character, b: Character): Boolean {
        return (0..15).random() >= b.hurtResistance
    }
}

public final class Sleep : Spell(magicPoints = 2u, name = "Sleep") {
    protected override fun apply(a: Character, b: Character) {
        println("${a.name} SLEEPS ${b.name}")
    }
    protected override fun canApply(a: Character, b: Character): Boolean {
        return (0..15).random() >= b.sleepResistance
    }
}

public final class StopSpell : Spell(magicPoints = 2u, name = "StopSpell") {
    protected override fun apply(a: Character, b: Character) {
        println("${a.name} STOPSPELLS ${b.name}")
    }
    protected override fun canApply(a: Character, b: Character): Boolean {
        return (0..15).random() >= b.stopSpellResistance
    }
}
