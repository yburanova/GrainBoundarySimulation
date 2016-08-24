package GrainBoundarySimulation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yulia on 17.08.16.
 */
public class GUI extends JFrame {
    public final int WIDTH;
    public final int HEIGHT;

    private JPanel jContentPane = null;
    private Canvas canvas;

    public GUI(Canvas canvas) throws HeadlessException {
        super();

        this.canvas = canvas;
        WIDTH = canvas.getWidth() + 50;
        HEIGHT = canvas.getHeight() + 50;

        initialize();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initialize()
    {
        this.setSize(WIDTH, HEIGHT);
        this.setContentPane(getJContentPane());
        this.setTitle("Grain Boundary");
    }

    //adds all components to the main Panel
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BoxLayout(jContentPane, BoxLayout.X_AXIS));
            jContentPane.add(new Component());
            jContentPane.updateUI();
        }
        return jContentPane;
    }



    class Component extends JPanel
    {

        public Component() {
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            //setMaximumSize(new Dimension(WIDTH + 150, HEIGHT + 150));
        }

        public void paint(Graphics g)
        {
            super.paint(g);
            Graphics2D g2 = (Graphics2D)g;

            canvas.draw(g2);
        }
    }


}
