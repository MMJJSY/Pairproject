package Rpg;

public abstract class NormalMonster extends Monster {
    public NormalMonster() {
    }

    public NormalMonster(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    @Override
    public int attack(Monster target) {
        int critical;
        if (Math.random() < 0.2) {
            critical = this.getAttack() * 2;
            System.out.println("치명적인 일격!");
            return critical;
        }
        return this.getAttack() - target.getDefense();
    }

}
