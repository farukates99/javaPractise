import javax.sound.midi.Soundbank;
import java.util.SortedMap;

public class Store extends NormalLoc {
    public Store(Player player) {
        super(player, "Store");
    }

    @Override
    boolean onLocation() {
        System.out.println("Hier is a store");
        System.out.println("If you have money,then purchase something");
        System.out.println("1.Weapon");
        System.out.println("2.Armor");
        System.out.println("3.Exit");
        int selectCase = Location.input.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Wrong Case , Again");
            selectCase = Location.input.nextInt();
        }
        switch (selectCase) {

            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                return true;
        }
        return super.onLocation();
    }

    public void printArmor() {
        System.out.println("Choose what you want:");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "." + a.getName() + "\t Damage:" + a.getProtect() + "\t Price:" + a.getPrice());
        }

    }

    public void buyArmor() {
        int selectArmor = Location.input.nextInt();
        while (selectArmor < 1 || selectArmor > Armor.armors().length) {
            System.out.println("Wrong Case , Again");
            selectArmor = Location.input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObj(selectArmor);
        if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
            System.out.println("You are miserable, bro");
        } else {
            System.out.println(selectedArmor.getName() + " alındı");
            this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
            System.out.println("Your money=" + this.getPlayer().getMoney());
            System.out.println(this.getPlayer().getInventory().getArmor().getName());
            this.getPlayer().getInventory().setArmor(selectedArmor);
            System.out.println(this.getPlayer().getInventory().getArmor().getName());

        }
    }
    public void winWeapon(){

    }
    public void printWeapon() {
        System.out.println("Choose what you want");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "." + w.getName() + "\t Damage:" + w.getDamage() + "\t Price:" + w.getPrice());
        }


    }

    public void buyWeapon() {
        int selectWeapon = Location.input.nextInt();
        while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Wrong Case , Again");
            selectWeapon = Location.input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObj(selectWeapon);
        if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
            System.out.println("You are miserable, bro");
        } else {
            System.out.println(selectedWeapon.getName() + " alındı");
            this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
            System.out.println("Your money=" + this.getPlayer().getMoney());
            System.out.println(this.getPlayer().getInventory().getWeapon().getName());
            this.getPlayer().getInventory().setWeapon(selectedWeapon);
            System.out.println(this.getPlayer().getInventory().getWeapon().getName());

        }
    }
}
