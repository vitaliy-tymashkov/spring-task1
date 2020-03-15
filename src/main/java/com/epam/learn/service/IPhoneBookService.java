package com.epam.learn.service;

import com.epam.learn.model.PhoneBook;

import java.util.List;

public interface IPhoneBookService {

    List<PhoneBook> findAll();
    void insert(String name, String phoneNumber, String phoneCompany);
}

