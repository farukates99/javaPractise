public abstract class GameCharacter {
    private String charType;
    private int damage;
    private int health;
    private int money;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharType() {
        return charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public GameCharacter(int id,String charType, int damage, int health, int money){
        this.charType=charType;
        this.damage=damage;
        this.health=health;
        this.money=money;
        this.id=id;
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
