public class Customer_Order {
    private int orderID;
    private int customerID;
    private String orderDate;

    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    public int getOrderID()
    {
        return orderID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public int getCustomerID()
    {
        return customerID;
    }

    public void setOrderDate(String orderDate)
    {
        this.orderDate = orderDate;
    }

    public String getOrderDate()
    {
        return orderDate;
    }

    public String toString()
    {
        return "Order ID: " + orderID + "\n Customer ID: " + customerID + "\n Order Date: " + orderDate;
    }

}
