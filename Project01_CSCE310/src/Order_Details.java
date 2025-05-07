public class Order_Details {
    private int orderID;
    private int productID;
    private int quantity;

    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    public int getOrderID()
    {
        return orderID;
    }

    public void setProductID(int productID)
    {
        this.productID = productID;
    }

    public int getProductID()
    {
        return productID;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String toString()
    {
        return "OrderID: " + orderID + "\n ProductID: " + productID + "\n Quantity Ordered: " + quantity;
    }
}
