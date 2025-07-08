package Rpg;



public class Monster {
    // 필드
    private String name; // 이름
    private int hp; // 체력
    private int maxHp; // 최대체력
    private int attack; // 공격력
    private int defense; // 방어력

    // 생성자
    public Monster() {
    }

    public Monster(String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp <= 0) {
            this.hp = 0;
        }
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;

    }


    public void info() {
        System.out.println("이름 : " + this.name + ", 체력 : (" + this.hp + "/" + this.maxHp + ")" + ", 공격력 : " + this.attack +
                ", 방어력 : " + this.defense);

    }






}







