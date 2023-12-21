typealias Agility = Int

public interface AttributeAgility {
    public var agility: Agility
}

public interface AttributeAttackValue {
    public val attackValue: Int
}

public interface AttributeDefenseValue {
    public val defenseValue: Int
}

typealias ExperiencePoints = Int

public interface AttributeExperiencePoints {
    public var experiencePoints: ExperiencePoints
}

typealias GoldPoints = Int

public interface AttributeGoldPoints {
    public var goldPoints: GoldPoints
}

typealias HitPoints = Int

public interface AttributeHitPoints {
    public var hitPoints: HitPoints
}

public interface AttributeHitPointsMaximum {
    public var hitPointsMaximum: HitPoints
}

public interface AttributeHurtRequirement {
    public val hurtRequirement: Int
}

public interface AttributeHurtResistance {
    public val hurtResistance: Int
}

public interface AttributeHurtScale {
    public val hurtScale: Int
}

public interface AttributeHurtValue {
    public val hurtValue: Int
}

typealias MagicPoints = Int

public interface AttributeMagicPoints {
    public var magicPoints: MagicPoints
}

public interface AttributeMagicPointsMaximum {
    public var magicPointsMaximum: MagicPoints
}

public interface AttributeName {
    public var name: String
}

public interface AttributeStatusSleep {
    public var statusSleep: Boolean
}

public interface AttributeStatusStopSpell {
    public var statusStopSpell: Boolean
}

public interface AttributeShieldValue {
    public val shieldValue: Int
}

public interface AttributeSleepRequirement {
    public val sleepRequirement: Int
}

public interface AttributeSleepResistance {
    public val sleepResistance: Int
}

public interface AttributeStopSpellRequirement {
    public val stopSpellRequirement: Int
}

public interface AttributeStopSpellResistance {
    public val stopSpellResistance: Int
}

typealias Strength = Int

public interface AttributeStrength {
    public var strength: Strength
}

public interface AttributeArmorValue {
    public val armorValue: Int
}

public interface AttributeWeaponValue {
    public val weaponValue: Int
}
