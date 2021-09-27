package task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Scene {

    public static void main(String[] args) throws IOException {

        int row = 16, col = 16;                //矩阵尺寸
        Matrix matrix = new Matrix(row,col);
        Random randnum = new Random();

        int temp_r, temp_g,temp_b;          //随机rgb值
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                temp_r = randnum.nextInt(256);
                temp_g = randnum.nextInt(256);
                temp_b = randnum.nextInt(256);
                matrix.put(new Monster(temp_r,temp_g,temp_b), i, j);
            }
        }

        Snake theSnake = Snake.getTheSnake();

        // Sorter sorter = new BubbleSorter();
        Sorter sorter = new SelectSorter();
        // Sorter sorter = new QuickSorter();

        theSnake.setSorter(sorter);

        // String log = theSnake.lineUp(matrix.toLine());
        String log = theSnake.lineUp(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
