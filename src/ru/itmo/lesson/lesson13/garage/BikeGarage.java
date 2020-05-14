package ru.itmo.lesson.lesson13.garage;

public class BikeGarage extends Garage<Bus>{
public void checkBike(){
    System.out.println(this.getCarOnService().isWiFi());
}

}
class BikeGarage2 extends Garage<Transport>{
public void checkBike(){
    System.out.println(this.getCarOnService().getNum());
}
}
class BikeGarage3 extends Garage{
    public void checkBike(){
        System.out.println(this.getCarOnService().getNum());
    }
}
