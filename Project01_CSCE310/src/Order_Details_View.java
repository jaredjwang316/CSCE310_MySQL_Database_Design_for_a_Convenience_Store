import javax.swing.*;

public class Order_Details_View extends JFrame {
    private JTextField txtOrderID = new JTextField(10);
    private JTextField txtProductID = new JTextField(10);
    private JTextField txtQuantity = new JTextField(10);

    private JButton btnAddOrderDetails = new JButton("Add Order Details");
    private JButton btnUpdateOrderDetails = new JButton("Update Order Details");

    public Order_Details_View()
    {
        this.setTitle("Manage Order Details");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(1000, 250);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAddOrderDetails);
        buttonPanel.add(btnUpdateOrderDetails);
        this.getContentPane().add(buttonPanel);

        JPanel panelOrderID = new JPanel();
        panelOrderID.add(new JLabel("Order ID: "));
        panelOrderID.add(txtOrderID);
        this.getContentPane().add(panelOrderID);

        JPanel panelProductID = new JPanel();
        panelProductID.add(new JLabel("Product ID: "));
        panelProductID.add(txtProductID);
        this.getContentPane().add(panelProductID);

        JPanel panelQuantity = new JPanel();
        panelQuantity.add(new JLabel("Quantity: "));
        panelQuantity.add(txtQuantity);
        this.getContentPane().add(panelQuantity);

    }

    public JButton getBtnAddOrderDetails()
    {
        return btnAddOrderDetails;
    }

    public JButton getBtnUpdateOrderDetails()
    {
        return btnUpdateOrderDetails;
    }

    public JTextField getTxtOrderID()
    {
        return txtOrderID;
    }

    public JTextField getTxtProductID()
    {
        return txtProductID;
    }

    public JTextField getTxtQuantity()
    {
        return txtQuantity;
    }
}
