package ru.mipt.java2016.database.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getEmployeeName(int id) {
        String sqlQuery = "SELECT name FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, String.class);
    }

}
