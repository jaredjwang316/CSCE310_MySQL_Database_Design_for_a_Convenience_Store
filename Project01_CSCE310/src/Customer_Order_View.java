import javax.swing.*;

public class Customer_Order_View extends JFrame {
    private JTextField txtOrderID = new JTextField(10);
    private JTextField txtCustomerID = new JTextField(10);
    private JTextField txtOrderDate = new JTextField(15);

    private JButton btnAddOrder = new JButton("Add an order");
    private JButton btnUpdateOrder = new JButton("Update an order");

    public Customer_Order_View()
    {
        this.setTitle("Manage Customer Orders");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(1000, 250);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAddOrder);
        buttonPanel.add(btnUpdateOrder);
        this.getContentPane().add(buttonPanel);

        JPanel panelOrderID = new JPanel();
        panelOrderID.add(new JLabel("Order ID: "));
        panelOrderID.add(txtOrderID);
        this.getContentPane().add(panelOrderID);

        JPanel panelCustomerID = new JPanel();
        panelCustomerID.add(new JLabel("Customer ID: "));
        panelCustomerID.add(txtCustomerID);
        this.getContentPane().add(panelCustomerID);

        JPanel panelOrderDate = new JPanel();
        panelOrderDate.add(new JLabel("Order Date: "));
        panelOrderDate.add(txtOrderDate);
        this.getContentPane().add(panelOrderDate);

    }

    public JButton getBtnAddOrder()
    {
        return btnAddOrder;
    }

    public JButton getBtnUpdateOrder()
    {
        return btnUpdateOrder;
    }

    public JTextField getTxtOrderID()
    {
        return txtOrderID;
    }

    public JTextField getTxtCustomerID()
    {
        return txtCustomerID;
    }

    public JTextField getTxtOrderDate()
    {
        return txtOrderDate;
    }
}
