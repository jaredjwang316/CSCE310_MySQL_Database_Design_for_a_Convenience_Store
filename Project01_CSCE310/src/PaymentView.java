import javax.swing.*;


public class PaymentView extends JFrame {
    JTextField txtPayID = new JTextField(10);
    JTextField txtCardNumber = new JTextField(20);
    JTextField txtCardHolder = new JTextField(30);
    JTextField txtExpirationDate = new JTextField(15);
    JTextField txtCVV = new JTextField(7);
    JTextField txtPaymentAmount = new JTextField(15);

    JButton btnAddPayment = new JButton("Add a payment");
    JButton btnUpdatePayment = new JButton("Update a payment");

    public PaymentView()
    {
        this.setTitle("Manage payment");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(1250, 250);

        JPanel panelButton = new JPanel();
        panelButton.add(btnAddPayment);
        panelButton.add(btnUpdatePayment);
        this.getContentPane().add(panelButton);

        JPanel panelPayID = new JPanel();
        panelPayID.add(new JLabel("Pay ID: "));
        panelPayID.add(txtPayID);
        this.getContentPane().add(panelPayID);

        JPanel panelCardNumber = new JPanel();
        panelCardNumber.add(new JLabel("Card Number: "));
        panelCardNumber.add(txtCardNumber);
        this.getContentPane().add(panelCardNumber);

        JPanel panelCardHolder = new JPanel();
        panelCardHolder.add(new JLabel("Card Holder: "));
        panelCardHolder.add(txtCardHolder);
        this.getContentPane().add(panelCardHolder);

        JPanel panelExpirationDate = new JPanel();
        panelExpirationDate.add(new JLabel("Card Expiration Date: "));
        panelExpirationDate.add(txtExpirationDate);
        this.getContentPane().add(panelExpirationDate);

        JPanel panelCVV = new JPanel();
        panelCVV.add(new JLabel("Card CVV: "));
        panelCVV.add(txtCVV);
        this.getContentPane().add(panelCVV);

        JPanel panelPaymentAmount = new JPanel();
        panelPaymentAmount.add(new JLabel("Payment Amount: "));
        panelPaymentAmount.add(txtPaymentAmount);
        this.getContentPane().add(panelPaymentAmount);
    }

    public JButton getBtnAddPayment()
    {
        return btnAddPayment;
    }

    public JButton getBtnUpdatePayment()
    {
        return btnUpdatePayment;
    }

    public JTextField getTxtPayID()
    {
        return txtPayID;
    }

    public JTextField getTxtCardNumber()
    {
        return txtCardNumber;
    }

    public JTextField getTxtCardHolder()
    {
        return txtCardHolder;
    }

    public JTextField getTxtExpirationDate()
    {
        return txtExpirationDate;
    }

    public JTextField getTxtCVV()
    {
        return txtCVV;
    }

    public JTextField getTxtPaymentAmount()
    {
        return txtPaymentAmount;
    }

}
