import java.sql.*;


public class DataAccess {
    private Connection connection;

    public DataAccess(Connection connection)
    {
        this.connection = connection;
    }

    public boolean saveSupplier(Supplier supplier)
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Supplier WHERE SupplierID = ?");
            statement.setInt(1, supplier.getSupplierID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())   //if the supplier exists, just update its fields
            {
                statement = connection.prepareStatement(
                        "UPDATE Supplier SET SupplierName = ?, SupplierAddress = ?, SupplierPhone = ? WHERE SupplierID = ?");
                statement.setString(1, supplier.getSupplierName());
                statement.setString(2, supplier.getSupplierAddress());
                statement.setString(3, supplier.getSupplierPhone());
                statement.setInt(4, supplier.getSupplierID());

            }
            else    //we create a supplier and insert it into the Supplier table
            {
                statement = connection.prepareStatement(
                        "INSERT INTO Supplier(SupplierID, SupplierName, SupplierAddress, SupplierPhone) VALUES (?, ?, ?, ?)");
                statement.setInt(1, supplier.getSupplierID());
                statement.setString(2, supplier.getSupplierName());
                statement.setString(3, supplier.getSupplierAddress());
                statement.setString(4, supplier.getSupplierPhone());
            }
            statement.execute();
            resultSet.close();
            statement.close();
        }
        catch (SQLException e)
        {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;   //cannot save!
        }
        return true;
    }

    public boolean saveProduct(Product product)
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
            statement.setInt(1, product.getProductID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())   //if the product exists, just update its fields
            {
                statement = connection.prepareStatement(
                        "UPDATE Product SET SupplierID = ?, ProductName = ?, RetailPrice = ? WHERE ProductID = ?");
                statement.setInt(1, product.getSupplierID());
                statement.setString(2, product.getProductName());
                statement.setDouble(3, product.getRetailPrice());
                statement.setInt(4, product.getProductID());

            }
            else    //we create a product and insert it into the Product table
            {
                statement = connection.prepareStatement(
                        "INSERT INTO Product(ProductID, SupplierID, ProductName, RetailPrice) VALUES (?, ?, ?, ?)");
                statement.setInt(1, product.getProductID());
                statement.setInt(2, product.getSupplierID());
                statement.setString(3, product.getProductName());
                statement.setDouble(4, product.getRetailPrice());
            }
            statement.execute();
            resultSet.close();
            statement.close();
        }
        catch (SQLException e)
        {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;   //cannot save!
        }
        return true;
    }

    public boolean saveCustomer(Customer customer)
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customer WHERE CustomerID = ?");
            statement.setInt(1, customer.getCustomerID());

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                statement = connection.prepareStatement(
                        "UPDATE Customer SET CustomerName = ?, CustomerPhone = ?, CustomerAddress = ? WHERE CustomerID = ?");
                statement.setString(1, customer.getCustomerName());
                statement.setString(2, customer.getCustomerPhone());
                statement.setString(3, customer.getCustomerAddress());
                statement.setInt(4, customer.getCustomerID());
            }
            else
            {
                statement = connection.prepareStatement(
                        "INSERT INTO Customer(CustomerID, CustomerName, customerPhone, customerAddress) VALUES (?, ?, ?, ?)");
                statement.setInt(1, customer.getCustomerID());
                statement.setString(2, customer.getCustomerName());
                statement.setString(3, customer.getCustomerPhone());
                statement.setString(4, customer.getCustomerAddress());
            }
            statement.execute();
            resultSet.close();
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database Access Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveCustomerOrder(Customer_Order customerOrder) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Cust_Order WHERE OrderID = ?");
            statement.setInt(1, customerOrder.getOrderID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                statement = connection.prepareStatement(
                        "UPDATE Cust_Order SET CustomerID = ?, OrderDate = ? WHERE OrderID = ?");
                statement.setInt(1, customerOrder.getCustomerID());
                statement.setString(2, customerOrder.getOrderDate());
                statement.setInt(3, customerOrder.getOrderID());
            }
            else
            {
                statement = connection.prepareStatement(
                        "INSERT INTO Cust_Order(OrderID, CustomerID, OrderDate) VALUES(?, ?, ?)");
                statement.setInt(1, customerOrder.getOrderID());
                statement.setInt(2, customerOrder.getCustomerID());
                statement.setString(3, customerOrder.getOrderDate());
            }
            statement.execute();
            resultSet.close();
            statement.close();
        }
        catch (SQLException e)
        {
            System.out.println("Database Access Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveOrderDetails(Order_Details orderDetails)
    {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM ORDER_DETAIL Where OrderID = ? AND ProductID = ?");
            statement.setInt(1, orderDetails.getOrderID());
            statement.setInt(2, orderDetails.getProductID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                statement = connection.prepareStatement(
                        "UPDATE Order_Detail SET Quantity = ? WHERE OrderID = ? AND ProductID = ?");
                statement.setInt(1, orderDetails.getQuantity());
                statement.setInt(2, orderDetails.getOrderID());
                statement.setInt(3, orderDetails.getProductID());
            }
            else
            {
                statement = connection.prepareStatement(
                        "INSERT INTO Order_Detail(OrderID, ProductID, Quantity) Values (?, ?, ?)");
                statement.setInt(1, orderDetails.getOrderID());
                statement.setInt(2, orderDetails.getProductID());
                statement.setInt(3, orderDetails.getQuantity());
            }
            statement.execute();
            resultSet.close();
            statement.close();
        }
        catch (SQLException e)
        {
            System.out.println("Database Access error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean savePayments(Payment payment)
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Payment WHERE PayID = ?");
            statement.setInt(1, payment.getPayID());

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                statement = connection.prepareStatement("UPDATE Payment SET CardNumber = ?, CardHolder = ?, " +
                        "ExpiryDate = ?, CVV = ?, Amount = ? WHERE PayID = ?");
                statement.setString(1, payment.getCardNumber());
                statement.setString(2, payment.getCardHolder());
                statement.setString(3, payment.getExpirationDate());
                statement.setString(4, payment.getCVVNumber());
                statement.setDouble(5, payment.getPaymentAmount());
                statement.setInt(6, payment.getPayID());
            }
            else
            {
                statement = connection.prepareStatement("INSERT INTO Payment(PayID, CardNumber, CardHolder, " +
                        "ExpiryDate, CVV, Amount) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setInt(1, payment.getPayID());
                statement.setString(2, payment.getCardNumber());
                statement.setString(3, payment.getCardHolder());
                statement.setString(4, payment.getExpirationDate());
                statement.setString(5, payment.getCVVNumber());
                statement.setDouble(6, payment.getPaymentAmount());

            }
            statement.execute();
            resultSet.close();
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database Access Error!");
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
