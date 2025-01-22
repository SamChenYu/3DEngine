package scene;

import math.Point3D;
import math.Ray;
import math.Vector3D;

import java.util.Random;

public class Tracer {

    public final int WIDTH;
    public final int HEIGHT;

    public final Random random;

    public final World world;


    private final int renderX;
    private final int renderY;
    private final int renderZ;
    private final int samples = 8; // for anti-aliasing

    public Tracer(int width, int height, World world) {
        WIDTH = width;
        HEIGHT = height;
        random = new Random();
        this.world = world;

        renderX = (int) (0.4*(WIDTH/2+.5));
        renderY = (int) (0.4*(HEIGHT/2+.5));
        renderZ = 100;
    }



    public int trace(int x, int y) {


        math.Color color = new math.Color(0.0F, 0.0F, 0.0F);
        boolean hit = false;
        for (int row = 0; row < samples; row++) {
            for (int col = 0; col < samples; col++) {

                int pointX = (int) (x - WIDTH / 2 + (col + 0.5) / samples);
                int pointY = (int) (y - HEIGHT / 2 + (row + 0.5) / samples);

                //orthographic projection
                Ray ray = new Ray(
                        new Point3D(world.viewPlane.size * pointX, world.viewPlane.size * pointY, renderZ),
                        new Vector3D(0.0, 0.0, -1.0)
                );

                double min = Double.MAX_VALUE; // kind of like a z buffer
                math.Color tempColor = world.background;

                for(int i=0; i<world.objects.size(); i++) {
                    double temp = world.objects.get(i).hit(ray);
                    if( temp != 0.0 && temp < min) {
                        tempColor = world.objects.get(i).color;
                        min = temp;
                        hit = true;
                    }
                } // for world objects
                color.add(tempColor);


            } // for col
        } // for row
        color.divide(samples*samples);
        if(hit) return color.toInteger();
        else return world.background.toInteger();


        /* Jitter anti-aliasing
            Random random = new Random();
            Point2D point = new Point2D();
            point.x = x-WIDTH/2+(col+random.nextFloat())/samples;
            point.y = y-HEIGHT/2+(row+random.nextFloat())/samples;
         */

















        /* No anti-aliasing

        double min = Double.MAX_VALUE; // kind of like a z buffer

        math.Color color = new math.Color(0.0F, 0.0F, 0.0F);
        Ray ray = new Ray(
                new Point3D(x-WIDTH/2, y-HEIGHT/2, renderZ),
                new Vector3D(0.0, 0.0, -1.0)
        );

        for(int i=0; i<world.objects.size(); i++) {
            if( world.objects.get(i).hit(ray) != 0.0 && world.objects.get(i).hit(ray) < min) {
                color = world.objects.get(i).color;
                min = world.objects.get(i).hit(ray);
            }
        }
        return color.toInteger();
        */









    } // End trace
}
