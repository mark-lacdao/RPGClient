package org.nerv.rpgclient;

/**
 * Created by tenjutsu25 on 6/27/14.
 */
public class Skill {

    private static final Long NONE = 0L;

    private String name;
    private EffectType type;
    private int level;
    private int attainableLevel;
    private Long damage;
    private Long recovery;
    private Status statusEffect;
    private Long mpCost;

    public Skill(EffectType type) {
        this.type = type;
    }

    public EffectType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttainableLevel() {
        return attainableLevel;
    }

    public void setAttainableLevel(int attainableLevel) {
        this.attainableLevel = attainableLevel;
    }

    public Long getDamage() {
        if(type.equals(EffectType.ATTACK)) return damage;
        return NONE;
    }

    public void setDamage(Long damage) {
        this.damage = damage;
    }

    public Long getRecovery() {
        if(type.equals(EffectType.RECOVERY) || type.equals(EffectType.NECROMANCY)) return recovery;
        return NONE;
    }

    public void setRecovery(Long recovery) {
        this.recovery = recovery;
    }

    public Status getStatusEffect() {
        return statusEffect;
    }

    public void setStatusEffect(Status statusEffect) {
        this.statusEffect = statusEffect;
    }

    public Long getMpCost() {
        if(mpCost == null) return NONE;
        return mpCost;
    }

    public void setMpCost(Long mpCost) {
        this.mpCost = mpCost;
    }
}
