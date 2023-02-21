package model.entities.services;

import model.entities.Contract;

public class ContractService {
    private Contract contract;
    private Integer months;

    private OnlinePaymentService onlinePaymentService;

    public ContractService(Contract contract, Integer months, OnlinePaymentService onlinePaymentService) {
        this.contract = contract;
        this.months = months;
        this.onlinePaymentService = onlinePaymentService;
    }
}
