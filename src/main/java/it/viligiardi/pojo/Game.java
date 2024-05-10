package it.viligiardi.pojo;

public class Game {
    // attributes
    public static Field f = new Field();
    public static Player p1 = new Player("GIOCATORE", "O");
    public static Player p2 = new Player("GIOCATORE", "X");
    // methods and constructions

    public static boolean placeSymbol(int x, int y, Player p) {
        if (isEmpty(x, y)) {
            Game.f.getMatrix()[x][y] = p.getSymbol();
            return true;
        } else {
            return false;
        }
    }

    /*
     * public static void placeSymbolRandom(Player p) {
     * boolean control;
     * do {
     * int x = (int) (Math.random() * 3);
     * int y = (int) (Math.random() * 3);
     * control = placeSymbol(x, y, p);
     * } while (control != true);
     * }
     */

    public static boolean isEmpty(int x, int y) {
        if (Game.f.getMatrix()[x][y] == "X" || Game.f.getMatrix()[x][y] == "O") {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isVictory(Player p) {
        if ((Game.f.getMatrix()[0][0] == p.getSymbol() && Game.f.getMatrix()[1][0] == p.getSymbol()
                && Game.f.getMatrix()[2][0] == p.getSymbol())
                || (Game.f.getMatrix()[0][1] == p.getSymbol() && Game.f.getMatrix()[1][1] == p.getSymbol()
                        && Game.f.getMatrix()[2][1] == p.getSymbol())
                || (Game.f.getMatrix()[0][2] == p.getSymbol() && Game.f.getMatrix()[1][2] == p.getSymbol()
                        && Game.f.getMatrix()[2][2] == p.getSymbol())) {
            return true;
        } else if ((Game.f.getMatrix()[0][0] == p.getSymbol() && Game.f.getMatrix()[0][1] == p.getSymbol()
                && Game.f.getMatrix()[0][2] == p.getSymbol())
                || (Game.f.getMatrix()[1][0] == p.getSymbol() && Game.f.getMatrix()[1][1] == p.getSymbol()
                        && Game.f.getMatrix()[1][2] == p.getSymbol())
                || (Game.f.getMatrix()[2][0] == p.getSymbol() && Game.f.getMatrix()[2][1] == p.getSymbol()
                        && Game.f.getMatrix()[2][2] == p.getSymbol())) {
            return true;
        } else if ((Game.f.getMatrix()[0][0] == p.getSymbol() && Game.f.getMatrix()[1][1] == p.getSymbol()
                && Game.f.getMatrix()[2][2] == p.getSymbol())
                || (Game.f.getMatrix()[2][0] == p.getSymbol() && Game.f.getMatrix()[1][1] == p.getSymbol()
                        && Game.f.getMatrix()[0][2] == p.getSymbol())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDraw() {
        for (int x = 0; x < Game.f.getDim(); x++) {
            for (int y = 0; y < Game.f.getDim(); y++) {
                if (Game.f.getMatrix()[x][y] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void resetField() {
        for (int x = 0; x < Game.f.getDim(); x++) {
            for (int y = 0; y < Game.f.getDim(); y++) {
                Game.f.getMatrix()[x][y] = null;
            }
        }
    }

    public static void viewMatrix() {
        for (int x = 0; x < Game.f.getDim(); x++) {
            System.out.println(" ");
            for (int y = 0; y < Game.f.getDim(); y++) {
                System.out.print(Game.f.getMatrix()[x][y] + " ");

            }
        }
    }
}
