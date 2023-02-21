package model.entities.services;

public class PaypalService implements OnlinePaymentService {
    private Double amount;
    private Integer months;

    public Double paymentFee(Double amount) {
        return amount;
    }

    public Double interest(Double amount, Integer months) {
        return amount;
    }
}
