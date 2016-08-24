package GrainBoundarySimulation;

import java.awt.*;

/**
 * Created by yulia on 27.07.16.
 * This is a class that describes precipitates
 */
public class Particle {
    private int x;
    private int y;
    private int z;
    private int radius;
    private int stressRadius;

    // Constructor
    public Particle(int x, int y, int z, int radius) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.stressRadius = radius * 3 / 2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getRadius() {
        return radius;
    }

    // Draw a particle
    public void draw(Canvas canvas)
    {

        // Stress field
        for(int i = -stressRadius - radius; i < stressRadius + radius; i++)
            for (int j = -stressRadius - radius; j < stressRadius + radius; j++)
                for (int k = -stressRadius - radius; k < stressRadius + radius; k++)
                {
                    int xPosition = x + i;
                    int yPosition = y + j;
                    int zPosition = z + k;

                    if (zPosition == 0)
                    {
                        int distanceSquare = i * i + j * j + k * k;
                        int distance = (int) Math.ceil(Math.sqrt(distanceSquare)) - radius;

                        if (distanceSquare < (radius + stressRadius) * (radius + stressRadius) && distanceSquare >= radius * radius)
                        {
                            char c = (char) (distance * 5 / stressRadius + '0');
                            if (!Character.isDigit(c))
                                c = '0';

                            if (xPosition >= 0 && xPosition < canvas.getWidth() && yPosition >= 0 && yPosition < canvas.getHeight())
                                canvas.setPoint(xPosition, yPosition, c);
                        }

                        else if(distanceSquare < radius * radius)
                        {
                            if (xPosition >= 0 && xPosition < canvas.getWidth() && yPosition >= 0 && yPosition < canvas.getHeight())
                                canvas.setPoint(xPosition, yPosition, 'X');
                        }
                    }
                }
    }
}
