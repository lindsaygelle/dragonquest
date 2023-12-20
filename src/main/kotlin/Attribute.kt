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

public interface AttributeShieldValue {
    public val shieldValue: Int
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
