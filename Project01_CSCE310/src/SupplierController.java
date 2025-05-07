import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class SupplierController implements ActionListener {
    private SupplierView supplierView;
    private DataAccess dataAccess;

    public SupplierController(SupplierView supplierView, DataAccess dataAccess)
    {
        this.supplierView = supplierView;
        this.dataAccess = dataAccess;

        this.supplierView.getBtnAddSupplier().addActionListener(this);
        this.supplierView.getBtnUpdateSupplier().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == supplierView.getBtnAddSupplier())
        {
            addSupplier();
        }
        else if (e.getSource() == supplierView.getBtnUpdateSupplier())
        {
            updateSupplier();
        }
    }

    private void addSupplier()
    {
        try
        {
            int supplierID = Integer.parseInt(supplierView.getTextSupplierID().getText());
            String supplierName = supplierView.getTextSupplierName().getText();
            String supplierAddress = supplierView.getTextSupplierAddress().getText();
            String supplierPhone = supplierView.getTextSupplierPhone().getText();

            Supplier supplier = new Supplier();
            supplier.setSupplierID(supplierID);
            supplier.setSupplierName(supplierName);
            supplier.setSupplierAddress(supplierAddress);
            supplier.setSupplierPhone(supplierPhone);

            boolean success = dataAccess.saveSupplier(supplier);
            if (success)
            {
                JOptionPane.showMessageDialog(supplierView, "Supplier added successfully.");
            }
            else {
                JOptionPane.showMessageDialog(supplierView, "Failed to add supplier.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(supplierView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateSupplier()
    {
        try
        {
            int supplierID = Integer.parseInt(supplierView.getTextSupplierID().getText());
            String supplierName = supplierView.getTextSupplierName().getText();
            String supplierAddress = supplierView.getTextSupplierAddress().getText();
            String supplierPhone = supplierView.getTextSupplierPhone().getText();

            Supplier supplier = new Supplier();
            supplier.setSupplierID(supplierID);
            supplier.setSupplierName(supplierName);
            supplier.setSupplierAddress(supplierAddress);
            supplier.setSupplierPhone(supplierPhone);

            boolean success = dataAccess.saveSupplier(supplier);
            if (success)
            {
                JOptionPane.showMessageDialog(supplierView, "Supplier updated successfully.");
            }
            else {
                JOptionPane.showMessageDialog(supplierView, "Failed to update supplier.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(supplierView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
