package com.epam.learn.service;

import java.util.List;

import com.epam.learn.model.PhoneBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PhoneBookService implements IPhoneBookService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PhoneBook> findAll() {

        String sql = "SELECT * FROM phonebook";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PhoneBook.class));
    }


    public void insert(String name, String phoneNumber, String phoneCompany) {

        String sql = "INSERT INTO phonebook(name, phoneNumber, phoneCompany) VALUES('" + name + "', '" + phoneNumber + "', '" + phoneCompany + "');";

        jdbcTemplate.update(sql);
    }
}

