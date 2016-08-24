package GrainBoundarySimulation;

import java.awt.*;

/**
 * Created by yulia on 27.07.16.
 */

public class Canvas {

    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void clear()
    {
        this.matrix = new char[height][width];
    }

    public void setPoint(int x, int y, char c)
    {
        matrix[y][x] = c;
    }

    public void print()
    {
        System.out.println();

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }

    public void draw(Graphics g)
    {
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(Character.isDigit(matrix[i][j])) {
                    int color = Character.digit(matrix[i][j], 10)*255/9;
                    g.setColor(new Color(color, color, color));
                }
                else if(matrix[i][j] == 'X')
                    g.setColor(Color.red);
                else
                    g.setColor(new Color(220, 220, 220));

                g.fillRect(j, i, 1, 1);
            }
        }
    }
}
