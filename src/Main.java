import gui.Frame;
import gui.Panel;

public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();
        frame.add(panel);
        frame.setVisible(true);
    }
}
