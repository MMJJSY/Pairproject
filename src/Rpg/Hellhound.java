package Rpg;

public class Hellhound extends FireMonster implements Healable {
    public Hellhound() {
    }

    public Hellhound(String name, int hp, int attack, int defense, int fireSkillDamage) {
        super(name, hp, attack, defense, fireSkillDamage);
    }

    @Override
    public void heal() {
        setHp(getHp() + getMaxHp()/5);
    }
}
