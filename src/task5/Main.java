package task5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        final DeliveryDepartment lviv = new DeliveryDepartment("Львів", true, true, true);
        final DeliveryDepartment kyiv = new DeliveryDepartment("Київ", true, true, true);
        final DeliveryDepartment rivne = new DeliveryDepartment("Рівне", false, false, true);
        final DeliveryDepartment dnipro = new DeliveryDepartment("Дніпро", true, false, false);
        final ReceivePoint[] receivePoints = {new ReceivePoint(kyiv), new ReceivePoint(dnipro)};
        final DeparturePoint[] departurePoints = {new DeparturePoint(lviv), new DeparturePoint(rivne), new DeparturePoint(kyiv)};
        final int MAX_SHIPMENTS = 10;
        boolean isContinue = true;
        Shipment[] shipments = new Shipment[MAX_SHIPMENTS];
        final Scanner scanner = new Scanner(System.in);
        //==============================
        do {
            System.out.println("Меню:\n1. Переглянути всі відправлення\n2. Додати відправлення\n3. Видалити відправлення\n0. Вийти");
            final String choice = scanner.nextLine();
            int countOfShipmens = 0;
            for (final Shipment ship : shipments) {
                if (ship != null) {
                    countOfShipmens++;
                }
            }
            switch (choice) {

                case "1": {
                    if (countOfShipmens < 1)
                        System.out.println("Немає відправлень");
                    for (int i = 0; i < countOfShipmens; i++) {
                        System.out.println("Відправлення №" + i + 1);
                        shipments[i].printShipment();
                    }
                    break;
                }
                case "2": {

                    if (countOfShipmens >= 10) {
                        System.out.println("Забагато відправлень в масиві");
                        break;
                    }
                    final Shipment newShipment = new Shipment(receivePoints, departurePoints, scanner);
                    if (countOfShipmens > 0)
                        shipments[countOfShipmens - 1] = newShipment;
                    else
                        shipments[0] = newShipment;
                    break;
                }
                case "3": {
                    if (countOfShipmens < 1) {
                        System.out.println("Немає відправлень");
                        break;
                    }
                    if (countOfShipmens == 1)
                        shipments = new Shipment[MAX_SHIPMENTS];
                    System.out.println("Номер відправлень ?");
                    final int choiceofDelete;
                    try {
                        final String receiverName = scanner.nextLine();
                        choiceofDelete = Integer.parseInt(receiverName);
                        if (choiceofDelete > countOfShipmens || choiceofDelete < 0)
                            throw new IllegalArgumentException("Неправильно введене число");

                        shipments[choiceofDelete - 1] = shipments[countOfShipmens - 1];
                    } catch (Exception e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;
                }
                case "0":
                {
                    isContinue=false;
                    break;
                }

            }

        } while (isContinue);
        for (int i = 0; i < 5; i++) {
            final Shipment shipmentLvivKyiv = new Shipment(receivePoints, departurePoints, scanner);
            shipmentLvivKyiv.printShipment();
            System.out.println("Привіт1");
        }
        scanner.close();
    }
}

/*inal int[] mas  = new int[]{1,2,3};

        for (int i = 0; i < mas.length; i++){
            mas[i] = (int)(Math.random()*10);
        }

        System.out.println("Not sorted: " + Arrays.toString(mas));

        int tmp;
        for (int i = 0;i < mas.length;i++){
            for (int j = 0; j < mas.length - 1 ; j++){
                if (mas[j] > mas[j+1]){
                    tmp = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = tmp;
                }
            }
        }
        System.out.println("Sorted array:" + Arrays.toString(mas));
    }

    public class Transport{
        public Transport(){}
    }

    public String toString(){
        return*/
