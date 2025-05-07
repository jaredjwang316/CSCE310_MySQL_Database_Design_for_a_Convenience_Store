import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class Application {
    private static Application instance;
    // Method to test database connectivity by executing a simple query

    public static Application getInstance()
    {
        if(instance == null)
            instance = new Application();
        return instance;
    }

    private Connection connection;
    private DataAccess dataAccess;
    private SalesReportGenerator reportGenerator;


    //view variables
    private SupplierView supplierView = new SupplierView();

    private ProductView productView = new ProductView();

    private CustomerView customerView = new CustomerView();

    private PaymentView paymentView = new PaymentView();

    private Customer_Order_View customerOrderView = new Customer_Order_View();

    private Order_Details_View orderDetailsView = new Order_Details_View();

    //controller variables

    private SupplierController supplierController;
    private ProductController productController;
    private CustomerController customerController;
    private Customer_Order_Controller customerOrderController;
    private Order_Details_Controller orderDetailsController;
    private PaymentController paymentController;


    public SupplierView getSupplierView()
    {
        return supplierView;
    }

    public ProductView getProductView()
    {
        return productView;
    }

    public CustomerView getCustomerView()
    {
        return customerView;
    }


    public Customer_Order_View getCustomerOrderView()
    {
        return customerOrderView;
    }

    public Order_Details_View getOrderDetailsView()
    {
        return orderDetailsView;
    }

    public PaymentView getPaymentView()
    {
        return paymentView;
    }

    public SupplierController getSupplierController()
    {
        return supplierController;
    }

    public ProductController getProductController() {
        return productController;
    }

    public CustomerController getCustomerController()
    {
        return customerController;
    }

    public Customer_Order_Controller getCustomerOrderController() {
        return customerOrderController;
    }

    public Order_Details_Controller getOrderDetailsController()
    {
        return orderDetailsController;
    }

    public PaymentController getPaymentController()
    {
        return paymentController;
    }

    private Application()
    {
        //try to create database connection and check if connection successfully created
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project01_store_management_system";
            String username = "root";
            String password = "Pwd_f0r_me";
            connection = DriverManager.getConnection(url, username, password);

            dataAccess = new DataAccess(connection);

            // Initialize SalesReportGenerator
            reportGenerator = new SalesReportGenerator(connection);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        supplierController = new SupplierController(supplierView, dataAccess);
        productController = new ProductController(productView, dataAccess);
        customerController = new CustomerController(customerView, dataAccess);
        customerOrderController = new Customer_Order_Controller(customerOrderView, dataAccess);
        orderDetailsController = new Order_Details_Controller(orderDetailsView, dataAccess);
        paymentController = new PaymentController(paymentView, dataAccess);
    }

    public DataAccess getDataAccess()
    {
        return dataAccess;
    }

    public SalesReportGenerator getReportGenerator() {
        return reportGenerator;
    }

    public static void main(String[] args) {
        // Start your application here
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame mainWindow = new JFrame("Main Window for Store Management System");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(new FlowLayout());

        JButton supplyButton = new JButton("Manage Suppliers");
        JButton productButton = new JButton("Manage Products");
        JButton customerButton = new JButton("Manage Customers");
        JButton orderButton = new JButton("Manage Orders");
        JButton orderDetailButton = new JButton("View Order Details");
        JButton paymentButton = new JButton("Manage Payments");


        mainWindow.add(supplyButton);
        mainWindow.add(productButton);
        mainWindow.add(customerButton);
        mainWindow.add(orderButton);
        mainWindow.add(orderDetailButton);
        mainWindow.add(paymentButton);

        supplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getSupplierView().setVisible(true);
            }
        });

        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProductView().setVisible(true);
            }
        });

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getCustomerView().setVisible(true);
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getCustomerOrderView().setVisible(true);
            }
        });

        orderDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getOrderDetailsView().setVisible(true);
            }
        });

        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getPaymentView().setVisible(true);
            }
        });

        // Add buttons for generating sales reports
        JButton monthlyReportButton = new JButton("Generate Monthly Sales Report");
        JButton productReportButton = new JButton("Generate Product Sales Report");
        JButton customerReportButton = new JButton("Generate Customer Sales Report");

        // ActionListener for generating monthly sales report
        monthlyReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an array of labels and text fields for user input
                JLabel[] labels = {
                        new JLabel("Enter start date (yyyy-MM-dd):"),
                        new JLabel("Enter end date (yyyy-MM-dd):"),
                        new JLabel("Sort by total sale in descending order:"),
                        new JLabel("Enter the number of top sales to display:"),
                        new JLabel("Enter file name (including extension):")
                };
                JTextField[] fields = {
                        new JTextField(),
                        new JTextField()
                };
                String[] sortingOptions = {"Yes", "No"};
                JComboBox<String> sortingComboBox = new JComboBox<>(sortingOptions);
                sortingComboBox.setSelectedIndex(-1); // Initially no item selected

                JTextField limitField = new JTextField(); // Field for entering the limit
                JTextField fileNameField = new JTextField();


                // Create an array of objects to hold the components
                Object[] components = {
                        labels[0], fields[0],
                        labels[1], fields[1],
                        labels[2], sortingComboBox,
                        labels[3], limitField,
                        labels[4], fileNameField
                };

                // Show the input dialog
                int result = JOptionPane.showConfirmDialog(null, components, "Generate Monthly Sales Report", JOptionPane.OK_CANCEL_OPTION);

                // If OK button is clicked, process the input
                if (result == JOptionPane.OK_OPTION) {
                    String startDateStr = fields[0].getText();
                    String endDateStr = fields[1].getText();
                    boolean descending = true;
                    int limit = 0;

                    // Get the selected sorting option from the sortingComboBox
                    String sortingOption = (String) sortingComboBox.getSelectedItem();
                    if (sortingOption.equals("Yes"))
                        descending = true;
                    else if (sortingOption.equals("No"))
                        descending = false;


                    // Get the entered limit value
                    try {
                        limit = Integer.parseInt(limitField.getText());
                        // Check if the limit is greater than 0
                        if (limit <= 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a limit greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        // If the entered limit is not a valid integer, show an error message
                        JOptionPane.showMessageDialog(null, "Please enter a valid limit.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String fileName = fileNameField.getText();

                    // Generate and save the monthly sales report
                    Application.getInstance().reportGenerator.generateAndSaveMonthlySalesReport(startDateStr, endDateStr, descending, limit, fileName);
                }
            }
        });

        productReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an array of labels and text fields for user input
                JLabel[] labels = {
                        new JLabel("Enter start date (yyyy-MM-dd):"),
                        new JLabel("Enter end date (yyyy-MM-dd):"),
                        new JLabel("Sort by total sale in descending order:"),
                        new JLabel("Enter the number of top sales to display:"),
                        new JLabel("Enter file name (including extension):")
                };
                JTextField[] fields = {
                        new JTextField(),
                        new JTextField()
                };
                String[] sortingOptions = {"Yes", "No"};
                JComboBox<String> sortingComboBox = new JComboBox<>(sortingOptions);
                sortingComboBox.setSelectedIndex(-1); // Initially no item selected

                JTextField limitField = new JTextField(); // Field for entering the limit
                JTextField fileNameField = new JTextField();


                // Create an array of objects to hold the components
                Object[] components = {
                        labels[0], fields[0],
                        labels[1], fields[1],
                        labels[2], sortingComboBox,
                        labels[3], limitField,
                        labels[4], fileNameField
                };

                int result = JOptionPane.showConfirmDialog(null, components, "Generate Product Sales Report", JOptionPane.OK_CANCEL_OPTION);

                // If OK button is clicked, process the input
                if (result == JOptionPane.OK_OPTION) {
                    String startDateStr = fields[0].getText();
                    String endDateStr = fields[1].getText();
                    boolean descending = true;
                    int limit = 0;

                    // Get the selected sorting option from the sortingComboBox
                    String sortingOption = (String) sortingComboBox.getSelectedItem();
                    if (sortingOption.equals("Yes"))
                        descending = true;
                    else if (sortingOption.equals("No"))
                        descending = false;


                    // Get the entered limit value
                    try {
                        limit = Integer.parseInt(limitField.getText());
                        // Check if the limit is greater than 0
                        if (limit <= 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a limit greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                            return; // Exit the method
                        }
                    } catch (NumberFormatException ex) {
                        // If the entered limit is not a valid integer, show an error message
                        JOptionPane.showMessageDialog(null, "Please enter a valid limit.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method
                    }

                    String fileName = fileNameField.getText();

                    Application.getInstance().reportGenerator.generateAndSaveProductSalesReport(startDateStr, endDateStr, descending, limit, fileName);
                }
            }
        });

        customerReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an array of labels and text fields for user input
                JLabel[] labels = {
                        new JLabel("Enter start date (yyyy-MM-dd):"),
                        new JLabel("Enter end date (yyyy-MM-dd):"),
                        new JLabel("Sort by total sale in descending order:"),
                        new JLabel("Enter the number of top sales to display:"),
                        new JLabel("Enter file name (including extension):")
                };
                JTextField[] fields = {
                        new JTextField(),
                        new JTextField()
                };
                String[] sortingOptions = {"Yes", "No"};
                JComboBox<String> sortingComboBox = new JComboBox<>(sortingOptions);
                sortingComboBox.setSelectedIndex(-1); // Initially no item selected

                JTextField limitField = new JTextField(); // Field for entering the limit
                JTextField fileNameField = new JTextField();


                // Create an array of objects to hold the components
                Object[] components = {
                        labels[0], fields[0],
                        labels[1], fields[1],
                        labels[2], sortingComboBox,
                        labels[3], limitField,
                        labels[4], fileNameField
                };


                int result = JOptionPane.showConfirmDialog(null, components, "Generate Customer Sales Report", JOptionPane.OK_CANCEL_OPTION);

                // If OK button is clicked, process the input
                if (result == JOptionPane.OK_OPTION) {
                    String startDateStr = fields[0].getText();
                    String endDateStr = fields[1].getText();
                    boolean descending = true;
                    int limit = 0;

                    // Get the selected sorting option from the sortingComboBox
                    String sortingOption = (String) sortingComboBox.getSelectedItem();
                    if (sortingOption.equals("Yes"))
                        descending = true;
                    else if (sortingOption.equals("No"))
                        descending = false;


                    // Get the entered limit value
                    try {
                        limit = Integer.parseInt(limitField.getText());
                        // Check if the limit is greater than 0
                        if (limit <= 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a limit greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                            return; // Exit the method
                        }
                    } catch (NumberFormatException ex) {
                        // If the entered limit is not a valid integer, show an error message
                        JOptionPane.showMessageDialog(null, "Please enter a valid limit.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method
                    }

                    String fileName = fileNameField.getText();


                    Application.getInstance().reportGenerator.generateAndSaveCustomerSalesReport(startDateStr, endDateStr, descending, limit, fileName);
                }
            }
        });


        mainWindow.add(monthlyReportButton);
        mainWindow.add(productReportButton);
        mainWindow.add(customerReportButton);


        mainWindow.setSize(600, 300);
        mainWindow.setVisible(true);
    }
}