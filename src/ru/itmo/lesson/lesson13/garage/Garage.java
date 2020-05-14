package ru.itmo.lesson.lesson13.garage;
//если просто <T> то тип может быть любым
public class Garage <T extends  Transport & Repairing> {
//    public class Garage <T extends  Transport & Repairing,K> {
    private T carOnService;
//    private K secondCarOnService;
    public T getCarOnService() {
        return carOnService;
    }

    public void setCarOnService(T carOnService) {
        this.carOnService = carOnService;
    }

    public void service(){
        carOnService.repair();
    }
}
