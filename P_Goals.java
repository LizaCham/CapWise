package src;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P_Goals extends JPanel {

    private final Color BACKGROUND = new Color(248, 249, 250);

    public P_Goals() {

        setBackground(BACKGROUND);
        JLabel title = new JLabel("Goals");
        add(title);
    }

}