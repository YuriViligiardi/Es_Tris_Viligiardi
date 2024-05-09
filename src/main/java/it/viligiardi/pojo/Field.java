package it.viligiardi.pojo;

public class Field {
    // attributes
    private final int dim = 3;
    private String[][] matrix = new String[dim][dim];
    // methods and constructions

    public Field() {
    }

    public int getDim() {
        return dim;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }
}
