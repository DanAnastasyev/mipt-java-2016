package ru.mipt.java2016.database;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mipt.java2016.database.config.SpringJDBCConfiguration;
import ru.mipt.java2016.database.dao.EmployeeDAO;

public class App {
    public static void main(String[] args) throws SQLException {
        try (AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringJDBCConfiguration.class)) {

            EmployeeDAO empDAO = applicationContext.getBean(EmployeeDAO.class);
            String empName = empDAO.getEmployeeName(1);

            System.out.println("Employee name is " + empName);
        }
    }
}