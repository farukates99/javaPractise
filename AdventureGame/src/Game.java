import java.sql.SQLOutput;
import java.util.Scanner;
public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println();
        System.out.println("Welcome to the Adventure Game");
        System.out.print("Please enter your character name;");
        String charName = input.nextLine();
        Player player=new Player(charName);
        System.out.println(player.getCharName()+", Are you ready???");
        System.out.println();
        System.out.println("Choose your character:");
        player.selectChar();
        player.selectLoc();
    }
}
