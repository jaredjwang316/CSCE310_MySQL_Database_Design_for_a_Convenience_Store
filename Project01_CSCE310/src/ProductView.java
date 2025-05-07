import javax.swing.*;

public class ProductView extends JFrame {
    private JTextField txtProductID = new JTextField(10);
    private JTextField txtSupplierID = new JTextField(10);
    private JTextField txtProductName = new JTextField(30);
    private JTextField txtRetailPrice = new JTextField(10);

    private JButton btnAddProduct = new JButton("Add a product");
    private JButton btnUpdateProduct = new JButton("Update a product");

    public ProductView()
    {
        this.setTitle("Manage Products");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(1000, 250);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAddProduct);
        buttonPanel.add(btnUpdateProduct);
        this.getContentPane().add(buttonPanel);

        JPanel panelProductID = new JPanel();
        panelProductID.add(new JLabel("Product ID: "));
        panelProductID.add(txtProductID);
        this.getContentPane().add(panelProductID);

        JPanel panelSupplierID = new JPanel();
        panelSupplierID.add(new JLabel("Supplier ID: "));
        panelSupplierID.add(txtSupplierID);
        this.getContentPane().add(panelSupplierID);

        JPanel panelProductName = new JPanel();
        panelProductName.add(new JLabel("Product Name: "));
        panelProductName.add(txtProductName);
        this.getContentPane().add(panelProductName);

        JPanel panelPrice = new JPanel();
        panelPrice.add(new JLabel("Retail Price of the Product: "));
        panelPrice.add(txtRetailPrice);
        this.getContentPane().add(panelPrice);

    }

    public JButton getBtnAddProduct()
    {
        return btnAddProduct;
    }

    public JButton getBtnUpdateProduct()
    {
        return btnUpdateProduct;
    }

    public JTextField getTxtProductID()
    {
        return txtProductID;
    }

    public JTextField getTxtSupplierID()
    {
        return txtSupplierID;
    }

    public JTextField getTxtProductName()
    {
        return txtProductName;
    }

    public JTextField getTxtRetailPrice()
    {
        return txtRetailPrice;
    }
}
