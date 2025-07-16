package Rpg;

public class Troll extends NormalMonster implements Healable {

    public Troll() {
    }

    public Troll(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    @Override
    public void heal() {
        setHp(getHp() + (getMaxHp() /10));
    }
}
