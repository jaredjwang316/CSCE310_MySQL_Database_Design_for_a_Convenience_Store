
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController implements ActionListener {
    private ProductView productView;
    private DataAccess dataAccess;

    public ProductController(ProductView productView, DataAccess dataAccess)
    {
        this.productView = productView;
        this.dataAccess = dataAccess;

        this.productView.getBtnAddProduct().addActionListener(this);
        this.productView.getBtnUpdateProduct().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == productView.getBtnAddProduct())
        {
            addProduct();
        }
        else if (e.getSource() == productView.getBtnUpdateProduct())
        {
            updateProduct();
        }
    }

    public void addProduct()
    {
        try
        {
            int productID = Integer.parseInt(productView.getTxtProductID().getText());
            int supplierID = Integer.parseInt(productView.getTxtSupplierID().getText());
            String productName = productView.getTxtProductName().getText();
            double retailPrice = Double.parseDouble(productView.getTxtRetailPrice().getText());

            Product product = new Product();
            product.setProductID(productID);
            product.setSupplierID(supplierID);
            product.setProductName(productName);
            product.setRetailPrice(retailPrice);

            boolean success = dataAccess.saveProduct(product);
            if (success)
            {
                JOptionPane.showMessageDialog(productView, "Product added successfully.");
            }
            else
            {
                JOptionPane.showMessageDialog(productView, "Failed to add product.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(productView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateProduct()
    {
        try
        {
            int productID = Integer.parseInt(productView.getTxtProductID().getText());
            int supplierID = Integer.parseInt(productView.getTxtSupplierID().getText());
            String productName = productView.getTxtProductName().getText();
            double retailPrice = Double.parseDouble(productView.getTxtRetailPrice().getText());

            Product prod = new Product();
            prod.setProductID(productID);
            prod.setSupplierID(supplierID);
            prod.setProductName(productName);
            prod.setRetailPrice(retailPrice);

            boolean success = dataAccess.saveProduct(prod);
            if (success)
            {
                JOptionPane.showMessageDialog(productView, "Product updated successfully.");
            }
            else
            {
                JOptionPane.showMessageDialog(productView, "Failed to update product.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(productView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
