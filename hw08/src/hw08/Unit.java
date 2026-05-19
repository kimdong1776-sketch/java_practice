package hw08;


public class Unit {
 protected String name;
 protected int hp;
 protected int maxHp;
 protected int atk;

 public Unit(String name, int maxHp, int atk) {
     this.name = name;
     this.maxHp = maxHp;
     this.hp = maxHp;
     this.atk = atk;
 }

 public void takeDamage(int damage) {
     this.hp -= damage;
     if (this.hp < 0) this.hp = 0;
 }

 public boolean isDead() {
     return this.hp <= 0;
 }

 // Getter 메서드들
 public String getName() { return name; }
 public int getHp() { return hp; }
 public int getAtk() { return atk; }
}