public interface Invoker : AttributeName

public interface InvokerAttack :
    AttributeAttackValue,
    Invoker

public interface InvokerSpellHurt :
    AttributeHurtRequirement,
    AttributeHurtValue,
    AttributeMagicPoints,
    Invoker


public interface InvokerSpellSleep :
    AttributeMagicPoints,
    AttributeSleepRequirement,
    Invoker


public interface InvokerSpellStopSpell :
    AttributeMagicPoints,
    AttributeStopSpellRequirement,
    Invoker
