package org.nerv.rpgclient.player;

import org.junit.Test;
import org.nerv.rpgclient.EffectType;
import org.nerv.rpgclient.Skill;
import org.nerv.rpgclient.Stats;
import org.nerv.rpgclient.monster.Monster;

import static org.junit.Assert.*;

/**
 * Created by Mark.Lacdao on 02/07/2014.
 */
public class PlayerExecuteSkillTest {

    private static final Long MAX_HP = 10L;
    private static final Long MONSTER_CURRENT_HP = 5L;
    private static final Long DEAD_HP = 0L;
    private static final Long HEAL_RECOVERY_HP = 3L;
    private static final Long ANGELIC_CALLING_RECOVERY_HP = 3L;
    private static final Long SLASH_DAMAGE_HP = 4L;
    private static final String HEAL_NAME = "Heal";
    private static final String SLASH_NAME = "Slash";
    private static final String ANGELIC_CALLING_NAME = "Angelic Calling";

    @Test
    public void shouldHealIfRecovery(){
        Player healerPlayer = createPlayer(createHealerJob());

        Monster monster = createMonster(MONSTER_CURRENT_HP);

        healerPlayer.executeSkill(HEAL_NAME, monster);

        Long expectedHp = MONSTER_CURRENT_HP + HEAL_RECOVERY_HP;
        assertEquals(expectedHp, monster.getStats().getHp());
    }

    @Test
    public void shouldDamageIfAttack(){
        Player swordsmanPlayer = createPlayer(createSwordsmanJob());

        Monster monster = createMonster(MONSTER_CURRENT_HP);

        swordsmanPlayer.executeSkill(SLASH_NAME, monster);

        Long expectedHp = MONSTER_CURRENT_HP - SLASH_DAMAGE_HP;
        assertEquals(expectedHp, monster.getStats().getHp());

    }

    @Test
    public void shouldReviveIfNecromancy(){
        Player healerPlayer = createPlayer(createHealerJob());
        healerPlayer.getJob().addSkill(createSkill(EffectType.NECROMANCY, ANGELIC_CALLING_NAME, ANGELIC_CALLING_RECOVERY_HP));

        Monster monster = createMonster(DEAD_HP);
        assertFalse(monster.isAlive()); // Check if dead

        healerPlayer.executeSkill(ANGELIC_CALLING_NAME, monster);

        Long expectedHp = DEAD_HP + ANGELIC_CALLING_RECOVERY_HP;
        assertEquals(expectedHp, monster.getStats().getHp());
        assertTrue(monster.isAlive());
    }
    
    private static Player createPlayer(Job job){
        Player player = new Player();
        player.setStats(createStats(MAX_HP));
        player.setJob(job);
        player.setAlive(true);
        return player;
    }

    private static Job createHealerJob(){
        Job job = new Job(Job.Type.HEALER);
        job.addSkill(createSkill(EffectType.RECOVERY, HEAL_NAME, HEAL_RECOVERY_HP));
        return job;
    }

    private static Job createSwordsmanJob(){
        Job job = new Job(Job.Type.SWORDSMAN);
        job.addSkill(createSkill(EffectType.ATTACK, SLASH_NAME, SLASH_DAMAGE_HP));
        return job;
    }
    
    private static Skill createSkill(EffectType effectType, String name, Long hp){
        Skill skill = new Skill(effectType);
        if(effectType.equals(EffectType.RECOVERY) || effectType.equals(EffectType.NECROMANCY))
            skill.setRecovery(hp);
        else
            skill.setDamage(hp);
        skill.setName(name);
        return skill;
    }

    private static Monster createMonster(Long currentHp){
        Monster monster = new Monster();
        monster.setStats(createStats(currentHp));
        monster.setAlive(true);
        return monster;
    }

    private static Stats createStats(Long currentHp){
        Stats stats = new Stats();
        stats.setMaxHp(MAX_HP);
        stats.setHp(currentHp);
        return stats;
    }
}
