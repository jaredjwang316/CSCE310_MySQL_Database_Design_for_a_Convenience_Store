import javax.swing.*;

public class SupplierView extends JFrame {
    private JTextField textSupplierID = new JTextField(10);
    private JTextField textSupplierName = new JTextField(25);
    private JTextField textSupplierAddress = new JTextField(30);
    private JTextField textSupplierPhone = new JTextField(20);

    private JButton btnAddSupplier = new JButton("Add a supplier");
    private JButton btnUpdateSupplier = new JButton("Update a supplier");

    public SupplierView() {
        this.setTitle("Manage Suppliers");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(1000, 250);

        JPanel panelButton = new JPanel();
        panelButton.add(btnAddSupplier);
        panelButton.add(btnUpdateSupplier);
        this.getContentPane().add(panelButton);

        JPanel panelSupplierID = new JPanel();
        panelSupplierID.add(new JLabel("Supplier's ID: "));
        panelSupplierID.add(textSupplierID);
        this.getContentPane().add(panelSupplierID);

        JPanel panelSupplierName = new JPanel();
        panelSupplierName.add(new JLabel("Supplier's Name: "));
        panelSupplierName.add(textSupplierName);
        this.getContentPane().add(panelSupplierName);

        JPanel panelSupplierAddress = new JPanel();
        panelSupplierAddress.add(new JLabel("Supplier's Address: "));
        panelSupplierAddress.add(textSupplierAddress);
        this.getContentPane().add(panelSupplierAddress);

        JPanel panelSupplierPhone = new JPanel();
        panelSupplierPhone.add(new JLabel("Supplier's Phone Number: "));
        panelSupplierPhone.add(textSupplierPhone);
        this.getContentPane().add(panelSupplierPhone);
    }

    public JButton getBtnAddSupplier()
    {
        return btnAddSupplier;
    }

    public JButton getBtnUpdateSupplier()
    {
        return btnUpdateSupplier;
    }

    public JTextField getTextSupplierID()
    {
        return textSupplierID;
    }

    public JTextField getTextSupplierName()
    {
        return textSupplierName;
    }

    public JTextField getTextSupplierAddress()
    {
        return textSupplierAddress;
    }

    public JTextField getTextSupplierPhone()
    {
        return textSupplierPhone;
    }

}
