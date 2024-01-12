import java.util.*;

public class FixtureGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the team number: ");
        int numberOfTeam = scanner.nextInt();

        List<String> teamName = new ArrayList<>();
        for (int i = 0; i < numberOfTeam; i++) {
            System.out.print("Enter the " + (i + 1) + ". team: ");
            teamName.add(scanner.next());
        }
        if((numberOfTeam%2==1)){
            teamName.add("Bay");
        }

        List<List<String>> fixture = generateFixture(teamName);

        printFixture(fixture);
    }

    private static List<List<String>> generateFixture(List<String> nameOfTeams) {
        List<List<String>> fixture = new ArrayList<>();

        int numberOfTeam = nameOfTeams.size();
        int totalWeek = numberOfTeam - 1;

        Collections.shuffle(nameOfTeams);

        for (int week = 1; week <= totalWeek*2; week++) {
            List<String> weeklyFixture = new ArrayList<>();

            for (int i = 0; i < numberOfTeam / 2; i++) {

                String home;
                String deplasman;
                if(week<totalWeek+1){
                 home = nameOfTeams.get(i);
                 deplasman = nameOfTeams.get(numberOfTeam - 1 - i);
                }else {
                 home = nameOfTeams.get(numberOfTeam - 1 - i);
                 deplasman = nameOfTeams.get(i);
                }
                String mac = home + " vs " + deplasman;
                weeklyFixture.add(mac);
            }

            fixture.add(weeklyFixture);

            Collections.rotate(nameOfTeams.subList(1, numberOfTeam), 1);
        }

        return fixture;
    }

    private static void printFixture(List<List<String>> fikstur) {
        System.out.println("\nMaç Fikstürü:");
        for (int hafta = 1; hafta <= fikstur.size(); hafta++) {
            System.out.println("Hafta " + hafta + ": " + fikstur.get(hafta - 1));
        }
    }
}
