import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerController implements ActionListener {
    private CustomerView customerView;
    private DataAccess dataAccess;

    public CustomerController(CustomerView customerView, DataAccess dataAccess)
    {
        this.customerView = customerView;
        this.dataAccess = dataAccess;

        customerView.getBtnAddCustomer().addActionListener(this);
        customerView.getBtnUpdateCustomer().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerView.getBtnAddCustomer())
        {
            addCustomer();
        }
        else if (e.getSource() == customerView.getBtnUpdateCustomer())
        {
            updateCustomer();
        }
    }

    private void addCustomer()
    {
        try
        {
            int customerID = Integer.parseInt(customerView.getTextCustomerID().getText());
            String customerName = customerView.getTextCustomerName().getText();
            String customerAddress = customerView.getTextCustomerAddress().getText();
            String customerPhone = customerView.getTextCustomerPhone().getText();

            Customer customer = new Customer();
            customer.setCustomerID(customerID);
            customer.setCustomerName(customerName);
            customer.setCustomerAddress(customerAddress);
            customer.setCustomerPhone(customerPhone);

            boolean success = dataAccess.saveCustomer(customer);
            if (success)
            {
                JOptionPane.showMessageDialog(customerView, "Customer added successfully.");
            }
            else {
                JOptionPane.showMessageDialog(customerView, "Failed to add customer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(customerView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCustomer() {
        try {
            int customerID = Integer.parseInt(customerView.getTextCustomerID().getText());
            String customerName = customerView.getTextCustomerName().getText();
            String customerAddress = customerView.getTextCustomerAddress().getText();
            String customerPhone = customerView.getTextCustomerPhone().getText();

            Customer customer = new Customer();
            customer.setCustomerID(customerID);
            customer.setCustomerName(customerName);
            customer.setCustomerAddress(customerAddress);
            customer.setCustomerPhone(customerPhone);

            boolean success = dataAccess.saveCustomer(customer);
            if (success) {
                JOptionPane.showMessageDialog(customerView, "Customer updated successfully.");
            } else {
                JOptionPane.showMessageDialog(customerView, "Failed to update customer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(customerView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
