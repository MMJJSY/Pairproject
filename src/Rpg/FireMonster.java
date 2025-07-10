package Rpg;

public abstract class FireMonster extends Monster{

    int fireSkillDamage;

    public FireMonster() {
    }

    public FireMonster(String name, int hp, int attack, int defense, int fireSkillDamage) {
        super(name, hp, attack, defense);
        this.fireSkillDamage = fireSkillDamage;
    }

    public int getFireSkillDamage() {
        return fireSkillDamage;
    }

    public void setFireSkillDamage(int fireSkillDamage) {
        this.fireSkillDamage = fireSkillDamage;
    }
    public void info() {
        System.out.println("이름 : " + super.getName() + ", 체력 : (" + super.getHp() + "/" + super.getHp() + ")" + ", 공격력 : " + super.getAttack() +
                ", 방어력 : " + super.getDefense() + " 불속성 데미지 : " + this.fireSkillDamage);
    }

    @Override
    public int attack(Monster target){
        int normalAttack;
        int fireSkill;
        normalAttack = this.getAttack() - target.getDefense();
        if (normalAttack < 0){
            normalAttack = 0;
        }
        if (Math.random() < 0.35){
            System.out.println("스킬 발동!");
            fireSkill = normalAttack + this.getFireSkillDamage();
            return  fireSkill;
        } return normalAttack;

    }


}


