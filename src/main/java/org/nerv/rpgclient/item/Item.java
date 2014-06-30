package org.nerv.rpgclient.item;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by tenjutsu25 on 6/30/14.
 */
public class Item {

    private int id;
    private String name;
    private Boolean equipable;
    public String rarity;

    public Item() {
        setEquipable(false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public Boolean isEquipable() {
        return equipable;
    }

    public void setEquipable(Boolean equipable) {
        this.equipable = equipable;
    }


}
