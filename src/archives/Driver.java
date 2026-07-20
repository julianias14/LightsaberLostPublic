package archives;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class Driver {
    private JFrame frame;
    private JPanel panel;

    private JScrollPane scroller;

    private JPanel buttonPanel;
    private JPanel imagePanel;

    private JPanel hintPanel;

    private String netID;

    private JButton instructions;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    private JPanel topPanel;
    private JPanel addedButtons;

    private JTextArea hint;

    private String color;
    private String hilt;

    private ArrayList<String> colors;
    private ArrayList<String> hilts;

    private final String[] allColors;
    private final String[] allHilts;

    private ArrayList<Jedi> jediList;

    private String lastLoadedFile;

    private LightsaberLost lightsaberLost;
    private JComboBox<String> chosenColor3;

    private boolean buttonOneClicked;
    private boolean buttonTwoClicked;
    private boolean buttonThreeClicked;
    private boolean buttonFourClicked;
    
    public Driver() {
        frame = new JFrame();
        frame.setTitle("Lightsaber Lost");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(750,700);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        scroller = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        buttonPanel = new JPanel();

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(buttonPanel);

        addedButtons = new JPanel();
        topPanel.add(addedButtons);

        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(0, 7));

        jediList = new ArrayList<Jedi>();
        
        colors = new ArrayList<String>();
        hilts = new ArrayList<String>();

        allColors = new String[]{"blue","green","yellow","purple","white"};
        allHilts = new String[]{"alloy","aluminum","beskar","brylark","cortosis","durasteel","electrum","phrik","stone","wroshyr"};

        lastLoadedFile = "";

        JPanel imageContainer = new JPanel();
        imageContainer.setLayout(new BorderLayout());
        imageContainer.add(imagePanel, BorderLayout.NORTH);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(imageContainer, BorderLayout.CENTER);

        frame.add(scroller, BorderLayout.CENTER);

        lightsaberLost = new LightsaberLost();

        netIDPanel();
        setButtons();
        instructions();
        button1();
        button2();
        button3();
        button4();
        button5();

        frame.setVisible(true);
    }

    private void refresh(JPanel panelName) {
        panelName.revalidate();
        panelName.repaint();
    }

    private void refresh(JFrame frameName) {
        frameName.revalidate();
        frameName.repaint();
    }

    private void netIDPanel() {
        netID = JOptionPane.showInputDialog("Please enter your NetID to start the assignment.");
        if(netID == null || netID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please reopen the driver and enter your netID.");
            System.exit(0);
        }
        netID = netID.toLowerCase().trim();
        StdRandom.setSeed((long)(netID.toLowerCase().trim().hashCode() + 1));
    }

    private void setButtons() {
        instructions = new JButton("instructions");
        button1 = new JButton("rebuildArchive");
        button2 = new JButton("sortByColor");
        button3 = new JButton("extractColor");
        button4 = new JButton("sortByHilt");
        button5 = new JButton("findOwner");

        buttonPanel.add(instructions);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);

        buttonOneClicked = false;
        buttonTwoClicked = false;
        buttonThreeClicked = false;
        buttonFourClicked = false;
    }

    private void displayHints() {
        if(jediList.size() <=0){
            JOptionPane.showMessageDialog(null, "Jedi ArrayList is empty", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(hintPanel!=null) {
            frame.remove(hintPanel);
        }
        
        hintPanel = new JPanel();

        colors = new ArrayList<>();
        hilts = new ArrayList<>();

        for(int i = 0; i<jediList.size(); i++) {
            if(!colors.contains(jediList.get(i).getLightsaberColor())) {
                colors.add(jediList.get(i).getLightsaberColor());
            }
            if(!hilts.contains(jediList.get(i).getLightsaberHilt())) {
                hilts.add(jediList.get(i).getLightsaberHilt());
            }
        }
        colors.sort(null);
        hilts.sort(null);

        StdRandom.setSeed((long)(netID.toLowerCase().trim().hashCode() + 1));
        int randomIndex = StdRandom.uniform(jediList.size());;

        color = jediList.get(randomIndex).getLightsaberColor();
        hilt = jediList.get(randomIndex).getLightsaberHilt();

        hint = new JTextArea("You've found a " + color + " lightsaber with a " + hilt + " hilt material.");
        hint.setBackground(new Color(250,240,230));
        hint.setFont(new Font("Monospaced", Font.PLAIN, 18));
        hintPanel.add(hint);
        hintPanel.setBackground(new Color(250,240,230));
        frame.add(hintPanel, BorderLayout.SOUTH);
        refresh(frame);
    }

    private JPanel displayLightsaberImages(Jedi jedi) {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("assets/lightsabers/" + jedi.getImage());
        Image newImage = icon.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        imageLabel.setIcon(new ImageIcon(newImage));

        JLabel hiltLabel = new JLabel("Hilt: " + jedi.getLightsaberHilt());

        displayPanel.add(imageLabel);
        displayPanel.add(hiltLabel);

        return displayPanel;
    }

    private JPanel displayJediImage(Jedi jedi) {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        String path = jedi.getName().toString();
        path = path.replace(" ","") + ".PNG";
        jedi.setJediImage(path);
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("assets/jedi/" + jedi.getJediImage());
        Image newImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        imageLabel.setIcon(new ImageIcon(newImage));

        displayPanel.add(imageLabel);

        return displayPanel;
    }

    private void instructions() {
        instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
        null,
                        "How to use this driver:\n1. Click on each method from left to right every time you want to test a method. Previous methods must be clicked for further ones to work as some buttons call earlier methods!\n2. Certain algorithms will have their own buttons appear when you click on the method button as you will need to select what you're searching for (e.g. input files).\nWhenever a dropdown appears, make your selection and select the corresponding button to run the method.\n3. Not all input files may contain the owner of your lost lightsaber.",
                        "Instructions",
                        JOptionPane.INFORMATION_MESSAGE
                    );
            }
        });
    }

    private void button1() {
        String[] files = {"archives.csv","archives2.csv","archives3.csv","archives4.csv","archives5.csv","archives6.csv", "archives7.csv"};

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> chosenFile = new JComboBox<>();
                for(int i = 0; i<files.length; i++) {
                    chosenFile.addItem(files[i]);
                }

                addedButtons.removeAll();
                addedButtons.add(chosenFile);
                
                JButton load = new JButton("Load");
                addedButtons.add(load);

                refresh(addedButtons);

                load.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent a) {
                        jediList = new ArrayList<Jedi>();
                        String file = chosenFile.getSelectedItem().toString();
                        if(file.equals(lastLoadedFile)) {
                            return;
                        }
                        lastLoadedFile = file;
                        lightsaberLost.rebuildArchive(file);
                        
                        imagePanel.removeAll();
                        imagePanel.setLayout(new GridLayout(0, 7));
                        for(int i = 0; i<lightsaberLost.getArchives().size(); i++) {
                            Jedi jedi = lightsaberLost.getArchives().get(i);
                            imagePanel.add(displayLightsaberImages(jedi));
                            jediList.add(jedi);
                        }
                        displayHints();
                        
                        refresh(imagePanel);
                        buttonOneClicked = true;
                        buttonTwoClicked = false;
                        buttonThreeClicked = false;
                        buttonFourClicked = false;
                    }
                });
            }
        });
    }

    private void button2() {
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!buttonOneClicked) {
                    buttonOneWarning();
                    return;
                }
                lightsaberLost.sortByColor();
                addedButtons.removeAll();
                refresh(addedButtons);
                
                imagePanel.removeAll();
                imagePanel.setLayout(new GridLayout(0, 7));

                for(int i = 0; i<lightsaberLost.getArchives().size(); i++) {
                    Jedi jedi = lightsaberLost.getArchives().get(i);
                    imagePanel.add(displayLightsaberImages(jedi));
                }
                refresh(imagePanel);
                buttonTwoClicked = true;
            }
        });
    }

    private Jedi[] toSortedHiltArr() {
        int start = lightsaberLost.extractColor(chosenColor3.getSelectedItem().toString()).getStartIndex();
        int fin = lightsaberLost.extractColor(chosenColor3.getSelectedItem().toString()).getLastIndex();

        Jedi[] arr = new Jedi[fin-start+1];
        int x = 0;

        for(int i = start; i<=fin; i++) {
            arr[x] = lightsaberLost.getArchives().get(i);
            x++;
        }
        lightsaberLost.sortByHilt(arr);

        return arr;
    }

    private void button3() {
        chosenColor3 = new JComboBox<>();
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!buttonOneClicked) {
                    buttonOneWarning();
                    return;
                }
                if(!buttonTwoClicked) {
                    buttonTwoWarning();
                    return;
                }
                chosenColor3.removeAllItems();
                for(int i = 0; i<allColors.length; i++) {
                    chosenColor3.addItem(allColors[i]);
                }
                lightsaberLost.sortByColor();

                addedButtons.removeAll();
                addedButtons.add(chosenColor3);

                JButton search3 = new JButton("Search");
                addedButtons.add(search3);

                refresh(addedButtons);
                imagePanel.removeAll();
                imagePanel.setLayout(new GridLayout(0, 7));

                for(int i = 0; i<lightsaberLost.getArchives().size(); i++) {
                    Jedi jedi = lightsaberLost.getArchives().get(i);
                    imagePanel.add(displayLightsaberImages(jedi));
                }
                refresh(imagePanel);

                search3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent a) {
                        imagePanel.removeAll();
                        imagePanel.setLayout(new GridLayout(0, 7));

                        if(lightsaberLost.extractColor(chosenColor3.getSelectedItem().toString())==null) {
                            JOptionPane.showMessageDialog(
            null,
                            "extractColor() returned null.",
                            "extractColor() notice",
                            JOptionPane.WARNING_MESSAGE
                        );
                        return;
                        }
                        
                        int start = lightsaberLost.extractColor(chosenColor3.getSelectedItem().toString()).getStartIndex();
                        int fin = lightsaberLost.extractColor(chosenColor3.getSelectedItem().toString()).getLastIndex();

                        for(int i = start; i<=fin; i++) {
                            Jedi jedi = lightsaberLost.getArchives().get(i);
                            imagePanel.add(displayLightsaberImages(jedi));
                        }
                        refresh(imagePanel);
                        buttonThreeClicked = true;
                    }
                });
            }
        });
    }

    private void button4() {
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!buttonOneClicked) {
                    buttonOneWarning();
                    return;
                }
                if(!buttonTwoClicked) {
                    buttonTwoWarning();
                    return;
                }
                if(!buttonThreeClicked) {
                    buttonThreeWarning();
                    return;
                }
                lightsaberLost.sortByColor();

                addedButtons.removeAll();
                refresh(addedButtons);

                Jedi[] jediArr = toSortedHiltArr();
                
                imagePanel.removeAll();
                imagePanel.setLayout(new GridLayout(0, 7));

                for(int j = 0; j<jediArr.length; j++) {
                    Jedi jedi = jediArr[j];
                    imagePanel.add(displayLightsaberImages(jedi));
                }
                refresh(imagePanel);
                buttonFourClicked = true;
            }
        });
    }

    private void button5() {
        JComboBox<String> chosenHilt5 = new JComboBox<>();

        JButton search5 = new JButton("Search");

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!buttonOneClicked) {
                    buttonOneWarning();
                    return;
                }
                if(!buttonTwoClicked) {
                    buttonTwoWarning();
                    return;
                }
                if(!buttonThreeClicked) {
                    buttonThreeWarning();
                    return;
                }
                if(!buttonFourClicked) {
                    buttonFourWarning();
                    return;
                }

                chosenHilt5.removeAllItems();
                for(int i = 0; i<allHilts.length; i++) {
                    chosenHilt5.addItem(allHilts[i]);
                }

                lightsaberLost.sortByColor();
                
                addedButtons.removeAll();
                addedButtons.add(chosenHilt5);

                addedButtons.add(search5);

                refresh(addedButtons);

                Jedi[] jediArr = toSortedHiltArr();
                
                imagePanel.removeAll();imagePanel.removeAll();
                imagePanel.setLayout(new GridLayout(0, 7));

                for(int j = 0; j<jediArr.length; j++) {
                    Jedi jedi = jediArr[j];
                    imagePanel.add(displayLightsaberImages(jedi));
                }
                refresh(imagePanel);
            }
        });

        search5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                Jedi[] jediArr = toSortedHiltArr();
                
                Jedi owner = lightsaberLost.findOwner(jediArr, chosenHilt5.getSelectedItem().toString());
                
                imagePanel.removeAll();
                imagePanel.setLayout(new FlowLayout());

                if(owner==null) {
                    JLabel error = new JLabel("No Jedi found!");
                    JPanel errorPanel = new JPanel();
                    errorPanel.add(error);
                    imagePanel.add(errorPanel);
                } else {
                    JPanel textPanel = new JPanel();
                    textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
                    
                    if(owner.getLightsaberColor().equals(color) && owner.getLightsaberHilt().equals(hilt)) {
                        textPanel.add(new JLabel("Owner found!"));
                    }
                    textPanel.add(new JLabel("This lightsaber belongs to " + owner.getName() + ".\n"));
                    textPanel.add(new JLabel("Age: " + owner.getAge()+"\n"));
                    textPanel.add(new JLabel("Homeworld: " + owner.getHomeworld()));

                    JPanel displayPanel = new JPanel(new BorderLayout());
                    displayPanel.add(displayJediImage(owner), BorderLayout.WEST);
                    displayPanel.add(textPanel, BorderLayout.CENTER);

                    imagePanel.add(displayPanel);
                }
                refresh(imagePanel);
                scroller.revalidate();
                scroller.repaint();
                }
            });
        }

    private void buttonOneWarning() {
        if(!buttonOneClicked) {
            JOptionPane.showMessageDialog(
null,
                "Please click 'rebuildArchive' first, select an input file, and load it before using this button.",
                "Buttons Error",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
    }

    private void buttonTwoWarning() {
        if(!buttonTwoClicked) {
            JOptionPane.showMessageDialog(
null,
                "Please click 'sortByColor' first before using this button.",
                "Buttons Error",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
    }

    private void buttonThreeWarning() {
        if(!buttonThreeClicked) {
            JOptionPane.showMessageDialog(
null,
                "Please click 'extractColor' first, select a color, and load it before using this button.",
                "Buttons Error",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
    }

    private void buttonFourWarning() {
        if(!buttonFourClicked) {
            JOptionPane.showMessageDialog(
null,
                "Please click 'sortByHilt' first before using this button.",
                "Buttons Error",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Driver();
            }
        });
    }
}
