package workngWithAbstractionExercise.jediGalaxy;

public class Field {
    private int[][] field;

    public Field(int[] dimension) {
        this.field = new int[dimension[0]][dimension[1]];
        fillMatrix();
    }

    public void setFieldValue(int row, int column, int value) {
        this.field[row][column] = value;
    }

    public int getInnerLength(int dimension) {
        return this.field[dimension].length;
    }

    public int getLength() {
        return this.field.length;
    }

    public int getFieldValue(int row, int column) {
        return this.field[row][column];
    }


    private void fillMatrix() {
        int value = 0;
        for (int r = 0; r < this.field.length; r++) {
            for (int c = 0; c < this.field[r].length; c++) {
                this.field[r][c] = value++;
            }
        }
    }


}
