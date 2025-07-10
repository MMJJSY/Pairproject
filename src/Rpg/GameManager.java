package Rpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GameManager  {
    public static void main(String[] args) {


        List<Monster> monster = new ArrayList<>();
        monster.add(new NormalMonster("슬라임", 30, 8, 3) {});
        monster.add(new NormalMonster("오크", 40, 12, 5) {});
        monster.add(new NormalMonster("스켈레톤", 60, 14, 10) {});
        monster.add(new NormalMonster("트롤", 120, 18, 6) {});
        monster.add(new NormalMonster("골렘", 100, 20, 25) {});
        monster.add(new NormalMonster("와이번", 150, 25, 15) {});
        monster.add(new NormalMonster("리치", 130, 35, 12) {});
        monster.add(new NormalMonster("고블린", 50, 12, 4) {});
        monster.add(new NormalMonster("키메라", 200, 30, 20) {});
        monster.add(new NormalMonster("드래곤", 300, 40, 30) {});
        monster.add(new FireMonster("이프리트", 140, 22, 18, 35) {});
        monster.add(new FireMonster("헬하운드", 90, 28, 10, 25) {});
        monster.add(new FireMonster("파이어 골렘", 180, 25, 22, 20) {});



        for (Monster m : monster) {
            m.info();
        }
        for (int i = 0; i < monster.size() ; i++) {
            System.out.println(i+1 + "번 째 몬스터 : " + monster.get(i).getName() );
        }

        Scanner monsterFirst = new Scanner(System.in);
        System.out.println("첫번째 몬스터의 번호를 고르시오");
        int a = monsterFirst.nextInt();
        if (a < 1 || a > monster.size()){
            System.out.println("잘못된 입력입니다.");
        }

        Scanner monsterSecond = new Scanner(System.in);
        System.out.println("두번째 몬스터의 번호를 고르시오");
        int b = monsterSecond.nextInt();

        if (b < 1 || b > monster.size()){
            System.out.println("잘못된 입력입니다.");
        }

        Monster monster1;
        Monster monster2;


        monster1 = monster.get(a-1);
        monster2 = monster.get(b-1);

        while (monster1.getHp() > 0 && monster2.getHp() > 0) {
            System.out.println(monster1.getName()+"의 공격!");
            int attackDamage = monster1.attack(monster2);
            if(attackDamage < 0 ){
                 attackDamage = 0;
            }
            monster2.setHp(monster2.getHp() - attackDamage);


            System.out.println("남은 체력 : " + monster2.getName() +" " + monster2.getHp());
            System.out.println();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Monster temp = monster1;
            monster1 = monster2;
            monster2 = temp;

        }  if(monster2.getHp() <= 0){
            System.out.println(monster1.getName()+ " 이/가 승리했습니다.");
        } else {
            System.out.println(monster2.getName()+ " 이/가 승리했습니다.");
        }
    }
}


