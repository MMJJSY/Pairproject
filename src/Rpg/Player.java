package Rpg;
import javax.swing.*;
import java.util.Scanner;

public class Player extends Monster {
    private int level;
    private int experience;
    private int experienceToNext;
    private int statPoints;
    private int maxMp;
    private int mp;

    public Player(String name) {
        super(name, 100, 15, 8);
        this.level = 1;
        this.experience = 0;
        this.experienceToNext = 100;
        this.statPoints = 0;
        this.maxMp = 50;
        this.mp = maxMp;
    }

    @Override
    public int attack(Monster target) {
        int damage = 0;
        // 코드 구현 필요
        if (Math.random() < 0.15) {
            System.out.println(this.getName() + " 크티티컬 히트!");
            damage = this.getAttack() * 2;
        } else {
            damage = this.getAttack() - target.getDefense();
        }
        return Math.max(damage, 0);
    }

    public double skillAttack(Monster target) {
        double damage = 0;
        if (this.mp < 20) {
            System.out.println("마나가 부족합니다");
        } else {
            this.setMp(getMp() - 20);
            System.out.println("파워 어택 스킬 발동!");
            damage = (this.getAttack() * 1.5) - (target.getDefense() * 0.5);
        } return Math.max(damage, 0);
    }


    public void heal() {
        if(this.mp < 15){
            System.out.println("마나가 부족합니다");

        } else {
            this.setMp(this.getMp()-15);
            this.setHp(this.getHp() + 30);
            if (this.getHp() > this.getMaxHp()){
                this.setHp(getMaxHp());
                System.out.println("체력을 30 회복했습니다! 현재 HP : " + this.getHp() +"/" +this.getMaxHp());
            }
        }


        // 코드 구현 필요
    }

    public void gainExperience(int exp) {

        this.setExperience(this.getExperience()+ exp);
        System.out.println("경험치 (" +exp+") 획득!");
        while (this.getExperience() >= this.experienceToNext) {
            levelUp();
        }


        // 코드 구현 필요
    }

    private void levelUp() {

        this.setExperience(this.getExperience()-this.experienceToNext);
        this.setLevel(this.getLevel()+1);
        this.setExperienceToNext(this.getLevel() * 120);
        this.setStatPoints(this.getStatPoints()+3);
        this.setMaxHp(this.getMaxHp()+20);
        this.setHp(this.getMaxHp());
        this.setMaxMp(this.getMaxMp()+10);
        this.setMp(this.getMaxMp());
        System.out.println("축하합니다! 레벨이 1 상승하였습니다.");
        System.out.println("현재레벨 : " + this.getLevel());

        // 코드 구현 필요
    }

    public void allocateStatPoints(Scanner scanner) {
        if (this.getStatPoints() <= 0){
            System.out.println("사용 가능한 스탯 포인트가 없습니다.");
        } else {
            System.out.println("어떤 스탯을 증가시키겠습니까?");
            System.out.println("1.공격력+2, 2.방어력+3, 3.체력+30, 4.마나+20 ");
            Scanner stat = new Scanner(System.in);
            int a;
            a = stat.nextInt();
            switch (a) {
                case 1:
                    this.setAttack(this.getAttack()+2);
                    System.out.println("공격력이 2 증가했습니다!");
                    this.setStatPoints(this.getStatPoints()-1);
                    break;
                case 2:
                    this.setDefense(this.getDefense()+3);
                    System.out.println("방어력이 3 증가했습니다!");
                    this.setStatPoints(this.getStatPoints()-1);
                    break;
                case 3:
                    this.setMaxHp(this.getMaxHp()+30);
                    if (getHp()+30 <= getMaxHp()){
                    this.setHp(this.getHp()+30);
                    } else this.setHp(this.getMaxHp());
                    System.out.println("최대 체력이 30 증가했습니다!");
                    this.setStatPoints(this.getStatPoints()-1);
                    break;
                case 4:
                    this.setMaxMp(this.getMaxMp()+20);
                    if (this.getMp()+20 <= this.getMaxMp()){
                        this.setMp(this.getMp()+20);
                    } else setMp(this.getMaxMp());
                    System.out.println("최대 마나가 20 증가했습니다!");
                    this.setStatPoints(getStatPoints()-1);
                    break;

                default:
                    System.out.println("잘못된 선택입니다.");

            }

        }
        // 코드 구현 필요
    }

    public void restoreMp() {
        if (this.getMp()+10 <= this.getMaxMp()){
        this.setMp(this.getMp()+10);
        } else setMp(this.getMaxMp());

        // 코드 구현 필요
    }

    @Override
    public String info() {
        return String.format("[%s] Lv.%d (HP: %d/%d) (MP: %d/%d) (ATT: %d) (DEF: %d) (EXP: %d/%d) (SP: %d)",
                getName(), level, getHp(), getMaxHp(), mp, maxMp,
                getAttack(), getDefense(), experience, experienceToNext, statPoints);
    }

    // Getters and Setters
    public int getLevel() { return level; }
    public int getExperience() { return experience; }
    public int getStatPoints() { return statPoints; }
    public int getMp() { return mp; }
    public int getMaxMp() { return maxMp; }
    public void setMp(int mp) { this.mp = mp; }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperienceToNext() {
        return experienceToNext;
    }

    public void setExperienceToNext(int experienceToNext) {
        this.experienceToNext = experienceToNext;
    }

    public void setStatPoints(int statPoints) {
        this.statPoints = statPoints;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }
}

