package src;
import java.awt.*;
import javax.swing.*;

public class CapWiseGUI extends JFrame {
    // ================= Colors ===================

    private final Color SIDEBAR = new Color(0xDE, 0x59, 0x6A);
    private final Color BACKGROUND = new Color(248, 249, 250);
    private final Color HEADER = Color.WHITE;

    // ================= Layout ===================

    private CardLayout cardLayout;
    private JPanel cards;
    private JTextField search;
    private CollegeData collegeData;

    public CapWiseGUI() {

        setUpFrame();
        setUpUI();
        setVisible(true);
    }

    // ================= Frame ===================

    private void setUpFrame() {

        setTitle("CapWise");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ================= UI ===================

    private void setUpUI() {

        setLayout(new BorderLayout());
        JPanel sidebar = createSidebar();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel header = createHeader();
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        collegeData = new CollegeData();

        cards.add(new P_MyDash(), "My Dashboard");
        cards.add(new P_LearningHub(), "Learning Hub");
        cards.add(new P_Goals(), "Interests & Goals");
        cards.add(new P_DegPlanning(collegeData), "Degree Planning");
        cards.add(new P_CareerPlan(), "Career Planning");
        cards.add(new P_ROIcalculator(), "ROI Calculator");
        cards.add(new P_MyAcct(), "My Account");
        
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(cards, BorderLayout.CENTER);

        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    // ================= Sidebar ===================

    private JPanel createSidebar() {

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setBackground(SIDEBAR);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("CapWise");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("SansSerif", Font.BOLD, 28));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        sidebar.add(Box.createVerticalStrut(30));
        sidebar.add(logo);
        sidebar.add(Box.createVerticalStrut(40));

        sidebar.add(createMenuButton("My Dashboard"));
        sidebar.add(createMenuButton("Learning Hub"));
        sidebar.add(createMenuButton("Interests & Goals"));
        sidebar.add(createMenuButton("Degree Planning"));
        sidebar.add(createMenuButton("Career Planning"));
        sidebar.add(createMenuButton("ROI Calculator"));
        
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(createMenuButton("My Account"));
        sidebar.add(createMenuButton("Logout"));
        sidebar.add(Box.createVerticalStrut(20));

        return sidebar;

    }

    // ================= Header ===================

    private JPanel createHeader() {

        JPanel header = new JPanel(new BorderLayout());
        header.setPreferredSize(new Dimension(0, 70));
        header.setBackground(HEADER);
        header.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));
       
        JLabel title = new JLabel("Welcome!");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        
        search = new JTextField();
        search.setPreferredSize(new Dimension(250,35));
        search.setVisible(false);

        JButton profile = new JButton("Profile");
        header.add(title, BorderLayout.WEST);
        header.add(search, BorderLayout.CENTER);
        header.add(profile, BorderLayout.EAST);
        return header;

    }

    // ================= Sidebar Buttons ===================

    private JButton createMenuButton(String text) {

        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(220,45));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBackground(SIDEBAR);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> {

            if(!text.equals("Logout")) {

                cardLayout.show(cards, text);
                if(text.equals("Learning Hub")){
                    search.setVisible(true);
                } else {
                    search.setVisible(false);
                }
            }
        
        });

        return button;
    }

}