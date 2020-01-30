package tictactoe;

public class Game {

    char[] map = new char[9];

    Game(String s) {
        for (int i = 0; i < 9; i++) {
            this.map[i] = s.charAt(i);
        }
    }

    void print() {
        System.out.format("---------\n" +
                "| %c %c %c |\n" +
                "| %c %c %c |\n" +
                "| %c %c %c |\n" +
                "---------\n", this.map[0], this.map[1], this.map[2], this.map[3], this.map[4], this.map[5], this.map[6], this.map[7], this.map[8]);
    }

    boolean Win(char qq) {
        for (int t = 0; t < 3; t++) {
            int y = 0, x = 0;
            for (int i = 0; i < 3; i++) {
                if (this.map[t * 3 + i] == qq)
                    y++;
                if (this.map[t + i * 3] == qq)
                    x++;
            }
            if (y == 3 || x == 3)
                return true;
        }
        if (this.map[0] == qq && this.map[4] == qq && this.map[8] == qq)
            return true;
        return this.map[2] == qq && this.map[4] == qq && this.map[6] == qq;

    }

    boolean XWin() {
        return Win('X');
    }

    boolean OWin() {
        return Win('O');
    }

    boolean Difference() {
        int x = 0, o = 0;
        for (int i = 0; i < 9; i++) {
            if (this.map[i] == 'X')
                x++;
            if (this.map[i] == 'O')
                o++;
        }
        return Math.abs(x - o) <= 1;
    }

    boolean Full() {
        int x = 0;
        for (int i = 0; i < 9; i++) {
            if (this.map[i] != '_')
                x++;
        }
        return x == 9;
    }

    boolean Add(int x, int y, char c) {
        int pos = (3 - y) * 3 + x - 1;
        if (this.map[pos] == '_') {
            this.map[pos] = c;
            return true;
        }
        return false;
    }

}

