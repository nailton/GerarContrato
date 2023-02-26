package model.entities.services;

import model.entities.Contract;
import model.entities.Installment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ContractService {
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void processContract(Contract contract, Integer months, OnlinePaymentService onlinePaymentService) {
        double amount = contract.getTotalValue() / months;
        Date currentDate = contract.getDate();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);


        for (int i = 0; i < months; i++) {
            c.add(Calendar.MONTH, 1);
            Date dueDate = c.getTime();

            double interest = onlinePaymentService.interest(amount, i + 1);
            double fee = onlinePaymentService.paymentFee(amount + interest);

            Installment installment = new Installment(dueDate, amount + interest + fee, contract);
            System.out.println(dateFormat.format(installment.getDueDate()) + " - " + String.format("%.2f", installment.getAmount()));
        }
    }
}
