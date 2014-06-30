package org.nerv.rpgclient.item;

/**
 * Created by tenjutsu25 on 6/30/14.
 */
public class Equipment extends Item {

    private enum Type {HEAD, BODY, ACCESSORY, FOOT, WEAPON}
    private Type type;
    private boolean equipped;

    public Equipment(Type type) {
        this.type = type;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public Type getType() {
        return type;
    }

    @Override
    public Boolean isEquipable() {
        return true;
    }
}
