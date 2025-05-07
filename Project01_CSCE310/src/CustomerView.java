import javax.swing.*;

public class CustomerView extends JFrame {
    private JTextField textCustomerID = new JTextField(10);
    private JTextField textCustomerName = new JTextField(25);
    private JTextField textCustomerAddress = new JTextField(30);
    private JTextField textCustomerPhone = new JTextField(20);

    private JButton btnAddCustomer = new JButton("Add a customer");
    private JButton btnUpdateCustomer = new JButton("Update a customer");

    public CustomerView()
    {
        this.setTitle("Manage Customers");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(1000, 250);

        JPanel panelButton = new JPanel();
        panelButton.add(btnAddCustomer);
        panelButton.add(btnUpdateCustomer);
        this.getContentPane().add(panelButton);

        JPanel panelCustomerID = new JPanel();
        panelCustomerID.add(new JLabel("Customer's ID: "));
        panelCustomerID.add(textCustomerID);
        this.getContentPane().add(panelCustomerID);

        JPanel panelCustomerName = new JPanel();
        panelCustomerName.add(new JLabel("Customer's Name: "));
        panelCustomerName.add(textCustomerName);
        this.getContentPane().add(panelCustomerName);

        JPanel panelCustomerAddress = new JPanel();
        panelCustomerAddress.add(new JLabel("Customer's Address: "));
        panelCustomerAddress.add(textCustomerAddress);
        this.getContentPane().add(panelCustomerAddress);

        JPanel panelCustomerPhone = new JPanel();
        panelCustomerPhone.add(new JLabel("Customer's Phone Number: "));
        panelCustomerPhone.add(textCustomerPhone);
        this.getContentPane().add(panelCustomerPhone);
    }

    public JButton getBtnAddCustomer()
    {
        return btnAddCustomer;
    }

    public JButton getBtnUpdateCustomer()
    {
        return btnUpdateCustomer;
    }

    public JTextField getTextCustomerID()
    {
        return textCustomerID;
    }

    public JTextField getTextCustomerName()
    {
        return textCustomerName;
    }

    public JTextField getTextCustomerAddress()
    {
        return textCustomerAddress;
    }

    public JTextField getTextCustomerPhone()
    {
        return textCustomerPhone;
    }

}
