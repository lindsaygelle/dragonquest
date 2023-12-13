public abstract class Action(
    public final val name: String
) {
    protected abstract fun apply(a: Character, b: Character)
    protected abstract fun canApply(a: Character, b: Character): Boolean
    protected abstract fun canUse(a: Character): Boolean
    public final fun invoke(character: Character, characters: List<Character>) {
        if (canUse(a = character)) {
            for (c in characters) {
                if (canApply(a = character, b = c)) {
                    apply(a = character, b = c)
                }
            }
        }
    }
}
