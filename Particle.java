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
        this.stressRadius = 5;
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
        for(int i = -stressRadius; i < stressRadius; i++)
        {
            for(int j = -stressRadius; j < stressRadius; j++)
            {
                for(int k = -stressRadius; k < stressRadius; k++)
                {
                    int xPosition = x + i;
                    int yPosition = y + j;
                    int zPosition = z + k;

                    int stressRadiusCurrent = (int)Math.round(Math.sqrt(stressRadius*stressRadius - z*z));

                    if((i*i + j*j) < (stressRadiusCurrent*stressRadiusCurrent))
                    {
                        int distance = (int)Math.round(Math.sqrt(i*i + j*j));
                        char c = (char)(distance + '0');

                        if (xPosition >= 0 && xPosition < canvas.getWidth() && yPosition >= 0 && yPosition < canvas.getHeight())
                            canvas.setPoint(xPosition, yPosition, c);
                    }


                }

            }
        }

        // if particle is at z=0
        if(z == 0)
            canvas.setPoint(x, y, 'X');
    }
}
