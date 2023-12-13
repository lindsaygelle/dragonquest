public abstract class Battle(
    protected var characters: MutableList<Character>,
) {
    private final var turn: Int = 0

    protected abstract fun isActive(): Boolean

    protected open fun logCharacterAction(character: Character, action: Action): Unit {
        println("${character.name}: USED=${action.name}")
    }

    protected open fun logCharacter(character: Character): Unit {
        println("${character.name}: CAT=${character.category} AGI=${character.agility} HP=${character.hitPoints}/${character.hitPointsMaximum} MP=${character.magicPoints}/${character.magicPointsMaximum}")

    }

    protected open fun processCharacter(character: Character, characters: List<Character>): Unit {/*
        val action = character.decideAction(characters)
        val actionResult = action.invoke(character, characters)
        logCharacterAction(character, action)
        println("${character.name}: RESULT=${actionResult}")

         */
    }

    protected open fun processCharacters(): Unit {
        logCharacter(characters[0])
        processCharacter(characters[0], characters - characters[0])
        logCharacter(characters[0])
        reduceCharacters()
    }

    protected open fun reduceCharacters(): Unit {
        characters.removeAll {
            !it.hasHitPoints
        }
    }

    public open fun run(): Unit {/*
        while (isActive()) {
            turn++
            processCharacters()
        }
         */
    }
}

public open class CategoryBattle(
    characters: MutableList<Character>
) : Battle(
    characters = characters
) {
    protected override fun isActive(): Boolean {
        return characters.map { it.category }.distinct().size > 1
    }
}
