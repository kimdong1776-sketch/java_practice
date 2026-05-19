package hw08;

public class Monster extends Unit {
    private int expReward;
    private int goldReward;

    public Monster(String name, int maxHp, int atk, int expReward, int goldReward) {
        super(name, maxHp, atk);
        this.expReward = expReward;
        this.goldReward = goldReward;
    }

    public void attack(Player target) {
        System.out.println("💥 [" + this.name + "]의 반격! [" + target.getName() + "]에게 " + this.atk + "의 데미지를 입혔습니다.");
        target.takeDamage(this.atk);
    }

    public int getExpReward() { return expReward; }
    public int getGoldReward() { return goldReward; }
}
