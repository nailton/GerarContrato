package application;

import model.entities.Contract;
import model.entities.Installment;
import model.entities.services.ContractService;
import model.entities.services.OnlinePaymentService;
import model.entities.services.PaypalService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Número: ");
        int number = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        Date date = df.parse(sc.next());

        System.out.print("Valor do contrato: ");
        double value = sc.nextDouble();

        System.out.print("Entre com o número de parcelas: ");
        int installments = sc.nextInt();

        Contract contract = new Contract(number, date, value);
        ContractService service = new ContractService();

        System.out.println("Parcelas: ");
        service.processContract(contract, installments, new PaypalService());
    }

}