public class Product {
    private int productID;
    private int supplierID;
    private String productName;
    private double retailPrice;


    public void setProductID(int productID)
    {
        this.productID = productID;
    }

    public int getProductID()
    {
        return productID;
    }

    public void setSupplierID(int supplierID)
    {
        this.supplierID = supplierID;
    }

    public int getSupplierID()
    {
        return supplierID;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setRetailPrice(double retailPrice)
    {
        this.retailPrice = retailPrice;
    }

    public double getRetailPrice()
    {
        return retailPrice;
    }

    public String toString()
    {
        return "Product ID: " + productID + "\n Corresponding Supplier's ID: " + supplierID + "\n Product Name: " +
                productName + "\n Price: " + retailPrice;
    }
}
