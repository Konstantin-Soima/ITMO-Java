package ru.itmo.lesson.exam1;

import java.util.Date;
import java.util.Random;

public class Farm {
    public Redneck redneck;
    public Pet[] pets;
    final static int MAX_ANIMALS = 10;
    public void passDay(Weak todayWeak){
        //фермер живёт
        redneck.resource-=2;
        //Приходит хищник
        Random random = new Random(new Date().getTime());
        if (pets.length>0) {
            Pet todayVictim = pets[random.nextInt(pets.length)];
            if (todayWeak.eat(todayVictim))
                System.out.println(todayWeak + " сьедает " + todayVictim);
        }
        //Проверяем ещё живых животных
        int alivePetCount = 0;
        for (Pet pet: pets) {
            if (pet.onFarm) alivePetCount++;
        }
        Pet[] alivePet = new Pet[alivePetCount];
        for (Pet pet: pets) {
            if (pet.onFarm) alivePet[--alivePetCount]=pet;
        }
        pets = alivePet; //так будет проще навигация по ещё живым
        //Кормёшка
        for (Pet pet: pets) {
            redneck.feedAnimals(pet);
        }
        //Сбор ресурсов
        int todayResources = 0;
        for (Pet pet: pets){
            if (pet.resource>0){
                pet.resource--;
                todayResources++;
                System.out.println(redneck.name + " собрал ресурсы с " + pet);
            }
        }
        //Если ресурсов не хватит на завтра, начинаем есть животных, хотя логичнее есть животное как только оно перестало давать ресурсы
        if (todayResources==0||redneck.resource+todayResources<2){
            System.out.println("Животные больше не дают достаточно ресурсов");
            for (Pet pet: pets) {
                if (pet instanceof CanBeEaten) {
                    todayResources+=((CanBeEaten) pet).eat();
                    System.out.println(redneck.name+" употребил в пищу "+pet);
                    break;
                }
            }
        }
        redneck.resource+=todayResources;
    }
}
