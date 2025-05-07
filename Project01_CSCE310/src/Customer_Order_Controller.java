import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customer_Order_Controller implements ActionListener {
    private Customer_Order_View customerOrderView;
    private DataAccess dataAccess;

    public Customer_Order_Controller(Customer_Order_View customerOrderView, DataAccess dataAccess)
    {
        this.customerOrderView = customerOrderView;
        this.dataAccess = dataAccess;

        this.customerOrderView.getBtnAddOrder().addActionListener(this);
        this.customerOrderView.getBtnUpdateOrder().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == customerOrderView.getBtnAddOrder())
        {
            addOrder();
        }
        else if (e.getSource() == customerOrderView.getBtnUpdateOrder())
        {
            updateOrder();
        }
    }

    public void addOrder()
    {
        try {
            int orderID = Integer.parseInt(customerOrderView.getTxtOrderID().getText());
            int customerID = Integer.parseInt(customerOrderView.getTxtCustomerID().getText());
            String orderDate = customerOrderView.getTxtOrderDate().getText();

            Customer_Order customerOrder = new Customer_Order();
            customerOrder.setOrderID(orderID);
            customerOrder.setCustomerID(customerID);
            customerOrder.setOrderDate(orderDate);

            boolean success = dataAccess.saveCustomerOrder(customerOrder);
            if (success == true) {
                JOptionPane.showMessageDialog(customerOrderView, "Order added successfully.");
            } else {
                JOptionPane.showMessageDialog(customerOrderView, "Failed to add order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(customerOrderView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void updateOrder()
    {
        try {
            int orderID = Integer.parseInt(customerOrderView.getTxtOrderID().getText());
            int customerID = Integer.parseInt(customerOrderView.getTxtCustomerID().getText());
            String orderDate = customerOrderView.getTxtOrderDate().getText();

            Customer_Order customerOrder = new Customer_Order();
            customerOrder.setOrderID(orderID);
            customerOrder.setCustomerID(customerID);
            customerOrder.setOrderDate(orderDate);

            boolean success = dataAccess.saveCustomerOrder(customerOrder);
            if (success == true) {
                JOptionPane.showMessageDialog(customerOrderView, "Order updated successfully.");
            } else {
                JOptionPane.showMessageDialog(customerOrderView, "Failed to update order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(customerOrderView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
