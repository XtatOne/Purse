package Purse;

import Purse.AllDocuments.Arrival;
import Purse.AllDocuments.Document;
import Purse.AllDocuments.Spending;
import Purse.SupportClasses.ActionType;
import Purse.SupportClasses.Contragent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static List<Document>   balance      = new ArrayList<>();
    private static Set<Contragent>  contragents  = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader   = new BufferedReader(new InputStreamReader(System.in));
        boolean exit            = false;
        int sum;

        while (!exit) {

            System.out.println("Выберете действие:\n1. Поступление 2. Списание 3. Баланс 4. Выход");

            String action = reader.readLine();

            switch (action) {

                case "1":

                    System.out.println("Укажите наименование плательщика - ");
                    String payerName = reader.readLine();

                    System.out.println("Введите сумму операции - ");
                    sum = Integer.parseInt(reader.readLine());

                    addArrival(payerName, sum);
                    break;

                case "2":

                    System.out.println("Укажите получателя получателя - ");
                    String recipientName = reader.readLine();

                    System.out.println("Введите сумму операции - ");
                    sum = Integer.parseInt(reader.readLine());

                    if (calculateBalance() - sum < 0) {
                        System.out.println("У Вас недостаточно денег на счету для данной операции!");
                    } else {
                        addSpending(recipientName, sum);
                    }

                    break;

                case "3":

                    System.out.println("Выберете действие: \n1. Показать все поступления 2. Показать все списания 3. Показать текущий баланс.");

                    String balanceAction = reader.readLine();

                    switch (balanceAction) {

                        case "1":
                            showAllSpecificDocuments(ActionType.ARRIVAL);
                            break;
                        case "2":
                            showAllSpecificDocuments(ActionType.SPENDING);
                            break;
                        case "3":
                            showBalance();
                            break;
                        default:
                            System.out.println("Выбранно некорретное действие. Попробуйте еще раз.");
                            break;

                    }

                    break;

                case "4":

                    System.out.println("До свидания!");
                    exit = true;
                    break;

                default:
                    System.out.println("Выбранно некорретное действие. Попробуйте еще раз.");
                    break;
            }

        }

        reader.close();

    }

    private static void addArrival(String payerName, int sum) {

        if (!(payerName.isEmpty())) {

            Contragent payer = checkContragent(payerName);

            if (payer != null) {
                balance.add(new Arrival(ActionType.ARRIVAL, payer, sum));
            } else {

                Contragent newPayer = new Contragent(payerName);
                contragents.add(newPayer);
                balance.add(new Arrival(ActionType.ARRIVAL, newPayer, sum));

            }

            System.out.println("Поступление успешно добавлено!");

        } else {
            System.out.println("У плательщика должно быть наименование!");
        }

    }

    private static void addSpending(String recipientName, int sum) {

        if (!(recipientName.isEmpty())) {

            Contragent recipient = checkContragent(recipientName);

            if (recipient != null) {
                balance.add(new Spending(ActionType.SPENDING, recipient, sum));
            } else {

                Contragent newRecipient = new Contragent(recipientName);
                contragents.add(newRecipient);
                balance.add(new Spending(ActionType.SPENDING, newRecipient, sum));

            }

            System.out.println("Списание успешно добавлено!");

        } else {
            System.out.println("У получателя должно быть наименование!");
        }

    }

    private static Contragent checkContragent(String checkName) {

        return  contragents.stream()
                    .filter(contragent -> contragent.getName().equals(checkName))
                    .findFirst()
                    .orElse(null);

    }

    private static void showAllSpecificDocuments(ActionType type) {

        balance.stream().filter((element -> element.getType().equals(type)))
                .sorted()
                .forEach((element) -> System.out.println(element));
    }


    private static void showBalance() {

        int amount;

        if (!balance.isEmpty()) {

            amount = calculateBalance();
            System.out.println("Ваш баланс - " + amount);

        } else System.out.println("Ваш баланс - 0");

    }

    private static int calculateBalance() {

        int arrivalSum;
        int spendingSum;

        arrivalSum = balance.stream().filter(doc -> doc.getType()
                            .equals(ActionType.ARRIVAL))
                            .mapToInt(Document::getSum)
                            .sum();

        spendingSum = balance.stream().filter(doc -> doc.getType()
                            .equals(ActionType.SPENDING))
                            .mapToInt(Document::getSum)
                            .sum();

        return arrivalSum - spendingSum;

    }
}
