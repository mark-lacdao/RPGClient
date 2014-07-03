package org.nerv.rpgclient;

/**
 * Created by tenjutsu25 on 6/27/14.
 */
public class Stats {

    private Long maxHp;
    private Long hp;
    private Long str;
    private Long def;
    private Long atk;
    private Long maxMp;
    private Long mp;

    public Long getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(Long maxMp) {
        this.maxMp = maxMp;
    }

    public Long getMp() {
        return mp;
    }

    public void setMp(Long mp) {
        this.mp = mp;
    }

    public Long getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Long maxHp) {
        this.maxHp = maxHp;
    }

    public Long getHp() {
        return hp;
    }

    public void setHp(Long hp) {
        this.hp = hp;
    }

    public Long getStr() {
        return str;
    }

    public void setStr(Long str) {
        this.str = str;
    }

    public Long getDef() {
        return def;
    }

    public void setDef(Long def) {
        this.def = def;
    }

    public Long getAtk() {
        return atk;
    }

    public void setAtk(Long atk) {
        this.atk = atk;
    }
}
