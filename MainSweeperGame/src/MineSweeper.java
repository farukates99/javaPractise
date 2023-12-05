import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    int row;
    int column;
    String[][] place;
    String[][] place2;
    int quantityOfSweeper;

    MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.quantityOfSweeper = (row * column) / 4;
        this.place = new String[row][column];
        this.place2= new String[row][column];
    }

    void sweeperPlacing() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.place[i][j] = "-";
                this.place2[i][j]="-";
                System.out.print(place[i][j]);
            }
            System.out.println();
        }
        int i = 0;
        while (i < quantityOfSweeper) {
            Random rand = new Random();
            int row1 = rand.nextInt(this.row);
            int column1 = rand.nextInt(this.column);
            if (this.place[row1][column1] == "-") {
                this.place[row1][column1] = "*";
                i++;
            }
        }
        getValuefromUser();
    }

    void getValuefromUser() {
        Scanner input = new Scanner(System.in);
        while((this.row*this.column-this.quantityOfSweeper)!=0){
        System.out.print("Enter a column: ");
        int c = input.nextInt();
        while (c > this.column-1) {
            System.out.print("column is invalid enter again:");
            c = input.nextInt();
        }
        System.out.print("Enter a row: ");
        int r = input.nextInt();
        while (r > this.row-1) {
            System.out.print("row is invalid enter again:");
            r = input.nextInt();
        }
        int totalSweep = 0;
        if (this.place[r][c] == "*") {
            System.out.println("Game Over");
            return;
        } else {
            for (int i = r - 1; i < r + 2; i++) {
                if (i < 0 || i >= this.row) {
                    continue;
                }
                for (int j = c - 1; j < c + 2; j++) {
                    if (j < 0 || j >= this.column) {
                        continue;
                    }
                    if (this.place[i][j] == "*") {
                        totalSweep++;
                    }
                }
            }
        }
        this.place2[r][c] = Integer.toString(totalSweep);
        writePlace();
        this.quantityOfSweeper++;

    }
        System.out.println("you win");
    }
    void writePlace(){
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(this.place2[i][j]);
            }
            System.out.println();
        }
    }
}
