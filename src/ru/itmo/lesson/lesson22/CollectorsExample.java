package ru.itmo.lesson.lesson22;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("qwe", "Apple", 2000, 19));
        employees.add(new Employee("asd", "Yandex", 3000, 38));
        employees.add(new Employee("zxc", "Google", 2500, 49));
        employees.add(new Employee("vbn", "Google", 3000, 22));
        employees.add(new Employee("tyu", "Apple", 1500, 22));

        System.out.println("--группировка по названию");
        Map<String, List<Employee>> byCompany = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCompany));
        byCompany.entrySet().forEach(System.out::println);

        System.out.println("--группировка по условию");
        Map <Boolean,List<Employee>> by22 = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge()==22));
        by22.entrySet().forEach(System.out::println);
        System.out.println("--По алфовиту");

        List<String> companyNames = employees.stream()
                .map(Employee::getCompany)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("--название компании - средняя за");
        Map<String, Double> compAver = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCompany,Collectors.averagingDouble(Employee::getSalary)));
        compAver.entrySet().forEach(System.out::println);

        System.out.println("-компания и зп");
        Map<String, Map<Integer, List<Employee>>>  companySalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCompany,
                        Collectors.groupingBy(Employee::getSalary)));
        companySalary.entrySet().forEach(System.out::println);

    }
}
