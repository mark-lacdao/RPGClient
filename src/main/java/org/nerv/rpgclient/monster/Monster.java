package org.nerv.rpgclient.monster;

import org.nerv.rpgclient.RpgObject;
import org.nerv.rpgclient.Skill;
import org.nerv.rpgclient.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tenjutsu25 on 6/28/14.
 */
public class Monster extends RpgObject {

    private Long id;
    private List<Skill> skills = new ArrayList<Skill>();
    private List<Item> drops = new ArrayList<Item>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill){
        getSkills().add(skill);
    }

    public List<Item> getDrops() {
        return drops;
    }

    public void setDrops(List<Item> drops) {
        this.drops = drops;
    }

    public void addDrop(Item item){
        getDrops().add(item);
    }

    public List<Item> drop(){
        //TODO: place on map

        return null;
    }

}
