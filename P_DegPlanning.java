package src;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class P_DegPlanning extends JPanel {

    private final Color BACKGROUND = new Color(248,249,250);

    private JPanel schoolPanel;
    private JButton findSchoolsButton;

    public P_DegPlanning(CollegeData collegeData){

        setBackground(BACKGROUND);
        setLayout(new BorderLayout());

        // Title

        JLabel title = new JLabel("Degree Planning");
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(title, BorderLayout.NORTH);

        // Main Content

        JPanel mainContent = new JPanel();
        mainContent.setBackground(BACKGROUND);
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));

        // Dashboard Cards

        JPanel cards = new JPanel(new GridLayout(2,2,20,20));
        cards.setMaximumSize(new Dimension(Integer.MAX_VALUE,180));

        cards.add(createCard("Degree", "Computer Science"));
        cards.add(createCard("Credits", "82 / 120"));
        cards.add(createCard("Graduation", "Spring 2028"));
        cards.add(createCard("Remaining Cost", "$32,000"));
        mainContent.add(cards);

        mainContent.add(Box.createVerticalStrut(25));

        // Find Schools Button

        findSchoolsButton = new JButton("Find Schools ▼");
        findSchoolsButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainContent.add(findSchoolsButton);
        mainContent.add(Box.createVerticalStrut(10));

        // School Table Panel

        schoolPanel = createSchoolTable(collegeData);
        schoolPanel.setVisible(false);
        mainContent.add(schoolPanel);

        // Button Action

        findSchoolsButton.addActionListener(e -> {

            boolean visible = schoolPanel.isVisible();

            schoolPanel.setVisible(!visible);

            if(visible){

                findSchoolsButton.setText("Find Schools ▼");
            } else{

                findSchoolsButton.setText("Hide Schools ▲");
            }

            revalidate();
            repaint();
        });

        add(mainContent, BorderLayout.CENTER);
    }

    private JPanel createSchoolTable(CollegeData collegeData){

        JPanel panel = new JPanel(new BorderLayout());

        JLabel tableTitle = new JLabel("Available Schools");
        tableTitle.setFont(new Font("SansSerif", Font.BOLD,22));
        panel.add(tableTitle, BorderLayout.NORTH);

        String[] columns = {
            "College",
            "City",
            "State",
            "Tuition",
            "SAT",
            "ACT"
        };

        DefaultTableModel model = new DefaultTableModel(columns,0);

        ArrayList<College> schools = collegeData.getColleges();

        for(College school : schools){

            model.addRow(new Object[]{
                school.getName(),
                school.getCity(),
                school.getState(),
                school.getTuition(),
                school.getSAT(),
                school.getACT()
            });
        }

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(900,350));
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createCard(String heading, String value){

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(heading);
        title.setFont(new Font("SansSerif", Font.BOLD,18));

        JLabel info = new JLabel(value);
        info.setFont(new Font("SansSerif", Font.PLAIN,24));

        card.add(title);
        card.add(Box.createVerticalStrut(10));
        card.add(info);

        return card;
    }
}