public class Obstacle {
        private int id;
        private int damage;
        private int health;
        private int money;
        private String name;
        private int defHealth;

    public Obstacle(int id, int damage, int health, int money, String name, int defHealth) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name = name;
        this.defHealth = defHealth;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
