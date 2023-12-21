public sealed interface TraitCombatant : AttributeAgility, AttributeAttackValue, AttributeDefenseValue,
    AttributeHitPoints, AttributeHitPointsMaximum, AttributeMagicPoints, AttributeMagicPointsMaximum, AttributeName,
    AttributeStrength

public sealed interface TraitSpellInvoker : AttributeMagicPoints, AttributeName
public sealed interface TraitSpellHurtInvoker : AttributeHurtRequirement, AttributeHurtValue, TraitSpellInvoker

public sealed interface TraitSpellHurtReceiver : AttributeHitPoints, AttributeHurtResistance, AttributeHurtScale,
    AttributeName

public sealed interface TraitSpellSleepInvoker : TraitSpellInvoker, AttributeSleepRequirement

public sealed interface TraitSpellSleepReceiver : AttributeSleepResistance, AttributeStatusSleep, AttributeName

public sealed interface TraitSpellStopSpellInvoker : TraitSpellInvoker, AttributeStopSpellRequirement

public sealed interface TraitSpellStopSpellReceiver : AttributeStatusStopSpell, AttributeStopSpellResistance,
    AttributeName
