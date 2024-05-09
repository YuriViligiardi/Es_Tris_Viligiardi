package it.viligiardi.pojo;

public class Player {
    // attributes
    private String name;
    private String symbol;
    private Integer score = 0;
    // methods and constructions

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setNickName(String s, int num) {
        if (s == null || s.equals("")) {
            this.name = "GIOCATORE" + num;
        } else {
            this.name = s;
        }
    }
}
