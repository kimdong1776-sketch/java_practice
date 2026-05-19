package hw08;

import java.util.Scanner;
import java.util.Random;

public class GameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=================================");
        System.out.println("    [ Java Text RPG : 슬라임 던전 ]    ");
        System.out.println("=================================");
        System.out.print("▶ 용사의 이름을 입력하세요: ");
        String playerName = scanner.next();
        Player player = new Player(playerName);

        int winCount = 0; // 보스 출현을 위한 승리 카운트

        while (true) {
            player.printStatus();
            System.out.println("\n무엇을 하시겠습니까?");
            System.out.println("1. 던전 탐험 (전투)");
            System.out.println("2. 상점 방문");
            System.out.println("0. 게임 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();

            if (choice == 1) { // 전투 로직
                Monster enemy;
                if (winCount >= 4) {
                    enemy = new Monster("최종 보스 드래곤", 150, 20, 100, 200);
                    System.out.println("\n🚨 경고! 최종 보스가 나타났습니다! 🚨");
                } else {
                    int rand = random.nextInt(2);
                    if (rand == 0) enemy = new Monster("슬라임", 30, 5, 20, 15);
                    else enemy = new Monster("오크", 50, 12, 40, 25);
                    System.out.println("\n야생의 [" + enemy.getName() + "]이(가) 나타났다!");
                }

                while (!player.isDead() && !enemy.isDead()) {
                    System.out.println("\n--- 전투 메뉴 ---");
                    System.out.println("내 체력: " + player.getHp() + " | 적 체력: " + enemy.getHp());
                    System.out.println("1. 공격  2. 물약 사용  3. 도망");
                    System.out.print("선택: ");
                    int battleChoice = scanner.nextInt();

                    if (battleChoice == 1) {
                        player.attack(enemy);
                        if (!enemy.isDead()) enemy.attack(player);
                    } else if (battleChoice == 2) {
                        player.usePotion();
                        enemy.attack(player);
                    } else if (battleChoice == 3) {
                        System.out.println("🏃 무사히 도망쳤습니다!");
                        break;
                    }

                    if (player.isDead()) {
                        System.out.println("\n💀 앗.. 눈앞이 깜깜해졌다. 게임 오버!");
                        System.out.println("최종 레벨: " + player.getLevel() + " | 진행 턴 수: " + player.getTotalTurns());
                        System.exit(0);
                    }
                    if (enemy.isDead()) {
                        player.win(enemy);
                        winCount++;
                        if (enemy.getName().equals("최종 보스 드래곤")) {
                            System.out.println("\n👑 축하합니다! 최종 보스를 물리치고 세계를 구했습니다! 👑");
                            System.out.println("최종 레벨: " + player.getLevel() + " | 소모한 턴 수: " + player.getTotalTurns());
                            System.exit(0);
                        }
                    }
                }
            } else if (choice == 2) { // 상점 로직
                System.out.println("\n=== 상점에 오신 것을 환영합니다! ===");
                System.out.println("보유 골드: " + player.getGold() + "G");
                System.out.println("1. 체력 물약 구매 (30G)");
                System.out.println("2. 무기 강화 (50G)");
                System.out.println("0. 나가기");
                System.out.print("선택: ");
                int shopChoice = scanner.nextInt();
                
                if (shopChoice == 1) player.buyPotion();
                else if (shopChoice == 2) player.upgradeWeapon();
                else System.out.println("상점을 나옵니다.");
            } else if (choice == 0) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}