public interface Receiver : AttributeName

public interface ReceiverAttack :
    AttributeAgility,
    AttributeDefenseValue,
    AttributeHitPoints,
    Receiver

public interface ReceiverSpellHurt :
    AttributeHitPoints,
    AttributeHurtResistance,
    AttributeHurtScale,
    Receiver


public interface ReceiverSpellSleep :
    AttributeSleepResistance,
    AttributeStatusSleep,
    Receiver


public interface ReceiverSpellStopSpell :
    AttributeStatusStopSpell,
    AttributeStopSpellResistance,
    Receiver
