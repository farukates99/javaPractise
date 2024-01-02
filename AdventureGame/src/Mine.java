public class Mine extends BattleLoc{
    public Mine(Player player,int damage) {
        super(player, "Mine", new Snake(damage), "food",3);
    }
}
