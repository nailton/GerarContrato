package model.entities.services;

import model.entities.Contract;
import model.entities.Installment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class ContractService {
    private Contract contract;
    private Integer months;

    private OnlinePaymentService onlinePaymentService;
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void processContract(Contract contract, Integer months, OnlinePaymentService onlinePaymentService) {
        double amountDue = contract.getTotalValue() / months;
        Date currentDate = contract.getDate();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        for (int i = 0; i < months; i++) {
            c.add(Calendar.MONTH, 1);
            Date addMonth = c.getTime();
            System.out.println(dateFormat.format(addMonth) + " - " + String.format("%.2f", amountDue));
        }
    }
}
