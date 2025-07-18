package Rpg;

public class Troll extends NormalMonster implements Healable {

    public Troll() {
    }

    public Troll(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    @Override
    public void heal() {
        int healAmount;
        healAmount = getMaxHp()/10;

        if(getHp()+healAmount > getMaxHp()) {
            setHp(getMaxHp());
        }else {
            setHp(getHp() + healAmount);
        }
        System.out.println(getName()+" 이/가 체력을 " + healAmount + " 회복했습니다.");

    }
}
