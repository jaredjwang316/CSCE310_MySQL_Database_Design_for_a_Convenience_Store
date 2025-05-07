import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Order_Details_Controller implements ActionListener {
    private Order_Details_View orderDetailsView;
    private DataAccess dataAccess;

    public Order_Details_Controller(Order_Details_View orderDetailsView, DataAccess dataAccess) {
        this.orderDetailsView = orderDetailsView;
        this.dataAccess = dataAccess;

        this.orderDetailsView.getBtnAddOrderDetails().addActionListener(this);
        this.orderDetailsView.getBtnUpdateOrderDetails().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderDetailsView.getBtnAddOrderDetails()) {
            addOrderDetails();
        } else if (e.getSource() == orderDetailsView.getBtnUpdateOrderDetails()) {
            updateOrderDetails();
        }
    }

    public void addOrderDetails() {
        try {
            int orderID = Integer.parseInt(orderDetailsView.getTxtOrderID().getText());
            int productID = Integer.parseInt(orderDetailsView.getTxtProductID().getText());
            int quantity = Integer.parseInt(orderDetailsView.getTxtQuantity().getText());

            Order_Details orderDetails = new Order_Details();
            orderDetails.setOrderID(orderID);
            orderDetails.setProductID(productID);
            orderDetails.setQuantity(quantity);

            boolean success = dataAccess.saveOrderDetails(orderDetails);
            if (success == true) {
                JOptionPane.showMessageDialog(orderDetailsView, "Order Details added successfully.");
            } else {
                JOptionPane.showMessageDialog(orderDetailsView, "Failed to add order details.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(orderDetailsView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateOrderDetails() {
        try {
            int orderID = Integer.parseInt(orderDetailsView.getTxtOrderID().getText());
            int productID = Integer.parseInt(orderDetailsView.getTxtProductID().getText());
            int quantity = Integer.parseInt(orderDetailsView.getTxtQuantity().getText());

            Order_Details orderDetails = new Order_Details();
            orderDetails.setOrderID(orderID);
            orderDetails.setProductID(productID);
            orderDetails.setQuantity(quantity);

            boolean success = dataAccess.saveOrderDetails(orderDetails);
            if (success == true) {
                JOptionPane.showMessageDialog(orderDetailsView, "Order Details updated successfully.");
            } else {
                JOptionPane.showMessageDialog(orderDetailsView, "Failed to update order details.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(orderDetailsView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
