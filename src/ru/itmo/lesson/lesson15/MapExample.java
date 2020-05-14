package ru.itmo.lesson.lesson15;

//В мапе все ключи уникальны

import java.lang.ref.WeakReference;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User cbf = new User("cbf", "12443", Role.USER);
        User asd = new User("asd", "2625", Role.ADMIN);
        User rty = new User("rty", "8734", Role.USER);
        User bnm = new User("bnm", "2688", Role.ADMIN);

        System.out.println("--HashMap--");
        //1 using in hash map
        //2 для обьектов которые используются в качестве ключей должны переопределяться equals и hashcode
        //3 порядок хранения элементов может отличаться
        //4 null может быть в качестве ключа

        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(asd.getLogin(),asd);
        userHashMap.put(cbf.getLogin(),cbf);
        userHashMap.put(rty.getLogin(),rty);
        userHashMap.put(bnm.getLogin(),bnm);
        userHashMap.put(null,null);

        System.out.println(userHashMap);
        System.out.println(userHashMap.get("cbf"));
        System.out.println(userHashMap.getOrDefault("vvv",bnm));
        userHashMap.remove("asd");

        userHashMap.replace(null,asd);
        userHashMap.replace(null,asd,null);

        System.out.println("--Перебор элементов map--");
        for (Map.Entry<String, User> entry: userHashMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        System.out.println("--EnumMap---");
        EnumMap<Role, ArrayList<User>> enumMap =new EnumMap<>(Role.class);
        enumMap.put(Role.USER, new ArrayList<>(Arrays.asList(cbf,rty)));

        List<User> userList = Arrays.asList(asd,bnm);
        ArrayList<User> userArrayList = new ArrayList<>(userList);
        enumMap.put(Role.ADMIN, userArrayList);


        System.out.println(enumMap);
        System.out.println(enumMap.get(Role.USER));

        for (User user :enumMap.get(Role.ADMIN)
             ) {
            System.out.println(user.getLogin());
        }

        User newUser = new User("newUser","666",Role.ADMIN);
        enumMap.get(newUser.getRole()).add(newUser);

        System.out.println("---TreeMap---");
        //1 Хранит в отсортированном по ключе порядке
        //2 null не может быть ключом
        //3 класс обьекты которого ключи должен иметь интерфейс Comparable
        //4 основан  на алгоритме красно-чёрного дерева

        userHashMap.remove(null);
        TreeMap<String,User> treeMap = new TreeMap<>(userHashMap);
        System.out.println(treeMap);
        treeMap.put(asd.getLogin(),asd);
        treeMap.put(rty.getLogin(),rty);
        treeMap.put(bnm.getLogin(),bnm);
        System.out.println(treeMap);

        System.out.println("--WeakHashMap--");
        //1 using in hash map
        //2 для обьектов которые используются в качестве ключей должны переопределяться equals и hashcode
        //3 порядок хранения элементов может отличаться
        //4 null может быть в качестве ключа
        //5 запись из WeakHashMap будет удалена при сьорке мусора есл на ключи не осталось сильных ссылок

        WeakHashMap<Object,String> weakHashMap = new WeakHashMap<>();
        Object weakKey = new Object();
        String weakValue = "String value";
        weakHashMap.put(weakKey,weakValue);
        HashMap <Object,String> hashMap2 = new HashMap<>();
        Object hashKey = new Object();
        String hashVal = "String value";
        hashMap2.put(hashKey,hashVal);
        weakKey = null;
        hashKey = null;

        System.gc(); //Запустится ли сборщик?

        System.out.println("weak" + weakHashMap);
        System.out.println("hash" + hashMap2);

        //ССильная ссылка - strong reference она не удаляется даже если нет памяти
        User user = new User("user", "23232",Role.ADMIN);
        //Слабая ссылка weak reference - Она помечается при удалении обьекта, сборщик при нехватки удалит
        WeakReference<User> weakReference = new WeakReference<>(user);
        user = null;
    }
}
