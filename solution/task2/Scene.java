package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Scene {

    public static void main(String[] args) throws IOException {

        int total_len = 256;                //总长度
        Line line = new Line(total_len);
        Random randnum = new Random();

        int temp_r, temp_g,temp_b;          //生成随机rgb值
        for(int i = 0;i < total_len;i++)
        {
            temp_r = randnum.nextInt(256);
            temp_g = randnum.nextInt(256);
            temp_b = randnum.nextInt(256);
            line.put(new Monster(temp_r,temp_g,temp_b), i);
        }

        Snake theSnake = Snake.getTheSnake();

        // Sorter sorter = new BubbleSorter();
        Sorter sorter = new SelectSorter();
        // Sorter sorter = new QuickSorter();

        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
