package model.entities.services;

import model.entities.Contract;
import model.entities.Installment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);

            contract.getInstallments().add(new Installment(dueDate, basicQuota + interest + fee, contract));
        }
    }
}
