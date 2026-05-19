package hw08;

public class Player extends Unit {
    private int level = 1;
    private int exp = 0;
    private int gold = 0;
    private int potions = 3;
    private int totalTurns = 0;

    public Player(String name) {
        super(name, 50, 10); // 초기 체력 50, 공격력 10
    }

    public void attack(Monster target) {
        System.out.println("\n⚔️ [" + this.name + "]의 공격! [" + target.getName() + "]에게 " + this.atk + "의 데미지를 입혔습니다.");
        target.takeDamage(this.atk);
        totalTurns++;
    }

    public void usePotion() {
        if (potions > 0) {
            this.hp += 20;
            if (this.hp > this.maxHp) this.hp = this.maxHp;
            potions--;
            System.out.println("🧪 물약을 사용했습니다! 체력이 20 회복됩니다. (남은 물약: " + potions + "개)");
        } else {
            System.out.println("❌ 물약이 부족합니다!");
        }
        totalTurns++;
    }

    public void win(Monster target) {
        this.exp += target.getExpReward();
        this.gold += target.getGoldReward();
        System.out.println("\n🎉 전투 승리! 경험치 " + target.getExpReward() + "과 골드 " + target.getGoldReward() + "G를 얻었습니다.");
        checkLevelUp();
    }

    private void checkLevelUp() {
        if (this.exp >= level * 30) {
            this.exp -= level * 30;
            this.level++;
            this.maxHp += 20;
            this.hp = this.maxHp; // 레벨업 시 체력 완전 회복
            this.atk += 5;
            System.out.println("🌟 LEVEL UP! 현재 레벨: " + this.level + " (체력과 공격력이 상승했습니다!)");
        }
    }

    public void buyPotion() {
        if (this.gold >= 30) {
            this.gold -= 30;
            this.potions++;
            System.out.println("🛒 물약을 구매했습니다. (남은 골드: " + this.gold + "G)");
        } else {
            System.out.println("❌ 골드가 부족합니다.");
        }
    }

    public void upgradeWeapon() {
        if (this.gold >= 50) {
            this.gold -= 50;
            this.atk += 5;
            System.out.println("🗡️ 무기를 강화했습니다! 공격력이 5 상승합니다. (현재 공격력: " + this.atk + ")");
        } else {
            System.out.println("❌ 골드가 부족합니다.");
        }
    }

    public void printStatus() {
        System.out.println("\n=== [" + this.name + "] 님의 상태창 ===");
        System.out.println("레벨: " + level + " | 경험치: " + exp + "/" + (level * 30));
        System.out.println("체력: " + hp + "/" + maxHp + " | 공격력: " + atk);
        System.out.println("골드: " + gold + "G | 물약: " + potions + "개");
        System.out.println("=============================");
    }

    public int getLevel() { return level; }
    public int getTotalTurns() { return totalTurns; }
    public int getGold() { return gold; }
}