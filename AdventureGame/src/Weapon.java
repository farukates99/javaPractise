public class Weapon {
    private int id;
    private int damage;
    private int price;
    private String name;

    public Weapon(int id, int damage, int price, String name) {
        this.id = id;
        this.damage = damage;
        this.price = price;
        this.name = name;
    }

    public static Weapon[] weapons() {

        Weapon[] weapons = {new Weapon(1, 2, 5, "Gun"),
        new Weapon(2,3,35,"Sword"),
        new Weapon(3,7,45,"Rifle")};
        return weapons;
    }
    public static Weapon getWeaponObj(int id) {
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
