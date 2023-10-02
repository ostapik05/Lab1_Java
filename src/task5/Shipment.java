package task5;

import java.util.Scanner;

public class Shipment {
    private static final int MAX_ITEMS = 15;
    private Item[] items;
    private Customer sender, receiver;
    private DeparturePoint departure;
    private ReceivePoint receive;
    private double maxWeight;
    private double totalWeight;

    public Shipment(final Customer sender,final Customer receiver,final DeparturePoint departure,final ReceivePoint receive) {
        this.items = new Item[MAX_ITEMS];
        this.totalWeight = 0;
        this.sender = sender;
        this.receiver = receiver;
        this.departure = departure;
        this.receive = receive;
        this.maxWeight = Math.max(departure.getMaxWeight(), receive.getMaxWeight());
    }

    public Shipment(final ReceivePoint[] receivePoints,final DeparturePoint[] departurePoints,final Scanner scanner) {
        this.createShipment(receivePoints, departurePoints, scanner);
    }

    public void createShipment(final ReceivePoint[] receivePoints,final DeparturePoint[] departurePoints,final Scanner scanner) {
        try {

            System.out.println("Введіть ініціали відправника:");
            final String senderName = scanner.nextLine();
            sender = new Customer(senderName);
            System.out.println("Введіть ініціали отримувача:");
            final String receiverName = scanner.nextLine();
            receiver = new Customer(receiverName);
            boolean good = false;
            do {
                System.out.println("Список адрес доступних для відправлення:");
                for (final DeparturePoint departurePoint : departurePoints) {
                    System.out.print(departurePoint.getAddress() + " ");
                }
                System.out.println();
                System.out.println("Введіть адресу відправника:");
                final String senderAddress = scanner.nextLine();
                for (final DeparturePoint departurePoint : departurePoints) {
                    if (senderAddress.equalsIgnoreCase(departurePoint.getAddress())) {
                        departure = departurePoint;
                        good = true;
                        break;
                    }
                }


            } while (!(good));
            good = false;
            do {
                System.out.println("Список адрес доступних для отримання в відділенні:");
                for (final ReceivePoint receivePoint : receivePoints) {
                    System.out.print(receivePoint.getAddress() + " ");
                }
                System.out.println();
                System.out.println("Введіть адресу отримувача:");
                final String receiverAddress = scanner.nextLine();
                for (final ReceivePoint receivePoint : receivePoints) {
                    if (receiverAddress.equalsIgnoreCase(receivePoint.getAddress())) {
                        receive = receivePoint;
                        good = true;
                        break;
                    }
                }
                if (good)
                    break;
                System.out.println("Не знайдено поштового відділення, відправити кур'єром? (т/н)");
                final String isCourier = scanner.nextLine();
                if (isCourier.equalsIgnoreCase("т")) {
                    receive = new ReceivePoint(new Courier(receiverAddress));
                    good = true;
                }
            } while (!(good));
            maxWeight = Math.max(departure.getMaxWeight(), receive.getMaxWeight());

            items = new Item[MAX_ITEMS];
            totalWeight = 0;
            while (AddItemFromConsole(scanner)) ;
            //this.printShipment();
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());

        }
    }

    public void printShipment() {
        System.out.println("Кількість товарів: " + totalItems());
        for (final Item item : items) {
            if (item != null)
                System.out.println("Вага: " + item.getWeight() + " кг, опис: " + item.getDescription());
        }
        System.out.println("Загальна вага: " + totalWeight);
        System.out.println("Відправник: " + sender.getInitials());
        System.out.println("Отримувач: " + receiver.getInitials());
        System.out.println("Адреса відправки: " + departure.getAddress());
        System.out.print("Адреса отримування: " + receive.getAddress());
        if (receive.getIsCourier())
            System.out.println(" кур'єром");
        else
            System.out.println(" відділення");
        System.out.println("Максимальна вага: " + maxWeight);
    }

    public boolean AddItemFromConsole(final Scanner scanner) {
        System.out.println("Додати товари? (т/н)");
        final String isCourier = scanner.nextLine();
        if (isCourier.equalsIgnoreCase("т")) {
            System.out.println("Опис: ");
            final String description = scanner.nextLine();
            System.out.println("Вага: ");
            final double weight = Double.parseDouble(scanner.nextLine());
            System.out.println(weight);
            AddItem(new Item(weight, description));
            return true;
        }
        return false;
    }

    public void AddItem(final Item item) {

        if (totalWeight + item.getWeight() > maxWeight) {
            System.out.println("Завелика вага!");
            return;
        }
        if (totalItems() >= MAX_ITEMS) {
            System.out.println("Забагато товарів для однієї посилки!");
            return;
        }
        items[totalItems()] = item;
        totalWeight += item.getWeight();
    }

    public int totalItems() {
        int count = 0;
        for (final Item item : items) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }
}
