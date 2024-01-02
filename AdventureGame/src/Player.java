import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String charName;
    private int id;
    private int defHealth;

    Inventory inventory=new Inventory();
    private Scanner input = new Scanner(System.in);
    public Player(String charName){
        this.charName=charName;
    }
    public void selectChar(){
        GameCharacter[] charList={new Samuray(),new Archer(),new Knight()};
        for(GameCharacter gameCharacter: charList) {
            System.out.println(gameCharacter.getId()+".Character:"+ gameCharacter.getCharType()+ "\t damage:" +gameCharacter.getDamage()+  "\t health:"+ gameCharacter.getHealth()+"\t money:"+gameCharacter.getMoney());
        }
        System.out.println("Choose Your Character: ");
        int charid= input.nextInt();
        while (charid>3 || charid<1){
            System.out.println("Only enter 1,2,3");
            System.out.println("Choose Your Character");
            charid= input.nextInt();
        }
        this.damage=charList[charid-1].getDamage();
        this.health=charList[charid-1].getHealth();
        this.defHealth=charList[charid-1].getHealth();
        this.money=charList[charid-1].getMoney();
        System.out.println("##################");
        System.out.println(charName+", You are the "+charList[charid-1].getCharType());
    }

    public void selectLoc(){
        Location location=new SafeHouse(this);
        while (true) {

            if (this.inventory.isFood() && this.inventory.isFisch() && this.inventory.isFirewood()) {
                System.out.println("You win!!");
                break;
            }

            printCharacter();
            System.out.println("##################");
            System.out.println("You are in the " + location.getLocName());
            System.out.println();
            System.out.println("Choose where you want to go:");
            System.out.println("1.Safe House");
            System.out.println("2.Store");
            System.out.println("3.Cave");
            System.out.println("4.Forest");
            System.out.println("5.River");
            System.out.println("6.Mine");
            int chooseLoc = input.nextInt();
            while (chooseLoc < 1 || chooseLoc > 6) {
                System.out.println("There is no place like that");
                System.out.println("Enter again");
                chooseLoc = input.nextInt();
            }

            System.out.println("#################");
            switch (chooseLoc) {
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new Store(this);
                    break;
                case 3:
                    if (this.inventory.isFood()) {
                        System.out.println("Dude, you killed all enemy");
                        System.out.println("Choose another area");
                        break;
                    }
                    location = new Cave(this);
                    break;
                case 4:
                    if (this.inventory.isFirewood()) {
                        System.out.println("Dude, you killed all enemy");
                        System.out.println("Choose another area");
                        break;
                    }
                    location = new Forest(this);
                    break;
                case 5:
                    if (this.inventory.isFisch()) {
                        System.out.println("Dude, you killed all enemy");
                        System.out.println("Choose another area");
                        break;
                    }
                    location = new River(this);
                    break;
                case 6:
                    Random random=new Random();
                    int randDamage= random.nextInt(4)+4;
                    location = new Mine(this,randDamage);
                    break;
                default:
                    location = new SafeHouse(this);
            }
            if (location.isFinish()) {
            }else if (!location.onLocation()) {
                    System.out.println("Looser");
                    break;
                }
        }
    }

    public void printCharacter(){
        System.out.println("#################");
        System.out.println(charName+":");
        System.out.println("Damage: "+ getDamage());
        System.out.println("Health: "+getHealth());
        System.out.println("Block: "+getInventory().getArmor().getProtect());
        System.out.println("Money: "+getMoney());
        System.out.println("Weapon:"+getInventory().getWeapon().getName());
        System.out.println("Armor:"+getInventory().getArmor().getName());
        System.out.println("#################");

    }

    public int getDamage() {
        return damage+this.inventory.getWeapon().getDamage();
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

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

}
