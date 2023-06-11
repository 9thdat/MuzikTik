/*
 * Created by JFormDesigner on Thu Apr 27 12:08:53 ICT 2023
 */

package View.Home;

import Controller.EventListPanel;
import Model.BEAN.*;
import Model.DAO.Event.Event;
import Model.DAO.Event.EventInformation.*;
import View.EventPage.EventPanel;
import View.MainPage.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ADMIN
 */
public class HomePanel extends JPanel {
    static Integer selectedEventID;
    static String selectedEvent;
    static Integer selectedStage;
    ButtonGroup bg = new ButtonGroup();
    MouseListener ac1 = new EventListPanel(this,1);
    MouseListener ac2 = new EventListPanel(this,2);
    MouseListener ac3 = new EventListPanel(this,3);
    MouseListener ac4 = new EventListPanel(this,4);
    MouseListener ac5 = new EventListPanel(this,5);
    MouseListener ac6 = new EventListPanel(this,6);
    MouseListener ac7 = new EventListPanel(this,7);
    MouseListener ac8 = new EventListPanel(this,8);
    MouseListener ac9 = new EventListPanel(this,9);
    List<EventArtID> eventArt = null;
    List<EventInformation> eventInformationList= null;
    List<StageInformation> eventStageInformation = null;
    List<EventList> listEvent = null;
    List<EventPrice> listEventPrice = null;
    ArrayList<JLabel> listLabelPicture = new ArrayList<JLabel>();
    ArrayList<JLabel> listLabelName = new ArrayList<JLabel>();
    ArrayList<JLabel> listLabelDate = new ArrayList<JLabel>();
    ArrayList<JRadioButton> slideDots = new ArrayList<>();

    public HomePanel() {
        initComponents();
        addListPicture();
        addLabelName();
        addLabelDate();
        addButtonGroup();
        listEvent = Event.getEventList();
        int totalPage = 0;
        for(int i = 0; i < listEvent.size(); i++) {
            totalPage++;
        }
        if(totalPage%9 == 0) {
            totalPage = totalPage/9;
        } else {
            totalPage = totalPage/9 + 1;
        }
        for(int i=0;i<totalPage;i++) {
            comboBox1.addItem(i+1);
        }
        setEventList();
        initMoreSetting();
        initEventHandler();
    }

    public void initEventHandler() {
        eventName1.addMouseListener(ac1);
        eventName2.addMouseListener(ac2);
        eventName3.addMouseListener(ac3);
        eventName4.addMouseListener(ac4);
        eventName5.addMouseListener(ac5);
        eventName6.addMouseListener(ac6);
        eventName7.addMouseListener(ac7);
        eventName8.addMouseListener(ac8);
        eventName9.addMouseListener(ac9);
    }

    public void initMoreSetting() {
        show(position);
        slideDot1.setSelected(true);
        mainScrollPanel.getVerticalScrollBar().setUnitIncrement(19);

        slideDots.add(slideDot1);
        slideDots.add(slideDot2);
        slideDots.add(slideDot3);
        slideDots.add(slideDot4);
        slideDots.add(slideDot5);
        slideDots.add(slideDot6);
    }
    public void addButtonGroup() {
        bg.add(slideDot1);
        bg.add(slideDot2);
        bg.add(slideDot3);
        bg.add(slideDot4);
        bg.add(slideDot5);
        bg.add(slideDot6);
    }
    public void addListPicture() {
        listLabelPicture.add(eventPicture1);
        listLabelPicture.add(eventPicture2);
        listLabelPicture.add(eventPicture3);
        listLabelPicture.add(evetntPicture4);
        listLabelPicture.add(evetntPicture5);
        listLabelPicture.add(evetntPicture6);
        listLabelPicture.add(evetntPicture7);
        listLabelPicture.add(evetntPicture8);
        listLabelPicture.add(evetntPicture9);
    }
    public void addLabelName() {
        listLabelName.add(eventName1);
        listLabelName.add(eventName2);
        listLabelName.add(eventName3);
        listLabelName.add(eventName4);
        listLabelName.add(eventName5);
        listLabelName.add(eventName6);
        listLabelName.add(eventName7);
        listLabelName.add(eventName8);
        listLabelName.add(eventName9);
    }
    public void addLabelDate() {
        listLabelDate.add(eventDate1);
        listLabelDate.add(eventDate2);
        listLabelDate.add(eventDate3);
        listLabelDate.add(eventDate4);
        listLabelDate.add(eventDate5);
        listLabelDate.add(eventDate6);
        listLabelDate.add(eventDate7);
        listLabelDate.add(eventDate8);
        listLabelDate.add(eventDate9);
    }

