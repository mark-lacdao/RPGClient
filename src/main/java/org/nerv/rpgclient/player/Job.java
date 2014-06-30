package org.nerv.rpgclient.player;

import org.nerv.rpgclient.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tenjutsu25 on 6/27/14.
 */
public class Job {

    public enum Type {SWORDSMAN, HEALER}
    private Type type;
    private List<Skill> skills = new ArrayList<Skill>();
    private int attainableLevel;

    public Job(Type type) {
        this.type = type;
    }

    public String getName(){
        return getType().name();
    }

    public Type getType() {
        return type;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public int getAttainableLevel() {
        return attainableLevel;
    }

    public void setAttainableLevel(int attainableLevel) {
        this.attainableLevel = attainableLevel;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill){
        if(!getSkills().contains(skill))getSkills().add(skill);
    }

    public Skill getSkill(String skillName){
        skillName = skillName.toLowerCase();
        Skill skill = null;
        for(Skill zkill : getSkills()){
            String name = zkill.getName().toLowerCase();
            if(name.equals(skillName)){
                skill = zkill;
                break;
            }
        }
        if(skill == null){
            System.err.println("Skill " + skillName + " not found.");
            return null;
        }
        return skill;
    }
}
