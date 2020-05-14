package ru.itmo.lesson.lesson13.garage;

public class Taxi extends Bus  implements pereday{
    private boolean wiFi;



    public Taxi(String departureSt, String destSt, String num) {
        super( departureSt,  destSt,  num,false);
        this.wiFi = wiFi;
    }

    public boolean isWiFi() {
        return wiFi;
    }

    public void setWiFi(boolean wiFi) {
        this.wiFi = wiFi;
    }

    @Override
    public void repair() {
        System.out.println("Ремонт маршрутки");
    }
}
