public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    boolean onLocation() {
        System.out.println("Hier is the safe house");
        System.out.println("You are safe bro, be calm and relax");
        System.out.println("Your health is being full");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth());
        return true;
    }

}
