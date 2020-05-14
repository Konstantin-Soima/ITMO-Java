package ru.itmo.lesson.lesson13.garage;

public class TstGarage {
    public static void main(String[] args) {
        Bus bus = new Bus("Спб", "Тверь", "234", false);
        Train train = new Train("Спб", "Москва", "23-Ф", 12);

        Garage<Bus> garage1 = new Garage<>();
        garage1.setCarOnService(bus);
        System.out.println(garage1.getCarOnService().isWiFi());
        Garage<Train> garage2 =new Garage<>();
        garage2.setCarOnService(train);
        System.out.println(garage2.getCarOnService().getCarCount());
    }
}
