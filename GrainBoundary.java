import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yulia on 27.07.16.
 */
public class GrainBoundary {
    private int width;
    private int height;
    private int depth; // an area around GB
    private int numberOfParticles;
    private ArrayList<Particle> particles = new ArrayList<>();

    public static GrainBoundary grainBoundary;

    public GrainBoundary(int width, int height, int depth, int numberOfParticles) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.numberOfParticles = numberOfParticles;
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
            int radius = 5;

            particles.add(new Particle(x, y, z, radius));
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
        canvas.print();
    }

    public static void main(String[] args)
    {
        // GB width, height, depth and a number of particles
        grainBoundary = new GrainBoundary(100, 20, 10, 20);
        grainBoundary.run();
    }
}
