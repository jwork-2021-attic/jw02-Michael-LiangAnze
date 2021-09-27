package task3;

public class Matrix extends Line{

    int row;
    int col;
    Line[] theMatrix;


    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        theMatrix = new Line[row];
        for(int i = 0;i < row;i++){
            theMatrix[i] = new Line(col);
        }
    }

    public void put(Linable linable, int row, int col) {
        theMatrix[row].put(linable, col);
    }

    public Linable get(int row, int col) {
        return theMatrix[row].get(col);
    }

    @Override
    public String toString() {
        String lineString = "";
        for(int i = 0;i < row;i++){
            lineString += "\t";
            lineString += theMatrix[i].toString();
            lineString += "\n";
        }
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[row*col];

        for(int i = 0;i < row;i++){
            for (int j = 0; j < col; j++) {
                linables[i * col + j] = this.get(i,j);
            }
        }
        return linables;
    }

    
    public void swapPosition(int i,int j) {
        int row1 = i / row, col1 = i % row;
        int row2 = j / row, col2 = j % row;
        Linable l1 = theMatrix[row1].get(col1);
        Linable l2 = theMatrix[row2].get(col2);
        theMatrix[row1].put(l2, col1);
        theMatrix[row2].put(l1, col2);
    }

}
