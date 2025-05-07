import java.io.IOException;
import java.sql.*;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class SalesReportGenerator {

    private Connection connection;

    public SalesReportGenerator(Connection connection)
    {
        this.connection = connection;
    }

    public void generateAndSaveMonthlySalesReport(String startDate, String endDate, boolean descending, int limit, String fileName)
    {
        String orderByClause = "";
        if (descending == true) {
            orderByClause = "ORDER BY TotalSale DESC ";
        }

        String limitClause = "";
        if (limit > 0) {
            limitClause = "LIMIT " + limit + " ";
        }

        String query = "SELECT DATE_FORMAT(OrderDate, '%Y-%m') AS Month, SUM(RetailPrice * Quantity) AS TotalSale " +
                "FROM CUST_ORDER JOIN ORDER_DETAIL ON CUST_ORDER.OrderID = ORDER_DETAIL.OrderID " +
                "JOIN PRODUCT ON ORDER_DETAIL.ProductID = PRODUCT.ProductID " +
                "WHERE OrderDate BETWEEN '" + startDate + "' AND '" + endDate + "' " +
                "GROUP BY Month " + orderByClause + limitClause;

        executeAndSaveReport(query, fileName);
    }

    public void generateAndSaveProductSalesReport(String startDate, String endDate, boolean descending, int limit, String fileName)
    {
        String orderByClause = "";
        if (descending == true) {
            orderByClause = "ORDER BY TotalSale DESC ";
        }

        String limitClause = "";
        if (limit > 0) {
            limitClause = "LIMIT " + limit + " ";
        }

        String query = "SELECT p.ProductName, SUM(od.Quantity * p.RetailPrice) AS TotalSale " +
                "FROM PRODUCT p JOIN ORDER_DETAIL od ON p.ProductID = od.ProductID " +
                "JOIN CUST_ORDER co ON od.OrderID = co.OrderID WHERE co.OrderDate BETWEEN '"
                + startDate + "' AND '" + endDate + "' " + "GROUP BY p.ProductName " + orderByClause
                + " " + limitClause;
        executeAndSaveReport(query, fileName);
    }

    public void generateAndSaveCustomerSalesReport(String startDate, String endDate, boolean descending, int limit, String fileName) {
        // Construct the ORDER BY clause based on the descending parameter
        String orderByClause = "";
        if (descending == true) {
            orderByClause = "ORDER BY TotalSale DESC ";
        }

        String limitClause = "";
        if (limit > 0) {
            limitClause = "LIMIT " + limit + " ";
        }

        // Construct the SQL query to calculate total sales per customer
        String query = "SELECT c.CustomerName, SUM(od.Quantity * p.RetailPrice) AS TotalSale " +
                "FROM CUSTOMER c JOIN CUST_ORDER co ON c.CustomerID = co.CustomerID " +
                "JOIN ORDER_DETAIL od ON co.OrderID = od.OrderID " +
                "JOIN PRODUCT p ON od.ProductID = p.ProductID " +
                "WHERE co.OrderDate BETWEEN '" + startDate + "' AND '" + endDate + "' " +
                "GROUP BY c.CustomerName " + orderByClause + limitClause;

        // Execute the query and save the report to the specified file
        executeAndSaveReport(query, fileName);
    }

    private void executeAndSaveReport(String query, String fileName) {
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            try {
                List<String> reportLines = new ArrayList<>();
                while (resultSet.next()) {
                    String row = resultSet.getString(1) + " : " + resultSet.getString(2) + "\n";
                    reportLines.add(row);
                }
                Collections.sort(reportLines); // Sort the report lines
                FileWriter fileWriter = new FileWriter(fileName);
                for (String line : reportLines) {
                    fileWriter.write(line);
                }
                System.out.println("Sales report generated and saved as " + fileName);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
