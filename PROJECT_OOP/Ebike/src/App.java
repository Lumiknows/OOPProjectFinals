import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        new LoginFrame();
    }
}

class LoginFrame extends JFrame {
    private JPanel panel1;
    private JLabel usernameLabel, passwordLabel, logoLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    LoginFrame(){
        super("User Login");

        setLayout(new BorderLayout());

        panel1 = new JPanel();

        panel1.setBackground(Color.gray);
        panel1.setPreferredSize(new Dimension(200, 100));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        ImageIcon logo = new ImageIcon("logo.png");
        logoLabel = new JLabel(logo);
        panel1.add(logoLabel);

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
                    JFrame mainFrame = new Menu();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
                }
            }
        });

        panel1.add(loginButton);

        this.add(panel1, BorderLayout.WEST);
        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class Menu extends JFrame implements ActionListener {
    private JComboBox<String> accessoryComboBox, partComboBox; 
    private JButton searchButton, nextButton, prevButton;
    private JLabel partLabel, accessoryLabel, partImageLabel;
    private Map<String, String[]> partImageMap, accessoryImageMap;
    private String[] currentImagePaths;
    private int currentIndex;

    Menu() {

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200,100));
        //leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.gray);

        setLayout(new BorderLayout());

        partLabel = new JLabel("Select part: ");
        partLabel.setBounds(100, 30, 200, 30);

        accessoryLabel = new JLabel("Select accessory: ");
        accessoryLabel.setBounds(100, 90, 200, 30);

        //   parts array
        String[] partOptions = {
                "Batteries", "Charger", "Tires", "Controllers", "Connectors",
                "Cycle Analysts", "DC-DC Converters", "Ebrakes", "Freewheels and Cassettes",
                "Lights", "Hub Motors", "Solar", "Spokes",
                "Throttles", "Torque Arms", "Wiring", "Rims"
        };

        //  accessories array
        String accessories[] = {
                "Helmet", "Locks", "Side Mirrors", "Bicycle Light", "Fenders", "Kickstands",
                "Phone mounts", "Speedometers", "Repair kits"     
        };

        partComboBox = new JComboBox<>(partOptions);
        partComboBox.setPrototypeDisplayValue("Freewheels and Cassettes");
        partComboBox.setBounds(50, 50,90,20); 

        accessoryComboBox = new JComboBox<>(accessories);
        accessoryComboBox.setPrototypeDisplayValue("Freewheels and Cassettes");
        accessoryComboBox.setBounds(100, 60, 200, 30);

        searchButton = new JButton("Search");
        searchButton.setBounds(320, 60, 80, 30);
        searchButton.addActionListener(this);

        nextButton = new JButton("Next");
        nextButton.setBounds(420, 60, 80, 30);
        nextButton.addActionListener(this);

        prevButton = new JButton("Previous");
        prevButton.setBounds(520, 60, 100, 30);
        prevButton.addActionListener(this);

        JToolBar toolbar = new JToolBar();
        toolbar.add(searchButton);
        toolbar.add(nextButton);
        toolbar.add(prevButton);

        partImageLabel = new JLabel();
        partImageLabel.setBounds(100, 150, 500, 500);

        partImageMap = new HashMap<>();
        accessoryImageMap = new HashMap<>();
        initializeImageMaps();

        leftPanel.add(partLabel);
        leftPanel.add(partComboBox);
        leftPanel.add(accessoryLabel);
        leftPanel.add(accessoryComboBox);
        leftPanel.add(toolbar);
        //leftPanel.add(searchButton);
        //leftPanel.add(nextButton);
        //leftPanel.add(prevButton);

        this.add(leftPanel, BorderLayout.WEST);
        this.add(partImageLabel, BorderLayout.CENTER);
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Dashboard menu
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
            showImageAtIndex(currentIndex, 300, 300);
        }
    }

    private void displayAccessoryImages(String selectedAccessory) {
        currentImagePaths = accessoryImageMap.get(selectedAccessory);

        if (currentImagePaths != null && currentImagePaths.length > 0) {
            currentIndex = 0;
            showImageAtIndex(currentIndex, 300, 300);
        }
    }

    private void showNextImage() {
        if (currentImagePaths != null && currentIndex < currentImagePaths.length - 1) {
            currentIndex++;
            System.out.println("Next Image: " + currentImagePaths[currentIndex]); // Just for Debugging
            showImageAtIndex(currentIndex, 300, 300);
        }
    }

    private void showPreviousImage() {
        if (currentImagePaths != null && currentIndex > 0) {
            currentIndex--;
            System.out.println("Previous Image: " + currentImagePaths[currentIndex]);  // Just for Debugging
            showImageAtIndex(currentIndex, 300, 300);
        }
    }


    private void showImageAtIndex(int index, int maxWidth, int maxHeight) {
        try {
            if (currentImagePaths != null && index >= 0 && index < currentImagePaths.length) {
                ImageIcon originalIcon = new ImageIcon(currentImagePaths[index]);
                Image originalImage = originalIcon.getImage();

                // Scale the image to fit within the specified bounds
                Image scaledImage = originalImage.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);

                // Create a new ImageIcon with the scaled image
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                partImageLabel.setIcon(scaledIcon);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
  
}

