public class Supplier {
    private int supplierID;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName()
    {
        return supplierName;
    }

    public void setSupplierAddress(String supplierAddress)
    {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierAddress()
    {
        return supplierAddress;
    }

    public void setSupplierPhone(String supplierPhone)
    {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierPhone()
    {
        return supplierPhone;
    }

    public String toString()
    {
        return "SupplierID: " + supplierID + "\n Supplier's Name: " + supplierName + "\n Supplier's Address: "
                + supplierAddress + "\n Supplier's Phone Number: " + supplierPhone;
    }
}
