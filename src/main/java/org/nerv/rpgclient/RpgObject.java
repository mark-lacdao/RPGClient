package org.nerv.rpgclient;

/**
 * Created by tenjutsu25 on 6/27/14.
 */
public class RpgObject extends Informable {
// TODO: Move error messages to informable class. Or not :p
    private String name;
    private Stats stats;
    private Boolean alive;
    private Status status = Status.NORMAL;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isAlive() {
        if(alive == null){
            System.err.println("Error! Object is neither alive nor dead. :/");
            return null;
        }
        return getStats().getHp() > 0;
    }

    public void setAlive(Boolean alive) {
        if(!alive) getStats().setHp(0L);
        this.alive = alive;
    }

    public void die(){
        System.out.println(getName()  + " just died.");
        setStatus(Status.NORMAL);
        setAlive(false);
    }

    public void heal(RpgObject rpgObject, Long hp){
        if(rpgObject.isAlive() == null) inform("Unable to heal objects.");
        if(!rpgObject.isAlive()){
            inform("Unable to heal dead things :/");
            return;

        }
        System.out.println("Adding to hp.");
        addToHp(rpgObject, hp);
    }

    public void revive(RpgObject rpgObject, Long hp){
        if(rpgObject.isAlive() == null) inform("Unable to revive objects.");
        if(rpgObject.isAlive())inform("Unable to revive living things :/");
        addToHp(rpgObject, hp);
    }

    public void damage(RpgObject rpgObject, Long hp){
        if(!rpgObject.isAlive()){
            inform("Unable to damage dead things");
        }
        Long currentHp = rpgObject.getStats().getHp();
        Long resultHp = currentHp - hp;
        if(resultHp < 0) {
            rpgObject.getStats().setHp(0L);
            rpgObject.die();
        } else {
            rpgObject.getStats().setHp(resultHp);
        }
    }

    private void addToHp(RpgObject rpgObject, Long hp){
        System.out.println("Adding " + hp + " to " + rpgObject.getName());
        Long livingObjectHp = rpgObject.getStats().getHp();
        Long processedHp = livingObjectHp + hp;
        Long maxHp = rpgObject.getStats().getMaxHp();
        if(maxHp == null){
            rpgObject.getStats().setMaxHp(processedHp);
            maxHp = processedHp;
        }
        if(processedHp > maxHp){
            rpgObject.getStats().setHp(maxHp);
        } else {
            rpgObject.getStats().setHp(processedHp);
        }
    }

}
