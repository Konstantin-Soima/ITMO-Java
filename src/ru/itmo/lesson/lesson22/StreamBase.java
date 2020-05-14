package ru.itmo.lesson.lesson22;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBase {
    public static void main(String[] args) {
         /*Stream API - набор методов для работы с данными, как с потоком
         позволяет представить различные наботы данных в виде потока
         И далее: сортировать их, фильтровать, осуществлять поиск по различным критериям,
         кроме этого позволяет создавать новые потоки, создавать коллекции и мапы на основе потока данных*/
        // Stream НЕ ХРАНИТ ДАННЫЕ Для сохранения данных из Stream нужно использовать специальные методы

         /*Для работы с потоками данных:
         1. получить данные в виде потока - объект типа Stream
         2. выполнить промежуточные операции с потоком данных
         (промежуточные операции обрабатывают данные и возвражают Stream объект)
         3. выполнить терминальную (конечную) операцию
         (терминальная операция обрабатывает данные и завершает работу стрима)
         Без терминальной операции промежуточные операции не начнут выполняться!!!

         Например, получили объект stream
         промежуточные операции
         stream.операция1() - вернет преобразованный объект stream
               .операция2() - вернет преобразованный объект stream
               .операция3()  - вернет преобразованный объект stream
               .терминальнаяОперация(); // запускает промежуточные операции, данные обрабатываются, стрим закрывается
         терминальные forEach / findFirst / findAny / xxxMatch / min / max / collect*/

         /*методы получения Stream объектов:
         из коллекций collection.stream();
         из массива Arrays.stream(arr);
         из файла Files.lines(path_to_file);
         из строки string.chars();
         используя builder:
         Stream.builder().add(obj1).add(obj2).add(objN).build();
         Stream.of(1, 4, 7); любой набор данных*/

            Stream<Integer> integerStream = Stream.of(6,7,300,-1488,0,-111);
            integerStream.filter(num -> num <0)//фильтр - промежуточная операция
                .map(num -> num * 10)
                    .limit(2)
                    .forEach(System.out::println);


            integerStream = Stream.of(45,67,33,33,-500,0,-500,120,33);
            integerStream.distinct()
                    .sorted()
                    .forEach(System.out::println); //<--это называется терминальная операция

        integerStream = Stream.of(45,67,33,33,-500,0,-500,120,33);
        System.out.println(integerStream.anyMatch(num ->num ==33));
        integerStream = Stream.of(45,67,33,33,-500,0,-500,120,33);
        System.out.println(integerStream.allMatch(num ->num>0));
        integerStream = Stream.of(45,67,33,33,-500,0,-500,120,33);
        System.out.println(integerStream.noneMatch(num -> num>33));

        String[] stringsArr = {"cat","dog","pig"};
        //терминальная операция:
        //findFirst
        //findAny - рандомный элемент
        // фозвращают обьект типа Optional<T> - null safe container ( nullable короче)
         String s = Arrays.stream(stringsArr)
                 .findFirst().get();
        System.out.println(Arrays.stream(stringsArr).findFirst());
        s = Arrays.stream(stringsArr).findFirst().orElse("default");
        System.out.println(s);

        boolean isElemPresent = Arrays.stream(stringsArr).findFirst().isPresent();

        Arrays.stream(stringsArr)
                .skip(1)//удаляет первый элемент
                .filter( s1 -> s1.endsWith("g"))
                .forEach(System.out::println);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("qwe", 34));
        users.add(new User("asd", 56));
        users.add(new User("zxc", 18));
        users.add(new User("qwe", 34));
        users.add(new User("zxc", 22));

//массив младше 30

        User[] usersArr = users.stream().filter(user -> user.getAge()<30)
                .toArray(User[]::new);
        System.out.println(Arrays.toString(usersArr));

        List<User> userList = users.stream()
                .filter(user -> user.getAge() > 30)
                .peek(user-> user.setActive(true))
                .collect(Collectors.toList());

        Set<User> userSet = users.stream()
                .filter(user -> user.getAge() > 20)
                .collect(Collectors.toSet());

        ArrayList<User> usersArrayList = users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toCollection(ArrayList::new));

        //терминальные операции min max
        User minUser = users.stream().min(Comparator.comparing(User::getAge))
                .orElse(new User("Default user",1));
        System.out.println("min user: "+minUser);

        String[] colors = {"Red","Black","Grean"};
        Map<String,Integer> colorMap = Arrays.stream(colors)
                    .collect(Collectors.toMap(
                            Function.identity(),
                            String::length
                    ));

        HashMap<String,Integer> colorHashMap = Arrays.stream(colors)
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (item1,item2) -> item1,
                        HashMap::new
                ));

        List<Integer> stingList = Stream.of("33","55","77")
                .flatMap(elem->Stream.of(Integer.parseInt(elem)))
                .collect(Collectors.toList());

        List<String> list1 = Arrays.asList("33","33","44");
        List<String> list2 = Arrays.asList("33","55","66");
        List<String> list3 = Arrays.asList("0","-33","-6");

        Stream.of(list1,list2,list3)
                .flatMap(elem->elem.stream().distinct().sorted())
                .forEach(System.out::println);
    }
}
