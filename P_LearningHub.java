package src;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P_LearningHub extends JPanel {

    private final Color BACKGROUND = new Color(248, 249, 250);

    public P_LearningHub() {

        setBackground(BACKGROUND);
        JLabel title = new JLabel("Learning Hub");
        add(title);
    }

}