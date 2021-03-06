package GrainBoundarySimulation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yulia on 27.07.16.
 */

public class GrainBoundary {
    private int width;
    private int height;
    private int depth; // an area around GB
    private int maxRadius;
    private int numberOfParticles;
    private ArrayList<Particle> particles = new ArrayList<>();

    public static GrainBoundary grainBoundary;

    public GrainBoundary(int width, int height, int depth, int numberOfParticles, int maxRadius) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.numberOfParticles = numberOfParticles;
        this.maxRadius = maxRadius;
    }

    public int getDepth() {
        return depth;
    }

    public void createParticles()
    {

        Random random = new Random();

        for(int i = 0; i < numberOfParticles; i++)
        {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int z = random.nextInt(depth);
            boolean isClose = false;

            if(particles.size() == 0)
                particles.add(new Particle(x, y, z, maxRadius));
            else
            {
                for (int j = 0; j < particles.size(); j++) {
                    int xDifference = x - particles.get(j).getX();
                    int yDifference = y - particles.get(j).getY();
                    int zDifference = z - particles.get(j).getZ();

                    int distance = (int)Math.round(Math.sqrt(xDifference*xDifference + yDifference*yDifference + zDifference*zDifference));
                    if(distance < 2 * maxRadius * 5 / 2)
                    {
                        isClose = true;
                        break;
                    }
                }

                if (isClose == true)
                {
                    i--;
                    continue;
                }
                else
                {
                    particles.add(new Particle(x, y, z, maxRadius));
                }
            }

        }
    }

    public void draw(Canvas canvas)
    {
        // draw background
        drawBasis(canvas);

        // draw particles
        for(Particle particle: particles)
            particle.draw(canvas);
    }

    // Простынка
    public void drawBasis(Canvas canvas)
    {
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                canvas.setPoint(i, j, '.');
            }
        }
    }

    public void run()
    {
        createParticles();

        Canvas canvas = new Canvas(width, height);
        draw(canvas);
        //canvas.print();

        GUI gui = new GUI(canvas);
    }

    public static void main(String[] args)
    {
        // GB width, height, depth, a number of particles and a radius
        grainBoundary = new GrainBoundary(1000, 500, 500, 20, 50);
        grainBoundary.run();
    }
}
