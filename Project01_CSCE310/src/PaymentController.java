import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentController implements ActionListener {
    private PaymentView paymentView;
    private DataAccess dataAccess;

    public PaymentController(PaymentView paymentView, DataAccess dataAccess)
    {
        this.paymentView = paymentView;
        this.dataAccess = dataAccess;

        this.paymentView.getBtnAddPayment().addActionListener(this);
        this.paymentView.getBtnUpdatePayment().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == paymentView.getBtnAddPayment())
        {
            addPayment();
        }
        else if (e.getSource() == paymentView.getBtnUpdatePayment())
        {
            updatePayment();
        }
    }

    public void addPayment()
    {
        try {
            int payID = Integer.parseInt(paymentView.getTxtPayID().getText());
            String cardNumber = paymentView.getTxtCardNumber().getText();
            String cardHolder = paymentView.getTxtCardHolder().getText();
            String expirationDate = paymentView.getTxtExpirationDate().getText();
            String CVV = paymentView.getTxtCVV().getText();
            double paymentAmount = Double.parseDouble(paymentView.getTxtPaymentAmount().getText());

            Payment payment = new Payment();
            payment.setPayID(payID);
            payment.setCardNumber(cardNumber);
            payment.setCardHolder(cardHolder);
            payment.setExpirationDate(expirationDate);
            payment.setCVVNumber(CVV);
            payment.setPaymentAmount(paymentAmount);

            boolean success = dataAccess.savePayments(payment);
            if (success == true) {
                JOptionPane.showMessageDialog(paymentView, "Payment added successfully.");
            } else {
                JOptionPane.showMessageDialog(paymentView, "Failed to add payment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(paymentView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePayment()
    {
        try {
            int payID = Integer.parseInt(paymentView.getTxtPayID().getText());
            String cardNumber = paymentView.getTxtCardNumber().getText();
            String cardHolder = paymentView.getTxtCardHolder().getText();
            String expirationDate = paymentView.getTxtExpirationDate().getText();
            String CVV = paymentView.getTxtCVV().getText();
            double paymentAmount = Double.parseDouble(paymentView.getTxtPaymentAmount().getText());

            Payment payment = new Payment();
            payment.setPayID(payID);
            payment.setCardNumber(cardNumber);
            payment.setCardHolder(cardHolder);
            payment.setExpirationDate(expirationDate);
            payment.setCVVNumber(CVV);
            payment.setPaymentAmount(paymentAmount);

            boolean success = dataAccess.savePayments(payment);
            if (success == true) {
                JOptionPane.showMessageDialog(paymentView, "Payment updated successfully.");
            } else {
                JOptionPane.showMessageDialog(paymentView, "Failed to update payment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException n)
        {
            JOptionPane.showMessageDialog(paymentView, "Invalid input.  Please provide valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
