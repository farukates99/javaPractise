public class Inventory {
        private Weapon weapon;
        private Armor armor;
        private boolean food;
        private boolean firewood;
        private boolean fisch;
    public Inventory() {
        this.weapon = new Weapon(0,0,0,"Punch");
        this.armor = new Armor(0,0,0,"No armor");
        this.firewood=false;
        this.fisch=false;
        this.food=false;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isFisch() {
        return fisch;
    }

    public void setFisch(boolean fisch) {
        this.fisch = fisch;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
