package org.nerv.rpgclient.item;

import javafx.util.converter.PercentageStringConverter;

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

    public Long getRarity() {
        PercentageStringConverter psc = new PercentageStringConverter();
        NumberFormat nf = psc.getNumberFormat();
        Number number = null;
        try {
            number = nf.parse(rarity);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        if(number == null) {
            System.err.println("Unable to parse " + rarity + " returning null.");
            return null;
        }
        return number.longValue();
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
