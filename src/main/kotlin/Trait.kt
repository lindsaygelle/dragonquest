public interface TraitCombatant : AttributeAgility, AttributeAttackValue, AttributeDefenseValue, AttributeHitPoints,
    AttributeHitPointsMaximum, AttributeMagicPoints, AttributeMagicPointsMaximum, AttributeStrength

public interface TraitHurtInvoker : AttributeMagicPoints, AttributeHurtRequirement, AttributeHurtValue

public interface TraitHurtReceiver : AttributeHitPoints, AttributeHurtResistance, AttributeHurtScale
