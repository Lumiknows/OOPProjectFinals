import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        //new LoginFrame();
        new Menu();
    }
}

class LoginFrame extends JFrame {
    private JPanel panel1;
    private JLabel usernameLabel, passwordLabel, displayBg;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private ImageIcon p1bg;

    LoginFrame(){
        super("User Login");

        setLayout(new BorderLayout());

        panel1 = new JPanel();

        panel1.setBackground(new Color(255, 153, 0));
        panel1.setPreferredSize(new Dimension(200, 100));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        try{
            p1bg = new ImageIcon("C:/Users/playb/OneDrive/Documents/PROJECT_OOP/Ebike/lib/misc/p1bg.png");
            displayBg = new JLabel(p1bg);
            displayBg.setPreferredSize(new Dimension(100,700));
            this.add(displayBg);
        } catch (Exception e) {
            System.out.println("Unable to Display Image!");
        }

        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        panel1.add(usernameLabel);
        panel1.add(usernameField);
        panel1.add(passwordLabel);
        panel1.add(passwordField);

        loginButton = new JButton("Log in");
        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("password")) {
                    JFrame Menu = new Menu();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
                }
            }
        });

        panel1.add(loginButton);

        this.add(panel1, BorderLayout.WEST);
        this.setSize(1200,620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class Menu extends JFrame implements ActionListener {
    private JComboBox<String> accessoryComboBox, partComboBox;
    private JButton searchButton, nextButton, prevButton;
    private JLabel partLabel, accessoryLabel, partImageLabel;
    private Map<String, String[]> partImageMap, accessoryImageMap;
    private JLabel specs;
    private Map<String, String[]> specsMap;
    private String[] currentImagePaths;
    private int currentIndex;

    Menu() {
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 100));
        leftPanel.setBackground(new Color(255, 153, 0));

        setLayout(new BorderLayout());

        partLabel = new JLabel("Select part: ");
        partLabel.setBounds(100, 30, 200, 30);

        accessoryLabel = new JLabel("Select accessory: ");
        accessoryLabel.setBounds(100, 90, 200, 30);

        String[] partOptions = {
                "Batteries", "Charger", "Tires", "Controllers", "Connectors",
                "Cycle Analysts", "DC-DC Converters", "Ebrakes", "Freewheels and Cassettes",
                "Lights", "Hub Motors", "Solar", "Spokes",
                "Throttles", "Torque Arms", "Wiring", "Rims"
        };

        String accessories[] = {
                "Helmet", "Locks", "Side Mirrors", "Bicycle Light", "Fenders", "Kickstands",
                "Phone mounts", "Speedometers", "Repair kits"     
        };

        specs = new JLabel();
        specs.setVerticalAlignment(JLabel.TOP);
        specs.setPreferredSize(new Dimension(200, 100));
        specs.setOpaque(true);
        specs.setBackground(new Color(255, 153, 0));
        specsMap = new HashMap<>();

        specsMap.put("Rims", new String[]{
            "Name: Rim 1", 
            "Diameter: 26 Inches", 
            "Material: Alloy", 
            "Color: Black"
        });

        partComboBox = new JComboBox<>(partOptions);
        partComboBox.setPrototypeDisplayValue("Freewheels and Cassettes");
        partComboBox.setBounds(50, 50, 90, 20); 

        accessoryComboBox = new JComboBox<>(accessories);
        accessoryComboBox.setPrototypeDisplayValue("Freewheels and Cassettes");
        accessoryComboBox.setBounds(100, 60, 200, 30);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(50, 20));
        searchButton.setBounds(320, 60, 80, 30);
        searchButton.setBorder(new LineBorder(Color.BLACK));
        searchButton.addActionListener(this);

        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(50, 20));
        nextButton.setBounds(420, 60, 80, 30);
        nextButton.setBorder(new LineBorder(Color.BLACK));
        nextButton.addActionListener(this);

        prevButton = new JButton("Previous");
        prevButton.setPreferredSize(new Dimension(60, 20));
        prevButton.setBounds(520, 60, 100, 30);
        prevButton.setBorder(new LineBorder(Color.BLACK));
        prevButton.addActionListener(this);

        partImageLabel = new JLabel();
        partImageLabel.setBounds(100, 150, 500, 500);

        partImageMap = new HashMap<>();
        accessoryImageMap = new HashMap<>();
        initializeImageMaps();

        leftPanel.add(partLabel);
        leftPanel.add(partComboBox);
        leftPanel.add(accessoryLabel);
        leftPanel.add(accessoryComboBox);
        leftPanel.add(searchButton);
        leftPanel.add(nextButton);
        leftPanel.add(prevButton);

        this.add(specs, BorderLayout.EAST);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(partImageLabel, BorderLayout.CENTER);
        this.setSize(1200, 620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JMenu menu = new JMenu("ABOUT US");
        JMenu submenu1 = new JMenu("MEMBERS");
        JMenu submenu2 = new JMenu("TEACHER");
        JMenuBar menubar = new JMenuBar();

        JMenuItem n1 = new JMenuItem("Batac");
        JMenuItem n2 = new JMenuItem("Ibona");
        JMenuItem n3 = new JMenuItem("Diaz");
        JMenuItem n4 = new JMenuItem("Daniel");
        JMenuItem n5 = new JMenuItem("Teopiz");
        JMenuItem n6 = new JMenuItem("Teogangco");
        JMenuItem n7 = new JMenuItem("Sy");
        JMenuItem n8 = new JMenuItem("Semontiza");

        JMenuItem t1 = new JMenuItem("Carl-san Kim");

        submenu1.add(n1);
        submenu1.add(n2);
        submenu1.add(n3);
        submenu1.add(n4);
        submenu1.add(n5);
        submenu1.add(n6);
        submenu1.add(n7);
        submenu1.add(n8);

        submenu2.add(t1);

        menu.add(submenu1);
        menu.add(submenu2);
        menubar.add(menu);
        setJMenuBar(menubar);
    }

    private void initializeImageMaps() {
        partImageMap.put("Rims", new String[]{
                "C:/Users/playb/OneDrive/Documents/PROJECT_OOP/Ebike/lib/parts/rims/rim1.jpg",
                "C:/Users/playb/OneDrive/Documents/PROJECT_OOP/Ebike/lib/parts/rims/rim2.jpg",
                "C:/Users/playb/OneDrive/Documents/PROJECT_OOP/Ebike/lib/parts/rims/rim3.jpg",
                "C:/Users/playb/OneDrive/Documents/PROJECT_OOP/Ebike/lib/parts/rims/rim4.jpg"
        });

        accessoryImageMap.put("Helmet", new String[]{
                "C:/Users/II/Downloads/Accessories/Helmet/helmet1.jpg",
                "C:/Users/II/Downloads/Accessories/Helmet/helmet2.jpg",
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String selectedPart = (String) partComboBox.getSelectedItem();
            displayPartImages(selectedPart);
        } else if (e.getSource() == nextButton) {
            showNextImage();
        } else if (e.getSource() == prevButton) {
            showPreviousImage();
        } else if (e.getSource() == accessoryComboBox) {
            String selectedAccessory = (String) accessoryComboBox.getSelectedItem();
            displayAccessoryImages(selectedAccessory);
        }
    }

    private void displayPartImages(String selectedPart) {
        currentImagePaths = partImageMap.get(selectedPart);

        if (currentImagePaths != null && currentImagePaths.length > 0) {
            currentIndex = 0;
            showImageAtIndex(selectedPart, currentIndex, 300, 300);
        }
    }

    private void displayAccessoryImages(String selectedAccessory) {
        currentImagePaths = accessoryImageMap.get(selectedAccessory);

        if (currentImagePaths != null && currentImagePaths.length > 0) {
            currentIndex = 0;
            showImageAtIndex(selectedAccessory, currentIndex, 300, 300);
        }
    }

    private void showNextImage() {
        if (currentImagePaths != null && currentIndex < currentImagePaths.length - 1) {
            currentIndex++;
            System.out.println("Next Image: " + currentImagePaths[currentIndex]);
            showImageAtIndex(currentIndex, 300, 300);
        }
    }

    private void showPreviousImage() {
        if (currentImagePaths != null && currentIndex > 0) {
            currentIndex--;
            System.out.println("Previous Image: " + currentImagePaths[currentIndex]);
            showImageAtIndex(currentIndex, 300, 300);
        }
    }

    private void showImageAtIndex(String selectedPart, int index, int maxWidth, int maxHeight) {
        try {
            if (currentImagePaths != null && index >= 0 && index < currentImagePaths.length) {
                System.out.println("Current Index: " + index);
                ImageIcon originalIcon = new ImageIcon(currentImagePaths[index]);
                Image originalImage = originalIcon.getImage();

                Image scaledImage = originalImage.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);

                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                partImageLabel.setIcon(scaledIcon);

                System.out.println("Setting Image for Index: " + index);

                displaySpecs(selectedPart, index);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void displaySpecs(String selectedPart, int index) {
        String[] partSpecs = specsMap.get(selectedPart);

        if (partSpecs != null && index >= 0 && index < partSpecs.length) {
            StringBuilder specsText = new StringBuilder();

            for (String spec : partSpecs) {
                specsText.append(spec).append("<br>");
            }

            specs.setText("<html>" + specsText.toString() + "</html>");
        }
    } 
}

