package workngWithAbstractionExercise.jediGalaxy;

public class Player {
    private int row;
    private int column;

    private long points;


    public Player(int[] coordinates) {
        this.row = coordinates[0];
        this.column = coordinates[1];
        this.points = 0;
    }

    public long getPoints() {
        return points;
    }

    public void move(Field field) {

        while (row >= 0 && column < field.getInnerLength(1)) {
            if (row < field.getLength()
                    && column >= 0 && column < field.getInnerLength(0)) {
                this.points += field.getFieldValue(row, column);
            }
            column++;
            row--;
        }

    }
}
