package workngWithAbstractionExercise.jediGalaxy;

public class Evil {
    private int row;
    private int column;


    public Evil(int[] coordinates) {
        this.row = coordinates[0];
        this.column = coordinates[1];
    }


    public void move(Field field) {
        while (row >= 0 && column >= 0) {
            if (row < field.getLength()
                    && column < field.getInnerLength(row)) {
                field.setFieldValue(row, column, 0);
            }
            row--;
            column--;
        }
    }
}


