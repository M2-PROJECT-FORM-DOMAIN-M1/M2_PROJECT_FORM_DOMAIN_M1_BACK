package com.project.service;

import com.project.database.repository.form.IFormRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateSaltStringService {

    IFormRepository iFormRepository;

    public GenerateSaltStringService(IFormRepository iFormRepository) {
        this.iFormRepository = iFormRepository;
    }

    public String getSaltString(int sizeString) {
        String saltChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt;
        Random rnd = new Random();

       do{
           salt = new StringBuilder();
           while (salt.length() < sizeString) {
               int index = (int) (rnd.nextFloat() * saltChar.length());
               salt.append(saltChar.charAt(index));
           }
       }while (iFormRepository.existsByCode(salt.toString())) ;


        return salt.toString();
    }

}
