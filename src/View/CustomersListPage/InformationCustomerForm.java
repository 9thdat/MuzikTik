/*
 * Created by JFormDesigner on Mon Apr 24 09:08:31 ICT 2023
 */

package View.CustomersListPage;

import Controller.CustomerPanel.InformationCustomerController;
import Model.BEAN.Customer.Customer;
import Model.DAO.Customer.CustomerDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author ADMIN
 */
public class InformationCustomerForm extends JPanel {
    static int selectedID = -1;

    ActionListener ac = new InformationCustomerController(this);
    public InformationCustomerForm() {
        initComponents();
        getSAVE().addActionListener(ac);
        getCancel().addActionListener(ac);
    }

    public InformationCustomerForm(int newID) {
        initComponents();
        getSAVE().addActionListener(ac);
        getCancel().addActionListener(ac);
        this.IDField.setText(String.valueOf(newID));
    }

    public InformationCustomerForm(Customer customer){
        initComponents();
        initMoreSetting(customer);
        getSAVE().addActionListener(ac);
        getCancel().addActionListener(ac);
    }

    public void initMoreSetting(Customer customer) {
        this.NameField.setText(customer.getName());
        this.AddressField.setText(customer.getAddress());
        this.PhoneNumberFiled.setText(customer.getPhoneNumber());
        this.TotalPointVal.setText(String.valueOf(customer.getTotalPoint()));
        this.EmailField.setText(customer.getEmail());
        this.TypeField.setText(customer.getType());
        this.UserNameField.setText(customer.getUsername());
        this.PasswordField.setText(customer.getPassword());
        this.selectedID = customer.getId();
        this.IDField.setText(String.valueOf(customer.getId()));
        System.out.println("selected id = " + this.selectedID);
    }

    public static void settingForNewCustomer(String name, String phone, String email) {
        NameField.setText(name);
        PhoneNumberFiled.setText(phone);
        EmailField.setText(email);
    }

    public String getName() {
        return this.Name.getText();
    }

    public static int getSelectedID() {
        return selectedID;
    }

    public JLabel getEmail() {
        return this.Email;
    }

    public JLabel getAddress() {
        return this.Address;
    }

    public JLabel getPhoneNumber() {
        return this.PhoneNumber;
    }

    public JButton getCancel() {
        return this.Cancel;
    }

    public JButton getSAVE() {
        return this.SAVE;
    }

    public JLabel getID() {
        return this.ID;
    }

    public JPanel getInformationCustomerPanel() {
        return this.InformationCustomerPanel;
    }

    public JLabel getTotalPoint() {
        return this.TotalPoint;
    }

    public JTextField getNameField() {
        return this.NameField;
    }

    public JTextField getPhoneNumberFiled() {
        return this.PhoneNumberFiled;
    }

    public JTextField getEmailField() {
        return this.EmailField;
    }

    public JTextField getAddressField() {
        return this.AddressField;
    }

    public JTextField getTotalPointVal() {
        return this.TotalPointVal;
    }

    public JTextField getIDField() {
        return this.IDField;
    }

    public JLabel getType() {
        return this.Type;
    }

    public JTextField getTypeField() {
        return this.TypeField;
    }

    public JLabel getLabel1() {
        return this.label1;
    }

    public JLabel getUserName() {
        return this.UserName;
    }

    public JTextField getUserNameField() {
        return this.UserNameField;
    }

    public JLabel getLabel3() {
        return this.label3;
    }

