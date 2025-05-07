public class Customer {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerAddress(String customerAddress)
    {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAddress()
    {
        return customerAddress;
    }

    public void setCustomerPhone(String customerPhone)
    {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPhone()

    {
        return customerPhone;
    }

    public String toString()
    {
        return "Customer's ID: " + customerID + "\n Customer's Name: " + customerName + "\n Customer's Address: "
                + customerAddress + "\n Customer's Phone Number: " + customerPhone;
    }
}
