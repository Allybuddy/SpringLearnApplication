package com.example.springLearn.JavaFeatures;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.PropertySource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamsOnEmployeeClass {

    public static void main(String[] args) {
        // Create sample employee dataset
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 75000, "IT"),
                new Employee(2, "Bob", 48000, "HR"),
                new Employee(3, "Charlie", 52000, "IT"),
                new Employee(4, "David", 60000, "Finance"),
                new Employee(5, "Evelyn", 45000, "IT"),
                new Employee(6, "Frank", 82000, "IT"),
                new Employee(7, "Grace", 55000, "Marketing"),
                new Employee(8, "Hannah", 67000, "IT"),
                new Employee(9, "Ian", 49000, "Finance"),
                new Employee(10, "Jasmine", 51000, "IT")
        );

        log.info(" list of emp {}",employees.stream().filter( e -> e.department.equalsIgnoreCase("IT")
                && e.salary > 50000).map(Employee::getName).toList());

        log.info("avg salary : {}", employees.stream().map(Employee::getSalary).collect(Collectors.averagingDouble(x -> x)));

        //employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).forEach(e ->log.info(e.toString()));
        System.out.println();
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((x,y) -> log.info(y.toString()));
        System.out.println();
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((a,b)-> log.info(a +":"+b));
        System.out.println();
        employees.stream().collect(Collectors.partitioningBy(e -> e.salary > 50000)).forEach((a,b)-> {log.info(a +":"+b); System.out.println();});


        /*Using Java Streams, write code to generate a summary report that includes:

         * A map of departments to the list of employee names in that department.
         * The average salary per department.
         * The name of the highest-paid employee in each department.
         * A list of all employees sorted by age, then by name.*/

        List<Employee2> employees2 = Arrays.asList(
                new Employee2("Alice", "HR", 50000, 30),
                new Employee2("Bob", "IT", 70000, 25),
                new Employee2("Charlie", "HR", 60000, 28),
                new Employee2("David", "IT", 90000, 35),
                new Employee2("Eve", "Finance", 75000, 40),
                new Employee2("Frank", "Finance", 80000, 38)
        );

        //A map of departments to the list of employee names in that department.
        System.out.println("list of employees n dept " + employees2.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.mapping(Employee2::getName, Collectors.toList()))));

        System.out.println("average salary per department :  " + employees2.stream()
                .collect(Collectors.groupingBy( a -> a.getDepartment(), Collectors.averagingInt(a -> a.salary))));
        System.out.println("average salary per department :  " + employees2.stream()
                .collect(Collectors.groupingBy( Employee2::getDepartment, Collectors.averagingInt(Employee2::getSalary))));

        //The name of the highest-paid employee in each department.
        System.out.println("difficult one : " + employees2.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.collectingAndThen(
                                                                                        Collectors.maxBy(Comparator.comparingDouble( Employee2::getSalary)),
                                                                                        emp -> emp.map(Employee2::getName).orElse(null)
                                                                                ))));

        //A list of all employees sorted by age, then by name.
        employees2.stream().sorted( (a,b) -> b.age - a.age)
                .sorted((a, b) -> b.name.length() - a.name.length()).forEach( obj -> System.out.println( obj.name + " " + obj.age));

        //asked in cgi

        String str = "aabgsucscjiusa";

        var uniqueSet = Arrays.stream(str.split("")).filter( s -> str.indexOf(s) == str.lastIndexOf(s)).toList();
        System.out.println(uniqueSet.stream().limit(3).toList());

        //Empoyee(id,name,salary,managerID)
       /* employees.stream().collect(Collectors.groupingBy(Employees::getmanagerId), Collectors.collectingAndThen
                ( Collectors.filtering(    emp.getsalary >  emp.stream.filter( emp -> emp.getId == managerId).map(Emp::getSalary).findfirst())  )), Collectors.toList()
*/
    }

    static class Employee {
        private int id;
        private String name;
        private double salary;
        private String department;

        // Constructor
        public Employee(int id, String name, double salary, String department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        // toString()
        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
    }

    static class Employee2 {
        String name;
        String department;
        int salary;
        int age;

        public Employee2(String name, String department, int salary, int age) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
