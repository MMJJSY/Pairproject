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
        int attakDamage;
        if (Math.random() < 0.2) {
            critical = this.getAttack() * 2;
            System.out.println("치명적인 일격!");
            return critical;
        }
        attakDamage = this.getAttack() - target.getDefense();
        if (attakDamage < 0) {
            return 0;
        } else {
            return attakDamage;
        }
    }

}
