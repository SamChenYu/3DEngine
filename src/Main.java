import gui.Frame;
import gui.Panel;
import scene.World;

public class Main {

    // Constants
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    // Alternatively -
    // private static final int HEIGHT = WIDTH*9/16;

    public static void main(String[] args) {
        World world = new World(WIDTH, HEIGHT, 0.55);
        Frame frame = new Frame(WIDTH, HEIGHT);
        Panel panel = new Panel(WIDTH, HEIGHT, world);
        frame.add(panel);
        frame.setVisible(true);
    }
}
