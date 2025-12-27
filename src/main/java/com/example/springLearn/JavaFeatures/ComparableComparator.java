package com.example.springLearn.JavaFeatures;

import lombok.Data;
import org.hibernate.mapping.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableComparator {

    @Data
    static class Employee implements Comparable<Employee>{

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
        private int id;
        private String name;
        private double salary;
        private String department;

        public Employee(int id, String name, double salary, String department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        @Override
        public int compareTo(Employee o) {
            return Double.compare(this.salary, o.salary);
        }

    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1,"Allvin",500,"IT");
        Employee e2 = new Employee(2,"Anand",2000,"IT");
        Employee e3 = new Employee(3,"Mom",1600,"HW");
        Employee e4 = new Employee(4,"Dad",1000,"BU");

        List<Employee> ls = new ArrayList<>();
        ls.add(e1);
        ls.add(e2);
        ls.add(e3);
        ls.add(e4);

        Collections.sort(ls);
        System.out.println(ls);

        Collections.sort(ls, Collections.reverseOrder());
        System.out.println(ls);

    }
}
