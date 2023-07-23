package Gui;
import factory.RaceBuilder;
import game.arenas.Arena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import utilities.DP.CarRaceBuilder;
import utilities.DP.Director;
import utilities.DP.MyRaceBuilder;
import utilities.EnumContainer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 *  * @Author Daniel Arvili
 *  * @Author Aviv Hagag
 *  * this class responsible to build a game with arenas and racers

 The RaceFrame class represents the main GUI window for the racing game.
 It extends the JFrame class and implements the ActionListener interface.
 It provides various text fields, combo boxes and buttons to create, build and start the race.
 The RaceFrame class also handles events such as button clicks and updates the GUI
 as necessary.
 */
public class RaceFrame extends JFrame implements ActionListener {

    private static RaceBuilder builder = RaceBuilder.getInstance();;
    private JComboBox<String> cmbArenas;
    private JComboBox<String> cmbRacers;
    private JComboBox<String> cmbColors;
    private JComboBox<String> cmbColorsCopy;
    private JComboBox<String> cmbRacercopy;
    private  ArrayList<Racer> Racers;
    private JTextField ArenaLength;
    private JTextField MaxRacers;
    private JTextField RacerName;
    private JTextField MaxSpeed;
    private JTextField Acceleration;
    private JTextField racersAtCarRace;
    private Arena arena = null;
    private String chosenArena = null;
    private int arenaLength = 1000; //
    private int arenaHeight = 700;//
    private int maxRacers = 8;//
    private boolean started=false;
    private boolean finished=false;
    private int racersNumber = 0;
    private ImageIcon racersImages[] = null;
    private JFrame infoTable = null;
    private JPanel controlsPanel;
    /**
     A class representing the GUI frame for the Race game.
     */
    public RaceFrame() {
        /**
         Creates a new RaceFrame instance with a default title of "Race", sets its content pane
         to the main panel, packs it, centers it on the screen, sets the default close operation to
         exit on close, and makes it visible.
         */
        super("Race");
        setControlPanel();
        this.setContentPane(CreatePanel());
        this.setBackground(Color.white);
        this.pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    /**
     Handles the user's actions based on the selected buttons from the controll panel.
     */
    public void actionPerformed(ActionEvent e) // take care of all btn click events
    {
        switch (e.getActionCommand()) {
            /**
             * Checks whether it is possible to build an arena, and if it is possible,
             builds an arena whose length depends on the number of competitors and the width depends on the size of the arena entered by the user
             */
            case "Build arena":
            {
                if (!finished && started) {
                    JOptionPane.showMessageDialog(this, "Race Already Started!");
                    break;
                }
                arenaLength = Integer.parseInt(ArenaLength.getText());
                maxRacers = Integer.parseInt(MaxRacers.getText());
                if (arenaLength < 100 || arenaLength > 3000 || maxRacers <= 0 || maxRacers > 20) {
                    JOptionPane.showMessageDialog(this, "Invalid input values! Please try again.");
                    break;
                }
                racersNumber = 0;
                started = finished = false;
                int newHeight = (maxRacers + 1) * 60;
                if (newHeight > 700)
                    this.arenaHeight = newHeight;
                else
                    this.arenaHeight = 700;
                Racers= new ArrayList<>();
                racersImages = new ImageIcon[maxRacers];
                chosenArena = (String) cmbArenas.getSelectedItem();
                try {
                    if (chosenArena.equals("AerialArena")) {
                        arena = builder.buildArena("game.arenas.air.AerialArena", arenaLength, maxRacers);
                    } else if (chosenArena.equals("LandArena")) {
                        arena = builder.buildArena("game.arenas.land.LandArena", arenaLength, maxRacers);
                    } else if (chosenArena.equals("NavalArena")) {
                        arena = builder.buildArena("game.arenas.naval.NavalArena", arenaLength, maxRacers);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                updateFrame();
                break;
        }
            /**
             * If the arena is suitable for a racer, create a racer by type, color, name, speed and acceleration.
             * Then add the image of that racer to the arena itself according to its position in order on the y axis.
             */
            case "Add racer":
            {
                if(started)
                {
                    JOptionPane.showMessageDialog(this,"The race already started racer was not added!");
                    break;
                }
                if(finished)
                {
                    JOptionPane.showMessageDialog(this,"The race has finished racer was not added!");
                    break;

                }
                if(arena ==null)
                {
                    JOptionPane.showMessageDialog(this,"Arena was not build, racer was not added!");
                    break;
                }
                if(racersNumber==maxRacers)
                {
                    JOptionPane.showMessageDialog(this,"The arena is full, racer was not added!");
                    break;
                }
                try {
                    String name=RacerName.getText();
                    double acceleration=Double.parseDouble(Acceleration.getText());
                    double maxspeed=Double.parseDouble(MaxSpeed.getText());
                    if (name.isEmpty() || acceleration <= 0 || maxspeed <= 0) {
                        throw new Exception();
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "Invalid input values! Please try again, racer was not added!");
                    break;
                }
                String Racertype=(String) cmbRacers.getSelectedItem();
                String Racerclass=null;
                switch (Racertype)
                {
                    case "Airplane":
                        Racerclass="game.racers.air.Airplane";
                        break;
                    case "Helicopter":
                        Racerclass="game.racers.air.Helicopter";
                        break;
                    case "Car":
                        Racerclass="game.racers.land.Car";
                        break;
                    case "Bicycle":
                        Racerclass="game.racers.land.Bicycle";
                        break;
                    case "Horse":
                        Racerclass="game.racers.land.Horse";
                        break;
                    case "RowBoat":
                        Racerclass="game.racers.naval.RowBoat";
                        break;
                    case "SpeedBoat":
                        Racerclass="game.racers.naval.SpeedBoat";
                        break;
                }
                 EnumContainer.Color cl=null;
                switch ((String) cmbColors.getSelectedItem())
                {
                    case "Red":
                        cl=EnumContainer.Color.RED;
                        break;
                    case "Black":
                        cl=EnumContainer.Color.BLACK;
                        break;
                    case "Green":
                        cl=EnumContainer.Color.GREEN;
                        break;
                    case "Blue":
                        cl=EnumContainer.Color.BLUE;
                        break;
                    case "Yellow":
                        cl=EnumContainer.Color.YELLOW;
                        break;
                }


                    if(Racertype.equals("Airplane")||Racertype.equals("Car")||Racertype.equals("Bicycle"))
                    {
                        try {
                            Racer racer = builder.buildWheeledRacer(Racerclass, RacerName.getText(), Double.parseDouble(MaxSpeed.getText()), Double.parseDouble(Acceleration.getText()), cl, 3);
                            Racers.add(racer);
                            arena.addRacer(racer);
                            arena.initRace();

                        }
                        catch (RacerTypeException ex) {
                            JOptionPane.showMessageDialog(this, ex.getMessage());
                            break;
                        }
                        catch (Exception ex) {
                            break;
                        }
                    }
                    else {
                        try {
                            Racer racer = builder.buildRacer(Racerclass, RacerName.getText(), Double.parseDouble(MaxSpeed.getText()), Double.parseDouble(Acceleration.getText()), cl);
                            Racers.add(racer);
                            arena.addRacer(racer);
                            arena.initRace();
                        } catch (RacerTypeException ex) {
                            JOptionPane.showMessageDialog(this, ex.getMessage());
                            break;
                        } catch (Exception ex) {
                            break;
                        }
                    }
                        racersImages[racersNumber] = new ImageIcon(new ImageIcon("icons/" + Racertype + cl + ".png").getImage()
                                .getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                        racersNumber++;
                        updateFrame();
                        break;
                    }

            case "Copy Racer":
            {
                if(started)
                {
                    JOptionPane.showMessageDialog(this,"The race already started racer was not added!");
                    break;
                }
                if(finished)
                {
                    JOptionPane.showMessageDialog(this,"The race has finished racer was not added!");
                    break;

                }
                if(arena ==null)
                {
                    JOptionPane.showMessageDialog(this,"Arena was not build, racer was not added!");
                    break;
                }
                if(racersNumber==0)
                {
                    JOptionPane.showMessageDialog(this,"There is no racers to copy,racer was not added!");
                    break;

                }

                if(racersNumber==maxRacers)
                {
                    JOptionPane.showMessageDialog(this,"The arena is full, racer was not added!");
                    break;
                }

                int index=Integer.parseInt((String) cmbRacercopy.getSelectedItem());
                EnumContainer.Color cl=null;
                switch ((String) cmbColorsCopy.getSelectedItem())
                {
                    case "Red":
                        cl=EnumContainer.Color.RED;
                        break;
                    case "Black":
                        cl=EnumContainer.Color.BLACK;
                        break;
                    case "Green":
                        cl=EnumContainer.Color.GREEN;
                        break;
                    case "Blue":
                        cl=EnumContainer.Color.BLUE;
                        break;
                    case "Yellow":
                        cl=EnumContainer.Color.YELLOW;
                        break;
                }
                Racer copyracer=null;
                for(int i=0;i<racersNumber;i++){
                    if(Racers.get(i).getSerialNumber()==index)
                         copyracer = Racers.get(i).clone();
                }
                try {
                    copyracer.upgrade(cl);
                    Racers.add( copyracer);
                    arena.addRacer( copyracer);
                    arena.initRace();
                }
                catch (Exception ex) {
                    break;
                }
                racersImages[racersNumber] = new ImageIcon(new ImageIcon("icons/" +  copyracer.className() + cl + ".png").getImage()
                        .getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                racersNumber++;
                updateFrame();
                break;
            }

            case "Build Car Race":
            {
                if (!finished && started) {
                    JOptionPane.showMessageDialog(this, "Race Already Started!");
                    break;
                }
                if ( racersAtCarRace.getText().equals("") ||Integer.parseInt(racersAtCarRace.getText())<=0 ||Integer.parseInt(racersAtCarRace.getText())>20){
                JOptionPane.showMessageDialog(this, "Invalid input values! Please try again.");
                break;
            }
                int numofracers = Integer.parseInt(racersAtCarRace.getText());
                Director d=new Director(new CarRaceBuilder(numofracers)); //Builder DP
                try {
                    d.BuildRace();
                } catch (RacerTypeException ex) {
                    ex.printStackTrace();
                } catch (RacerLimitException ex) {
                    ex.printStackTrace();
                }
                chosenArena="LandArena";
                arenaLength=(int)d.getRace().getMyArena().getLength();
                arena=d.getRace().getMyArena();
                Racers=d.getRace().getMyRacers();
                maxRacers=numofracers;
                racersNumber = numofracers;
                started = finished = false;
                int newHeight = (maxRacers + 1) * 60;
                if (newHeight > 700)
                    this.arenaHeight = newHeight;
                else
                    this.arenaHeight = 700;
                racersImages = new ImageIcon[maxRacers];
                for(int i=0;i<racersNumber;i++) {
                    racersImages[i] = new ImageIcon(new ImageIcon("icons/" + "Car" + Racers.get(i).getColor() + ".png").getImage()
                            .getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                }
                updateFrame();
                break;
            }
            /**
             Handles the "Start race" button action. Validates the race conditions and starts the race threads.
             */
            case "Start race":
                if(arena==null) {
                    JOptionPane.showMessageDialog(this, "Build Arena first!");
                    break;
                }
                if(racersNumber==0) {
                    JOptionPane.showMessageDialog(this, "There is no racers in the arena!");
                    break;
                }
                if(started)
                {
                    JOptionPane.showMessageDialog(this, "The race already started");
                    break;
                }
                if(finished)
                {
                    JOptionPane.showMessageDialog(this, "The race finished");
                    break;
                }
                started=true;
                // try {
                    (new Thread() {
                        public void run() {
                            while (arena.hasActiveRacers()|| arena.hasBrokenRacers()) {
                                try {
                                    Thread.sleep(30);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                                updateFrame();
                            }
                            updateFrame();
                            finished=true;
                        }
                    }).start();

                    for(int i=0;i<arena.getActiveRacers().size();i++)
                    {
                        Thread thread=new Thread(arena.getActiveRacers().get(i));
                        thread.start();
                    }
                break;
               // }
            /**
             Shows information about the racers in a table format.
             If the arena is null or there are no racers, a message is shown to the user.
             The table shows the following columns: Racer name, Current speed, Max speed,
             Current x location, Finished. The rows represent the racers, and their
             respective values for each column.
             If the info table already exists, it will be closed and a new one will be opened.
             The table is displayed in a scroll pane and in a new JFrame window.
             */
            case "Show info":
                if(arena== null || racersNumber==0) {
                    JOptionPane.showMessageDialog(this, "cannot show info try again!");
                    break;
                }
                String[] columnNames = {" Racer name", "Current speed", "Max speed","Current x location","Finished"};
                String[][] info=new String[racersNumber][5];
                int count=0;
                for(int i=0;i<arena.getCompletedRacers().size();i++)
                {
                    info[count][0]=arena.getCompletedRacers().get(i).getName();
                    info[count][1]= ""+arena.getCompletedRacers().get(i).getCurrentSpeed();
                    info[count][2]= ""+arena.getCompletedRacers().get(i).getMaxSpeed();
                    info[count][3]= ""+arena.getCompletedRacers().get(i).getCurrentLocation().getX();
                    info[count][4]="Yes";
                    count++;

                }
                for(int i=0;i<arena.getActiveRacers().size();i++)
                {
                    info[count][0]=arena.getActiveRacers().get(i).getName();
                    info[count][1]= ""+arena.getActiveRacers().get(i).getCurrentSpeed();
                    info[count][2]= ""+arena.getActiveRacers().get(i).getMaxSpeed();
                    info[count][3]= ""+arena.getActiveRacers().get(i).getCurrentLocation().getX();
                    info[count][4]="No";
                    count++;
                }
                for(int i=arena.getBrokenRacers().size()-1;i>=0;i--)
                {
                    info[count][0]=arena.getBrokenRacers().get(i).getName();
                    info[count][1]= ""+arena.getBrokenRacers().get(i).getCurrentSpeed();
                    info[count][2]= ""+arena.getBrokenRacers().get(i).getMaxSpeed();
                    info[count][3]= ""+arena.getBrokenRacers().get(i).getCurrentLocation().getX();
                    info[count][4]="Break";
                    count++;
                }
                for(int i=arena.getDisableRacers().size()-1;i>=0;i--)
                {
                    info[count][0]=arena.getDisableRacers().get(i).getName();
                    info[count][1]= ""+arena.getDisableRacers().get(i).getCurrentSpeed();
                    info[count][2]= ""+arena.getDisableRacers().get(i).getMaxSpeed();
                    info[count][3]= ""+arena.getDisableRacers().get(i).getCurrentLocation().getX();
                    info[count][4]="Disable";
                    count++;
                }
                JTable table = new JTable(info, columnNames);
                table.setPreferredScrollableViewportSize(table.getPreferredSize());
                JScrollPane scrollPane = new JScrollPane(table);

                JPanel tabPan = new JPanel();
                tabPan.add(scrollPane);

                if (infoTable != null)
                    infoTable.dispose();
                infoTable = new JFrame("Racers information");
                infoTable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                infoTable.setContentPane(tabPan);
                infoTable.pack();
                infoTable.setVisible(true);
                break;
        }

    }
    /**
     This method returns the main JPanel that contains all the UI controls to manage the race game and the JPanel with a background image of the chosen arena and all the racers.
     @return a JPanel object that contains all the UI controls for managing the race game
     */
    private void setControlPanel()
    {
        controlsPanel=new JPanel();
        controlsPanel.setLayout(null);
        controlsPanel.setPreferredSize(new Dimension(300, arenaHeight));
        controlsPanel.setBackground(Color.white);
        String[] Arenas={"AerialArena","LandArena","NavalArena"};
        cmbArenas=new JComboBox<String>(Arenas);
        JLabel label1=new JLabel("Choose arena:");
        label1.setLocation(10,20);
        label1.setSize(100,10);
        controlsPanel.add(label1);
        cmbArenas.setLocation(10, 40);
        cmbArenas.setSize(125, 25);
        controlsPanel.add(cmbArenas);
        JLabel label2=new JLabel("Arena Length:");
        label2.setLocation(10,75);
        label2.setSize(100,10);
        controlsPanel.add(label2);
        ArenaLength=new JTextField(""+arenaLength);
        ArenaLength.setLocation(10,95);
        ArenaLength.setSize(100,25);
        controlsPanel.add(ArenaLength);
        JLabel label3=new JLabel("Max Racers number");
        label3.setLocation(10,135);
        label3.setSize(150,10);
        controlsPanel.add(label3);
        MaxRacers=new JTextField(""+maxRacers);
        MaxRacers.setLocation(10,155);
        MaxRacers.setSize(100,25);
        controlsPanel.add(MaxRacers);
        JButton Buildbtn=new JButton("Build arena");
        Buildbtn.setSize(100,30);
        Buildbtn.setLocation(10,195);
        Buildbtn.addActionListener(this);
        controlsPanel.add(Buildbtn);
        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setLocation(0, 245);
        sep.setSize(300, 10);
        sep.setBackground(Color.black);
        controlsPanel.add(sep);
        JSeparator sep3 = new JSeparator(SwingConstants.VERTICAL);
        sep3.setLocation(155, 0);
        sep3.setSize(10, 250);
        sep3.setBackground(Color.black);
        controlsPanel.add(sep3);
        JLabel label4=new JLabel("Choose racer:");
        label4.setLocation(10,260);
        label4.setSize(100,20);
        controlsPanel.add(label4);
        String[] racers={"Airplane","Helicopter","Car","Bicycle","Horse","RowBoat","SpeedBoat"};
        cmbRacers=new JComboBox<String>(racers);
        cmbRacers.setLocation(10,285);
        cmbRacers.setSize(120,20);
        controlsPanel.add(cmbRacers);
        JLabel label5=new JLabel("Choose color:");
        label5.setLocation(10,318);
        label5.setSize(100,20);
        controlsPanel.add(label5);
        String[] Colors={"Black","Red","Green","Blue","Yellow"};
        cmbColors=new JComboBox<String>(Colors);
        cmbColors.setLocation(10,344);
        cmbColors.setSize(120,20);
        controlsPanel.add(cmbColors);
        JLabel label6=new JLabel("Racer name:");
        label6.setLocation(10,370);
        label6.setSize(100,20);
        controlsPanel.add(label6);
        RacerName=new JTextField();
        RacerName.setLocation(10,390);
        RacerName.setSize(100,25);
        controlsPanel.add(RacerName);
        JLabel label7=new JLabel("Max speed:");
        label7.setLocation(10,430);
        label7.setSize(100,20);
        controlsPanel.add(label7);
        MaxSpeed=new JTextField();
        MaxSpeed.setLocation(10,450);
        MaxSpeed.setSize(100,25);
        controlsPanel.add(MaxSpeed);
        JLabel label8=new JLabel("Acceleration:");
        label8.setLocation(10,490);
        label8.setSize(100,25);
        controlsPanel.add(label8);
        Acceleration=new JTextField();
        Acceleration.setLocation(10,510);
        Acceleration.setSize(100,25);
        controlsPanel.add(Acceleration);
        JButton AddRacerbtn=new JButton("Add racer");
        AddRacerbtn.setLocation(10,550);
        AddRacerbtn.setSize(100,30);
        AddRacerbtn.addActionListener(this);
        controlsPanel.add(AddRacerbtn);
        JSeparator sep2 = new JSeparator(SwingConstants.HORIZONTAL);
        sep2.setBackground(Color.black);
        sep2.setLocation(0, 590);
        sep2.setSize(300, 10);
        controlsPanel.add(sep2);
        JButton StartRacebtn=new JButton("Start race");
        StartRacebtn.setLocation(10,610);
        StartRacebtn.setSize(100,30);
        StartRacebtn.addActionListener(this);
        controlsPanel.add(StartRacebtn);
        JButton ShowInfobtn=new JButton("Show info");
        ShowInfobtn.setLocation(10,645);
        ShowInfobtn.setSize(100,30);
        ShowInfobtn.addActionListener(this);
        controlsPanel.add(ShowInfobtn);
        // from here start hw3 buttons
        JLabel label9=new JLabel("Copy racer:");
        label9.setLocation(175,20);
        label9.setSize(100,15);
        controlsPanel.add(label9);
        cmbRacercopy=new JComboBox<String>();
        cmbRacercopy.setLocation(175,40);
        cmbRacercopy.setSize(120,25);
        controlsPanel.add(cmbRacercopy);
        JLabel label10=new JLabel("Choose color:");
        label10.setLocation(175,65);
        label10.setSize(100,20);
        controlsPanel.add(label10);
        cmbColorsCopy=new JComboBox<String>(Colors);
        cmbColorsCopy.setLocation(175,90);
        cmbColorsCopy.setSize(120,25);
        controlsPanel.add(cmbColorsCopy);
        JButton Copybtn=new JButton("Copy Racer");
        Copybtn.setLocation(175,125);
        Copybtn.setSize(100,30);
        Copybtn.addActionListener(this);
        controlsPanel.add(Copybtn);
        JLabel label12=new JLabel("Number:");
        label12.setSize(120,15);
        label12.setLocation(175,160);
        controlsPanel.add(label12);
        racersAtCarRace=new JTextField();
        racersAtCarRace.setSize(100,25);
        racersAtCarRace.setLocation(175,185);
        controlsPanel.add(racersAtCarRace);
        JButton builderbtn=new JButton("Build Car Race");
        builderbtn.setLocation(175,220);
        builderbtn.setSize(120,30);
        builderbtn.addActionListener(this);
        controlsPanel.add(builderbtn);

    }
    private void  setControlPanelHeight()
    {
        controlsPanel.setPreferredSize(new Dimension(300, arenaHeight));
    }

    /**
     This method creates a JPanel with a background image of the chosen arena and adds JLabels with the images of
     the racers at their current locations to the panel.
     */
   public JPanel CreatePanel()
    {
       JPanel ArenasPanel=new JPanel();
       ArenasPanel.setLayout(null);
       boolean flag= false;
       ArenasPanel.setPreferredSize(new Dimension(arenaLength + 80, arenaHeight));
       ArenasPanel.setBackground(Color.white);
       /* set the Arena picture  */
        ImageIcon imageIcon1;
        int width=0,height=0;
        if(chosenArena== null) {
            imageIcon1 = new ImageIcon(new ImageIcon("icons/" + "wallpaper3" + ".png").getImage().getScaledInstance(750, arenaHeight, Image.SCALE_SMOOTH));
            flag = true;
            width = 750;
        }
        else {
            imageIcon1 = new ImageIcon(new ImageIcon("icons/" +  chosenArena + ".jpg").getImage().getScaledInstance(arenaLength + 80, arenaHeight, Image.SCALE_SMOOTH));
        }
//       ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("icons/" +  chosenArena + ".jpg").getImage().getScaledInstance(arenaLength + 80, arenaHeight, Image.SCALE_SMOOTH));
       JLabel picLabel1 = new JLabel(imageIcon1);
       picLabel1.setLocation(0, 0);
       picLabel1.setSize(arenaLength + 80, arenaHeight);
       if(flag== true) {
           ArenasPanel.setPreferredSize(new Dimension(width,height));
           picLabel1.setSize(width, arenaHeight);
       }
       ArenasPanel.add(picLabel1);
        /* set the racers icons*/
        cmbRacercopy.removeAllItems();
        for (int i = 0; i < racersNumber; i++) {
            cmbRacercopy.addItem(Integer.toString(Racers.get(i).getSerialNumber()));
            JLabel picLabel2 = new JLabel(racersImages[i]);
            picLabel2.setLocation((int) Racers.get(i).getCurrentLocation().getX() + 5,
                    (int) Racers.get(i).getCurrentLocation().getY());
            picLabel2.setSize(70, 70);
            picLabel1.add(picLabel2);
        }

        /* return  the main panel */
       JPanel mainPanel = new JPanel();
       mainPanel.setLayout(new BorderLayout());
       mainPanel.add(controlsPanel, BorderLayout.EAST);
       mainPanel.add(ArenasPanel, BorderLayout.WEST);
       JSeparator sp3=new JSeparator(SwingConstants.VERTICAL);
       sp3.setBackground(Color.black);
       mainPanel.add(sp3, BorderLayout.CENTER);
       return mainPanel;

   }
    /**

     The updateFrame() method updates the current frame with the contents of the main panel,
     centers the frame on the screen, and makes it visible.
     This method first sets the content pane of the frame to the main panel retrieved via getMainPanel(),
     resizes the frame to fit the contents, and then computes the center position of the frame on the screen
     using the screen dimensions obtained via Toolkit.getDefaultToolkit().getScreenSize().
     The frame is then moved to the center position calculated and finally set to visible.
     */
    private void updateFrame()
    {
        setControlPanelHeight();
        this.setContentPane(CreatePanel());
        this.pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
//
    }
}


