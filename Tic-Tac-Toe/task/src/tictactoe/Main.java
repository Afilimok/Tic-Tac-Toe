package tictactoe;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y = 0;
        Game game = new Game("_________");
        game.print();
        boolean success = false;
        char g = 'X';
        while (!success) {
            System.out.print("Enter the coordinates: ");
            try {
                x = scanner.nextInt();
                y = scanner.nextInt();
                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (game.Add(x, y, g)) {
                        if (g == 'X')
                            g = 'O';
                        else
                            g = 'X';
                        game.print();
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
            if (game.Full() && !game.OWin() && !game.XWin()) {
                System.out.println("Draw");
                return;
            }
            if (game.OWin()) {
                System.out.println("O wins");
                return;
            }
            if (game.XWin()) {
                System.out.println("X wins");
                return;
            }

        }
    }
}
