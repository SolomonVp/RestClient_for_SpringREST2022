package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.configuration.Communication;
import com.zaurtregulov.spring.rest.configuration.MyConfig;
import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        //получаем всех работников
        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        //получаем одного работника
        Employee employeeById = communication.getEmployee(3);
        System.out.println(employeeById);

        //добавляем или изменяем работника(изменения по id)
        Employee emp = new Employee("Sveta", "Eliseeva", "IT", 900);
//        emp.setId(12); // для изменения. Для добавления setId не нужен.
        communication.saveEmployee(emp);

        //удаляем одного работника по id
//        communication.deleteEmployee(12);

        context.close();
    }
}
