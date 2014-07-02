package org.nerv.rpgclient;

import org.nerv.rpgclient.item.Item;
import org.nerv.rpgclient.monster.Monster;
import org.nerv.rpgclient.player.Job;
import org.nerv.rpgclient.player.Player;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player();
        player1.setName("Mark");
        player1.setStats(createStats());
        player1.setAlive(true);
        player1.setJob(createJob());

        Player player2 = new Player();
        player2.setName("Enemy");
        player2.setStats(createStats());
        player2.setAlive(true);

        Monster monster = createMonster();

        //player1.damage(monster, 20L);
        //player1.executeSkill("Revive", monster);
        player1.executeSkill("Sword Slash", monster);
        player1.executeSkill("Heal", monster);
        /*
        monster.damage(player1, 4L);
        player1.executeSkill("Sword Slash", monster);
        player1.executeSkill("Sword Slash", monster);
        player1.executeSkill("Revive", monster);*/

        printHp(player1, monster);


    }

    public static Monster createMonster(){
        Monster monster = new Monster();
        monster.setStats(createStats());
        monster.setName("Poring");
        monster.setAlive(true);
        return monster;
    }

    public static Job createJob(){
        Job job = new Job(Job.Type.SWORDSMAN);
        job.addSkill(createSkill());
        job.addSkill(createHealSkill());
        job.addSkill(createReviveSkill());
        return job;
    }

    public static Skill createSkill(){
        Skill skill = new Skill(EffectType.ATTACK);
        skill.setName("Sword Slash");
        skill.setDamage(8L);
        skill.setStatusEffect(Status.PARALYZED);
        return skill;
    }

    public static Skill createHealSkill(){
        Skill skill = new Skill(EffectType.RECOVERY);
        skill.setName("Heal");
        skill.setRecovery(100L);
        return skill;
    }

    public static Skill createReviveSkill(){
        Skill skill = new Skill(EffectType.NECROMANCY);
        skill.setName("Revive");
        skill.setRecovery(100L);
        return skill;
    }

    public static Stats createStats(){
        Stats stats = new Stats();
        stats.setMaxHp(20L);
        stats.setHp(20L);
        return stats;
    }

    public static void printHp(RpgObject rpgObject1, RpgObject rpgObject2){
        System.out.println(rpgObject1.getName() + " Status: " + rpgObject1.getStatus().name() + " PLAYER1 HP : " + rpgObject1.getStats().getHp()
                + " : isAlive? " + rpgObject1.isAlive());
        System.out.println(rpgObject2.getName() + " Status: " + rpgObject2.getStatus().name() + " PLAYER2 HP : " + rpgObject2.getStats().getHp()
                + " : isAlive? " + rpgObject2.isAlive());
    }
}
