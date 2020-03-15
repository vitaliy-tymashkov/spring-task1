package com.epam.learn.controller;

import com.epam.learn.model.PhoneBook;
import com.epam.learn.service.IPhoneBookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PhoneBookController {

    @Autowired
    private IPhoneBookService phoneBookService;

    @GetMapping(value = "/")
    public String index(Model model) {

        return "index";
    }

    @GetMapping(value="/phonebook")
    public ModelAndView showPhoneBook() {

        List<PhoneBook> phoneBook = phoneBookService.findAll();

        Map<String, Object> params = new HashMap<>();
        params.put("phones", phoneBook);

        return new ModelAndView("showPhonebook", params);
    }


    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public ModelAndView uploadUsers(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws Exception {



        List<PhoneBook> users = new ArrayList<>();
        int i = 0;
        for(MultipartFile uploadedFile : uploadingFiles) {
            if(! uploadedFile.isEmpty()) {
                i++;

                byte[] bytes = uploadedFile.getBytes();
                String s = new String(bytes, StandardCharsets.UTF_8);

                Gson gson = new Gson();
                PhoneBook phoneBook = gson.fromJson(s, PhoneBook.class);

                users.add(phoneBook);

                phoneBookService.insert(phoneBook.getName(), phoneBook.getPhoneNumber(), phoneBook.getPhoneCompany());
            }
        }
        Map<String, Object> params = new HashMap<>();
        params.put("phones", users);
        params.put("quantity", i);

        return new ModelAndView("upload", params);
    }
}
