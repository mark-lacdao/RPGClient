package org.nerv.rpgclient.player;

import org.apache.log4j.Logger;
import org.nerv.rpgclient.EffectType;
import org.nerv.rpgclient.RpgObject;
import org.nerv.rpgclient.Skill;

/**
 * Created by tenjutsu25 on 6/27/14.
 */
public class Player extends RpgObject {

    private static final Logger LOGGER = Logger.getLogger(Player.class);

    private Long id;
    private Job job;
    private int level;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void executeSkill(String skillName, RpgObject target){
        Skill skill = getJob().getSkill(skillName);
        if(skill == null){
            return;
        }
        LOGGER.info(getName() + " executed skill " + skillName + " with type " + skill.getType());
        if(skill.getStatusEffect() != null) target.setStatus(skill.getStatusEffect());
        EffectType type = skill.getType();
        // TODO: Add deduction to current MP depending on skill MP cost.
        switch (type){
            case ATTACK:
                damage(target, skill.getDamage());
                break;
            case RECOVERY:
                LOGGER.info("Healing.");
                heal(target, skill.getRecovery());
                break;
            case NECROMANCY:
                LOGGER.info("Reviving.");
                revive(target, skill.getRecovery());
                break;
        }

    }


}
