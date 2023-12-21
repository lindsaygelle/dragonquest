public interface Actor : AttributeName

public interface ActorCombatant :
    Actor,
    AttributeAgility,
    AttributeAttackValue,
    AttributeDefenseValue,
    AttributeHitPoints,
    AttributeHitPointsMaximum,
    AttributeMagicPoints,
    AttributeMagicPointsMaximum,
    AttributeStrength,
    InvokerAttack,
    ReceiverAttack,
    ReceiverSpellHurt,
    ReceiverSpellSleep,
    ReceiverSpellStopSpell

public interface ActorNPCEnemy :
    AttributeExperiencePoints,
    AttributeGoldPoints,
    AttributeHurtValue,
    AttributeHurtRequirement,
    AttributeSleepRequirement,
    AttributeStopSpellRequirement

public interface ActorPlayer :
    ActorCombatant,
    AttributeArmorValue,
    AttributeExperiencePoints,
    AttributeGoldPoints,
    AttributeShieldValue,
    AttributeWeaponValue,
    InvokerSpellHurt,
    InvokerSpellSleep,
    InvokerSpellStopSpell