    public JTextField getPasswordField() {
        return this.PasswordField;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Xuan Quynh Le
        this.InformationCustomerPanel = new JPanel();
        this.Name = new JLabel();
        this.Email = new JLabel();
        this.Address = new JLabel();
        this.PhoneNumber = new JLabel();
        this.Cancel = new JButton();
        this.SAVE = new JButton();
        this.TotalPoint = new JLabel();
        this.NameField = new JTextField();
        this.PhoneNumberFiled = new JTextField();
        this.EmailField = new JTextField();
        this.AddressField = new JTextField();
        this.TotalPointVal = new JTextField();
        this.ID = new JLabel();
        this.IDField = new JTextField();
        this.Type = new JLabel();
        this.TypeField = new JTextField();
        this.label1 = new JLabel();
        this.UserName = new JLabel();
        this.UserNameField = new JTextField();
        this.label3 = new JLabel();
        this.PasswordField = new JTextField();

        //======== this ========
        setMinimumSize(new Dimension(735, 548));
        setMaximumSize(new Dimension(735, 548));
        setFont(new Font("Lato Black", Font.PLAIN, 16));
        setForeground(new Color(0x61b884));
        setBackground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
        .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax
        . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,
        12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans
        .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e.
        getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //---- Name ----
        this.Name.setText("Name:");
        this.Name.setFont(new Font("Lato Black", Font.PLAIN, 16));
        this.Name.setForeground(new Color(0x61b884));

        //---- Email ----
        this.Email.setText("Email:");
        this.Email.setFont(new Font("Lato Black", Font.PLAIN, 16));
        this.Email.setForeground(new Color(0x61b884));

        //---- Address ----
        this.Address.setText("Address:");
        this.Address.setFont(new Font("Lato Black", Font.PLAIN, 16));
        this.Address.setForeground(new Color(0x61b884));

        //---- PhoneNumber ----
        this.PhoneNumber.setText("Phone Number:");
        this.PhoneNumber.setFont(new Font("Lato Black", Font.PLAIN, 16));
        this.PhoneNumber.setForeground(new Color(0x61b884));

        //---- Cancel ----
        this.Cancel.setText("CANCEL");
        this.Cancel.setPreferredSize(new Dimension(80, 30));
        this.Cancel.setFont(new Font("Lato Black", Font.BOLD, 16));
        this.Cancel.setBackground(new Color(0x61b884));
        this.Cancel.setForeground(Color.white);

        //---- SAVE ----
        this.SAVE.setText("SAVE");
        this.SAVE.setPreferredSize(new Dimension(80, 30));
        this.SAVE.setFont(new Font("Lato Black", Font.BOLD, 16));
        this.SAVE.setBackground(new Color(0x61b884));
        this.SAVE.setForeground(Color.white);

        //---- TotalPoint ----
        this.TotalPoint.setFont(new Font("Lato Black", Font.PLAIN, 16));
        this.TotalPoint.setText("Total Point:");
        this.TotalPoint.setForeground(new Color(0x61b884));
        this.TotalPoint.setBackground(Color.white);

        //---- NameField ----
        this.NameField.setBackground(Color.white);
        this.NameField.setName("NameVal");
        this.NameField.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- PhoneNumberFiled ----
        this.PhoneNumberFiled.setBackground(Color.white);
        this.PhoneNumberFiled.setName("EmailVal");
        this.PhoneNumberFiled.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- EmailField ----
        this.EmailField.setBackground(Color.white);
        this.EmailField.setName("AddressVal");
        this.EmailField.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- AddressField ----
        this.AddressField.setBackground(Color.white);
        this.AddressField.setName("PhoneNumberVal");
        this.AddressField.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- TotalPointVal ----
        this.TotalPointVal.setBackground(Color.white);
        this.TotalPointVal.setName("TotalPointVal");
        this.TotalPointVal.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- ID ----
        this.ID.setText("ID:");
        this.ID.setFont(new Font("Lato Black", Font.PLAIN, 16));
        this.ID.setForeground(new Color(0x61b884));

        //---- IDField ----
        this.IDField.setBackground(new Color(0xcccccc));
        this.IDField.setName("NameVal");
        this.IDField.setEditable(false);
        this.IDField.setFont(new Font("Lato", Font.PLAIN, 16));
        this.IDField.setEnabled(false);
        this.IDField.setDisabledTextColor(new Color(0x333333));

        //---- Type ----
        this.Type.setFont(new Font("Lato Black", Font.PLAIN, 16));
        this.Type.setText("Type:");
        this.Type.setForeground(new Color(0x61b884));

        //---- TypeField ----
        this.TypeField.setBackground(Color.white);
        this.TypeField.setName("TotalPointVal");
        this.TypeField.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- label1 ----
        this.label1.setText("CUSTOMER INFORMATION");
        this.label1.setFont(new Font("Lato Black", Font.PLAIN, 25));
        this.label1.setForeground(new Color(0x61b884));

        //---- UserName ----
        this.UserName.setText("Username:");
        this.UserName.setFont(new Font("Lato Black", Font.BOLD, 16));
        this.UserName.setForeground(new Color(0x61b884));

        //---- UserNameField ----
        this.UserNameField.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- label3 ----
        this.label3.setText("Password:");
        this.label3.setFont(new Font("Lato Black", Font.BOLD, 16));
        this.label3.setForeground(new Color(0x61b884));

        //---- PasswordField ----
        this.PasswordField.setFont(new Font("Lato", Font.PLAIN, 16));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(this.ID, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.Name, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                                    .addGap(67, 67, 67)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(this.IDField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.NameField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(this.Email, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.UserName)
                                        .addComponent(this.label3))
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(this.UserNameField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(this.PasswordField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(this.EmailField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
                            .addGap(209, 209, 209)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(this.PhoneNumber, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(this.PhoneNumberFiled, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(this.SAVE, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(this.Cancel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(this.TotalPoint, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                            .addComponent(this.TotalPointVal, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(this.Address, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(this.Type, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                                            .addGap(51, 51, 51)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(this.AddressField, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                                .addComponent(this.TypeField, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(387, 387, 387)
                            .addComponent(this.label1)))
                    .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(this.label1)
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.ID)
                        .addComponent(this.IDField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.PhoneNumber)
                        .addComponent(this.PhoneNumberFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Name)
                        .addComponent(this.Address)
                        .addComponent(this.AddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Type)
                        .addComponent(this.TypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.Email)
                        .addComponent(this.EmailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.TotalPoint)
                        .addComponent(this.TotalPointVal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.UserName)
                        .addComponent(this.UserNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.label3)
                        .addComponent(this.PasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Cancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.SAVE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(148, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Xuan Quynh Le
    private JPanel InformationCustomerPanel;
    JLabel Name;
    JLabel Email;
    JLabel Address;
    JLabel PhoneNumber;
    JButton Cancel;
    JButton SAVE;
    JLabel TotalPoint;
    private static JTextField NameField;
    private static JTextField PhoneNumberFiled;
    private static JTextField EmailField;
    JTextField AddressField;
    JTextField TotalPointVal;
    JLabel ID;
    JTextField IDField;
    JLabel Type;
    JTextField TypeField;
    JLabel label1;
    JLabel UserName;
    JTextField UserNameField;
    JLabel label3;
    JTextField PasswordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void saveCustomer() throws SQLException {
        if (this.NameField.equals("") || this.EmailField.equals("") || this.AddressField.equals("")
                || this.PhoneNumberFiled.equals("") || this.TotalPointVal.equals("") || this.TypeField.equals("")
            || this.IDField.equals("") || this.UserNameField.equals("") || this.PasswordField.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        } else {
            Customer customer = null;
            if (selectedID == -1 ) { // add new customer
                System.out.println("Add new customer");
                customer = new Customer();
                customer.setId(Integer.parseInt(this.IDField.getText()));
                customer.setName(this.NameField.getText());
                customer.setEmail(this.EmailField.getText());
                customer.setAddress(this.AddressField.getText());
                customer.setPhoneNumber(this.PhoneNumberFiled.getText());
                customer.setTotalPoint(Integer.parseInt(this.TotalPointVal.getText()));
                customer.setType(this.TypeField.getText());
                customer.setId(Integer.parseInt(this.IDField.getText()));
                customer.setUsername(this.UserNameField.getText());
            }
            else { // update customer
                System.out.println("update customer");
                customer = CustomerDAO.getInstance().selectByID(selectedID);
                customer.setId(selectedID);
                customer.setName(this.NameField.getText());
                customer.setEmail(this.EmailField.getText());
                customer.setAddress(this.AddressField.getText());
                customer.setPhoneNumber(this.PhoneNumberFiled.getText());
                customer.setTotalPoint(Integer.parseInt(this.TotalPointVal.getText()));
                customer.setType(this.TypeField.getText());
                customer.setId(Integer.parseInt(this.IDField.getText()));
                customer.setUsername(this.UserNameField.getText());
            }

            if (selectedID != -1) {
                int rowChanged = CustomerDAO.getInstance().updateCustomer(customer);
                if (rowChanged > 0) {
                    JOptionPane.showMessageDialog(null, "Update customer successfully");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Update customer failed");
                }
            }
            else {
                int rowChanged = CustomerDAO.getInstance().addCustomer(customer);
                if (rowChanged > 0) {
                    JOptionPane.showMessageDialog(null, "Add customer successfully");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Add customer failed");
                }
            }
            MainPage.changeView(new CustomersListPanel(), MainPage.getJlbCustomer(), "CustomerListPanel");
        }
    }
    public void cancelCustomer() {
        MainPage.changeView(new CustomersListPanel(), MainPage.getJlbCustomer(), "CustomerListPanel");
    }
}
