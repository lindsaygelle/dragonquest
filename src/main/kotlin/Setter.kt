interface SetterHitPoints {
    public fun setHitPoints(traitHitPoints: TraitHitPoints, hitPoints: Int) {
        traitHitPoints.hitPoints = hitPoints
    }
}

interface SetterMagicPoints {
    public fun setMagicPoints(traitMagicPoints: TraitMagicPoints, magicPoints: Int) {
        traitMagicPoints.magicPoints = magicPoints
    }
}