    public void setEventList() {
        for (int i = 0; i < 9; i++) {
            ImageIcon eventPicture = listEvent.get(i).getEventPicture();
            String eventName = listEvent.get(i).getEventName();
            String eventDate = listEvent.get(i).getEventDate();

            listLabelPicture.get(i).setIcon(eventPicture);
            listLabelName.get(i).setText("<HTML>" + eventName + "</HTML>");
            listLabelDate.get(i).setText(eventDate);
        }
    }

    int position = 0;
    int index = 0;
    public String[] takeImage() {
        File f = new File(getClass().getResource("/Asset/Event").getFile());
        System.out.println(f);
        String[] Images = f.list();
        return Images;
    }

    public void show(int i) {
        String[] Images = takeImage();
        System.out.println(Images[0]);
        String img = Images[i];
        ImageIcon icon = new ImageIcon(getClass().getResource("/Asset/Event/" + img));
        Image image = icon.getImage().getScaledInstance(796, 262, Image.SCALE_SMOOTH);
        mainLivePicture.setIcon(new ImageIcon(image));
    }

    public void clickEventPanel(String src) {
        setSelectedEvent(src);
        MainPage.changeView(new EventPanel(), MainPage.getJlbEvent(), "EventPanel");
        eventInformationList = EventInformationList.getEventInformationList();
        eventSetting();
        System.out.println(selectedStage);
        eventStageInformation = GetStageName.getStageInformationList();
        stageSetting();
        eventArt = GetArt.getArtByID();
        pictureArtSetting();
        listEventPrice = EventPriceList.getEventPriceList();
        eventPriceSetting();
        EventTableDatabase.getEventTableDatabase();
    }
    public void eventPriceSetting() {
        ArrayList<JLabel> listLabelType = EventPanel.addTicketType();
        ArrayList<JLabel> listLabelPrice = EventPanel.addTicketPrice();
        for (int i = 0; i < listLabelType.size(); i++) {
            try {
                listLabelType.get(i).setText("Ticket Class: " + listEventPrice.get(i).getEventType());
                listLabelPrice.get(i).setText("Price: " + listEventPrice.get(i).getEventPrice() + " USD");
            } catch (Exception e) {
                listLabelType.get(i).setText("");
                listLabelPrice.get(i).setText("");
            }
        }
    }
    public void eventSetting() {
        for(EventInformation eventInformation : eventInformationList) {
            EventPanel.getEventName().setText("<HTML>" + eventInformation.getEventName() + "</HTML>");
            EventPanel.getEventName2().setText("<HTML>" + eventInformation.getEventName() + "</HTML>");
            String fomattedString = localDateToString(eventInformation.getEventDate());
            EventPanel.getEventTime().setText(fomattedString);
            setSelectedStage(eventInformation.getEventStageID());
            EventPanel.getDescriptionText().setText("<HTML>" + eventInformation.getEventDescription() + "</HTML>");
            setSelectedEventID(eventInformation.getEventID());
        }
    }
    public void pictureArtSetting() {
        for(EventArtID art : eventArt) {
            ImageIcon icon = new ImageIcon(getClass().getResource("Asset/Event/" + art.getEventArtID()));
            EventPanel.getEventArt().setIcon(icon);
        }
    }
    public void stageSetting() {
        for(StageInformation stage : eventStageInformation) {
            EventPanel.getEventPlace().setText(stage.getStageName());
            ImageIcon icon = new ImageIcon(getClass().getResource("/Asset/Stage/" + stage.getStageSeatingChart()));
            EventPanel.getSeatingChartView().setIcon(icon);
            EventPanel.getEventSeatingChart().setIcon(icon);
            EventPanel.getSeatingChartView().setText("");
            EventPanel.getSeatingChartView().setVerticalAlignment(JLabel.CENTER);
            EventPanel.getSeatingChartView().setHorizontalAlignment(JLabel.CENTER);
            EventPanel.getEventSeatingChart().setText("");
            EventPanel.getEventSeatingChart().setVerticalAlignment(JLabel.CENTER);
            EventPanel.getEventSeatingChart().setHorizontalAlignment(JLabel.CENTER);

        }
    }
    public String localDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);

        return formattedString;
    }
    public void setSelectedEventID(Integer eventID) {
        selectedEventID = eventID;
    }
    public static Integer getSelectedEventID() {
        return selectedEventID;
    }
    public void setSelectedEvent(String src) {
        selectedEvent = src;
    }
    public static String getSelectedEvent() {
        return selectedEvent;
    }
    public void setSelectedStage(Integer stageID) {
        selectedStage = stageID;
    }
    public static Integer getSelectedStage() {
        return selectedStage;
    }
    private void radioButton1MouseClicked(MouseEvent e) {
        bg.setSelected(slideDot1.getModel(), true);
        show(0);
        index = 0;
        position = 0;
    }

    private void radioButton2MouseClicked(MouseEvent e) {
        bg.setSelected(slideDot2.getModel(), true);
        show(1);
        index = 1;
        position = 1;
    }

    private void radioButton3MouseClicked(MouseEvent e) {
        bg.setSelected(slideDot3.getModel(), true);
        show(2);
        index = 2;
        position = 2;
    }

    private void radioButton4MouseClicked(MouseEvent e) {
        bg.setSelected(slideDot4.getModel(), true);
        show(3);
        index = 3;
        position = 3;
    }

    private void radioButton5MouseClicked(MouseEvent e) {
        bg.setSelected(slideDot5.getModel(), true);
        show(4);
        index = 4;
        position = 4;
    }

    private void radioButton6MouseClicked(MouseEvent e) {
        bg.setSelected(slideDot6.getModel(), true);
        show(5);
        index = 5;
        position = 5;
    }

    private void previousButtonMouseClicked(MouseEvent e) {
        new Thread();
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        int p = this.mainLivePicture.getX();
        if(p>-1) {
            Animacion.Animacion.mover_izquierda(200, 900, 1, 2, mainLivePicture);
        }
        if(position > 0) {
            position = position - 1;
        }
        if (position>=takeImage().length) {
            position = takeImage().length+1;
        }
        show(position);

        if (index > 0) {
            bg.setSelected(slideDots.get(index-1).getModel(), true);
            index = index - 1;
        }
    }

    private void nextButtonMouseClicked(MouseEvent e) {
        new Thread();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        int p = this.mainLivePicture.getX();
        if(p>-1) {
            Animacion.Animacion.mover_izquierda(200, 900, 1, 2, mainLivePicture);
        }
        position=position+1;
        if (position>=takeImage().length) {
            position = takeImage().length-1;
        }
        show(position);

        if(index < 5) {
            bg.setSelected(slideDots.get(index+1).getModel(), true);
            index = index + 1;
        }
    }

    public static JLabel getEventName1() {
        return eventName1;
    }
    public static JLabel getEventName2() {
        return eventName2;
    }
    public static JLabel getEventName3() {
        return eventName3;
    }
    public static JLabel getEventName4() {
        return eventName4;
    }
    public static JLabel getEventName5() {
        return eventName5;
    }
    public static JLabel getEventName6() {
        return eventName6;
    }
    public static JLabel getEventName7() {
        return eventName7;
    }
    public static JLabel getEventName8() {
        return eventName8;
    }
    public static JLabel getEventName9() {
        return eventName9;
    }

    private void slideDot1(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    private void button1MouseClicked(MouseEvent e) {
        Integer selectedPage = Integer.parseInt(comboBox1.getSelectedItem().toString());
        Integer pageRoot = selectedPage - 1;
        int j = 0;
        for (int i = pageRoot*9; i < 9*selectedPage; i++) {
            ImageIcon eventPicture = listEvent.get(i).getEventPicture();
            String eventName = listEvent.get(i).getEventName();
            String eventDate = listEvent.get(i).getEventDate();

            listLabelPicture.get(j).setIcon(eventPicture);
            listLabelName.get(j).setText("<HTML>" + eventName + "</HTML>");
            listLabelDate.get(j).setText(eventDate);
            j++;
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
        mainScrollPanel = new JScrollPane();
        panel2 = new JPanel();
        mainLabel = new JLabel();
        mainLivePicture = new JLabel();
        previousButton = new JLabel();
        nextButton = new JLabel();
        eventLabel = new JLabel();
        eventPicture3 = new JLabel();
        eventPicture1 = new JLabel();
        eventPicture2 = new JLabel();
        eventName1 = new JLabel();
        eventName2 = new JLabel();
        eventDate2 = new JLabel();
        eventDate1 = new JLabel();
        eventName3 = new JLabel();
        eventDate3 = new JLabel();
        evetntPicture4 = new JLabel();
        evetntPicture5 = new JLabel();
        evetntPicture6 = new JLabel();
        eventName6 = new JLabel();
        eventDate6 = new JLabel();
        eventDate5 = new JLabel();
        eventName5 = new JLabel();
        eventName4 = new JLabel();
        eventDate4 = new JLabel();
        evetntPicture7 = new JLabel();
        evetntPicture8 = new JLabel();
        evetntPicture9 = new JLabel();
        eventName9 = new JLabel();
        eventDate9 = new JLabel();
        eventDate8 = new JLabel();
        eventName8 = new JLabel();
        eventName7 = new JLabel();
        eventDate7 = new JLabel();
        slideDot1 = new JRadioButton();
        slideDot2 = new JRadioButton();
        slideDot3 = new JRadioButton();
        slideDot4 = new JRadioButton();
        slideDot5 = new JRadioButton();
        slideDot6 = new JRadioButton();
        comboBox1 = new JComboBox();
        button1 = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //======== mainScrollPanel ========
        {
            mainScrollPanel.setBorder(null);

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setFont(new Font("Lato Black", Font.BOLD, 20));

                //---- mainLabel ----
                mainLabel.setText("LET ME LIVE HAPPEN");
                mainLabel.setFont(new Font("Lato Black", Font.BOLD, 30));
                mainLabel.setForeground(new Color(0x61b884));
                mainLabel.setBackground(Color.white);

                //---- mainLivePicture ----
                mainLivePicture.setBorder(null);

                //---- previousButton ----
                previousButton.setIcon(null);
                previousButton.setText("previous");
                previousButton.setForeground(Color.black);
                previousButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        previousButtonMouseClicked(e);
                    }
                });

                //---- nextButton ----
                nextButton.setIcon(null);
                nextButton.setForeground(Color.black);
                nextButton.setText("Next");
                nextButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nextButtonMouseClicked(e);
                    }
                });

                //---- eventLabel ----
                eventLabel.setText("HIGHLIGHT EVENT");
                eventLabel.setFont(new Font("Lato Black", Font.BOLD, 28));
                eventLabel.setForeground(new Color(0x61b884));

                //---- eventPicture3 ----
                eventPicture3.setBorder(null);

                //---- eventPicture1 ----
                eventPicture1.setBorder(null);

                //---- eventPicture2 ----
                eventPicture2.setBorder(null);

                //---- eventName1 ----
                eventName1.setText("Event Name");
                eventName1.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventName1.setForeground(new Color(0x61b884));

                //---- eventName2 ----
                eventName2.setText("Event Name");
                eventName2.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventName2.setForeground(new Color(0x61b884));

                //---- eventDate2 ----
                eventDate2.setText("Date");
                eventDate2.setFont(new Font("Lato", Font.BOLD, 16));
                eventDate2.setForeground(new Color(0x61b884));

                //---- eventDate1 ----
                eventDate1.setText("Date");
                eventDate1.setFont(new Font("Lato", Font.BOLD, 16));
                eventDate1.setForeground(new Color(0x61b884));

                //---- eventName3 ----
                eventName3.setText("Event Name");
                eventName3.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventName3.setForeground(new Color(0x61b884));

                //---- eventDate3 ----
                eventDate3.setText("Date");
                eventDate3.setFont(new Font("Lato", Font.BOLD, 16));
                eventDate3.setForeground(new Color(0x61b884));

                //---- evetntPicture4 ----
                evetntPicture4.setBorder(null);

                //---- evetntPicture5 ----
                evetntPicture5.setBorder(null);

                //---- evetntPicture6 ----
                evetntPicture6.setBorder(null);

                //---- eventName6 ----
                eventName6.setText("Event Name");
                eventName6.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventName6.setForeground(new Color(0x61b884));

                //---- eventDate6 ----
                eventDate6.setText("Date");
                eventDate6.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventDate6.setForeground(new Color(0x61b884));

                //---- eventDate5 ----
                eventDate5.setText("Date");
                eventDate5.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventDate5.setForeground(new Color(0x61b884));

                //---- eventName5 ----
                eventName5.setText("Event Name");
                eventName5.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventName5.setForeground(new Color(0x61b884));

                //---- eventName4 ----
                eventName4.setText("Event Name");
                eventName4.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventName4.setForeground(new Color(0x61b884));

                //---- eventDate4 ----
                eventDate4.setText("Date");
                eventDate4.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventDate4.setForeground(new Color(0x61b884));

                //---- evetntPicture7 ----
                evetntPicture7.setBorder(null);

                //---- evetntPicture8 ----
                evetntPicture8.setBorder(null);

                //---- evetntPicture9 ----
                evetntPicture9.setBorder(null);

                //---- eventName9 ----
                eventName9.setText("Event Name");
                eventName9.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventName9.setForeground(new Color(0x61b884));

                //---- eventDate9 ----
                eventDate9.setText("Date");
                eventDate9.setFont(new Font("Lato", Font.BOLD, 16));
                eventDate9.setForeground(new Color(0x61b884));

                //---- eventDate8 ----
                eventDate8.setText("Date");
                eventDate8.setFont(new Font("Lato", Font.BOLD, 16));
                eventDate8.setForeground(new Color(0x61b884));

                //---- eventName8 ----
                eventName8.setText("Event Name");
                eventName8.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventName8.setForeground(new Color(0x61b884));

                //---- eventName7 ----
                eventName7.setText("Event Name");
                eventName7.setFont(new Font("Lato Black", Font.BOLD, 16));
                eventName7.setForeground(new Color(0x61b884));

                //---- eventDate7 ----
                eventDate7.setText("Date");
                eventDate7.setFont(new Font("Lato", Font.BOLD, 16));
                eventDate7.setForeground(new Color(0x61b884));

                //---- slideDot1 ----
                slideDot1.setBackground(Color.white);
                slideDot1.setForeground(new Color(0x61b884));
                slideDot1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton1MouseClicked(e);
                    }
                });

                //---- slideDot2 ----
                slideDot2.setBackground(Color.white);
                slideDot2.setForeground(new Color(0x61b884));
                slideDot2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton2MouseClicked(e);
                    }
                });

                //---- slideDot3 ----
                slideDot3.setBackground(Color.white);
                slideDot3.setForeground(new Color(0x61b884));
                slideDot3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton3MouseClicked(e);
                    }
                });

                //---- slideDot4 ----
                slideDot4.setBackground(Color.white);
                slideDot4.setForeground(new Color(0x61b884));
                slideDot4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton4MouseClicked(e);
                    }
                });

                //---- slideDot5 ----
                slideDot5.setBackground(Color.white);
                slideDot5.setForeground(new Color(0x61b884));
                slideDot5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton5MouseClicked(e);
                    }
                });

                //---- slideDot6 ----
                slideDot6.setBackground(Color.white);
                slideDot6.setForeground(new Color(0x61b884));
                slideDot6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton6MouseClicked(e);
                    }
                });

                //---- button1 ----
                button1.setText("text");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(434, 434, 434)
                            .addComponent(mainLabel)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(404, 404, 404)
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(eventLabel)
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panel2Layout.createSequentialGroup()
                                                            .addComponent(slideDot1)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(slideDot2)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(slideDot3)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(slideDot4)))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panel2Layout.createParallelGroup()
                                                        .addGroup(panel2Layout.createSequentialGroup()
                                                            .addComponent(slideDot5)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(slideDot6))
                                                        .addComponent(button1)))))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(evetntPicture7, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                                .addComponent(eventDate7, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                                .addComponent(eventName7, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                                            .addGap(109, 109, 109)
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(evetntPicture8, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                                .addComponent(eventDate8, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                                .addComponent(eventName8, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                                            .addGap(104, 104, 104)
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(evetntPicture9, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                                .addComponent(eventDate9, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                                .addComponent(eventName9, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(panel2Layout.createParallelGroup()
                                                    .addComponent(evetntPicture4, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(eventName4, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(eventDate4, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(eventDate1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addComponent(eventPicture1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(1, 1, 1)))
                                            .addGap(109, 109, 109)
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(eventName5, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addGroup(panel2Layout.createParallelGroup()
                                                        .addComponent(evetntPicture5, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eventDate5, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eventPicture2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eventDate2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eventName2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(104, 104, 104)
                                                    .addGroup(panel2Layout.createParallelGroup()
                                                        .addComponent(eventDate3, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eventDate6, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(evetntPicture6, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eventName6, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eventName3, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eventPicture3, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)))))
                                        .addComponent(eventName1, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                    .addGap(70, 70, 70)
                                    .addComponent(mainLivePicture, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(266, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(mainLabel)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(154, 154, 154)
                                    .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(148, 148, 148)
                                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(mainLivePicture, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)))
                            .addGap(27, 27, 27)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(slideDot1)
                                .addComponent(slideDot2)
                                .addComponent(slideDot3)
                                .addComponent(slideDot4)
                                .addComponent(slideDot5)
                                .addComponent(slideDot6))
                            .addGap(49, 49, 49)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1))
                            .addGap(126, 126, 126)
                            .addComponent(eventLabel)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(eventPicture1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(eventName1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                    .addGap(23, 23, 23)
                                    .addComponent(eventDate1)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(eventPicture3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(eventName3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(eventDate3))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(eventPicture2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addGap(13, 13, 13)
                                            .addComponent(eventName2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                            .addGap(17, 17, 17)
                                            .addComponent(eventDate2)))))
                            .addGap(52, 52, 52)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(evetntPicture4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventName4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addComponent(eventName5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addComponent(eventName6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventDate4)
                                .addComponent(eventDate5)
                                .addComponent(eventDate6))
                            .addGap(67, 67, 67)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(evetntPicture7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(eventName9, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eventName8, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                                .addComponent(eventName7, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                            .addGap(19, 19, 19)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(eventDate9)
                                .addComponent(eventDate8)
                                .addComponent(eventDate7))
                            .addGap(694, 694, 694))
                );
            }
            mainScrollPanel.setViewportView(panel2);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(15, Short.MAX_VALUE)
                    .addComponent(mainScrollPanel, GroupLayout.PREFERRED_SIZE, 1131, GroupLayout.PREFERRED_SIZE)
                    .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(mainScrollPanel, GroupLayout.PREFERRED_SIZE, 1726, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1311, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
    private JScrollPane mainScrollPanel;
    private JPanel panel2;
    private JLabel mainLabel;
    private JLabel mainLivePicture;
    private JLabel previousButton;
    private JLabel nextButton;
    private JLabel eventLabel;
    private JLabel eventPicture3;
    private JLabel eventPicture1;
    private JLabel eventPicture2;
    private static JLabel eventName1;
    private static JLabel eventName2;
    private static JLabel eventDate2;
    private static JLabel eventDate1;
    private static JLabel eventName3;
    private static JLabel eventDate3;
    private JLabel evetntPicture4;
    private JLabel evetntPicture5;
    private JLabel evetntPicture6;
    private static JLabel eventName6;
    private static JLabel eventDate6;
    private static JLabel eventDate5;
    private static JLabel eventName5;
    private static JLabel eventName4;
    private static JLabel eventDate4;
    private JLabel evetntPicture7;
    private JLabel evetntPicture8;
    private JLabel evetntPicture9;
    private static JLabel eventName9;
    private static JLabel eventDate9;
    private static JLabel eventDate8;
    private static JLabel eventName8;
    private static JLabel eventName7;
    private static JLabel eventDate7;
    private JRadioButton slideDot1;
    private JRadioButton slideDot2;
    private JRadioButton slideDot3;
    private JRadioButton slideDot4;
    private JRadioButton slideDot5;
    private JRadioButton slideDot6;
    private JComboBox comboBox1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
