import gui.Frame;
import gui.Panel;

public class Main {

    // Constants
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    // Alternatively -
    // private static final int HEIGHT = WIDTH*9/16;


    public static void main(String[] args) {
        Frame frame = new Frame(WIDTH, HEIGHT);
        Panel panel = new Panel(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }
}
