package com.myndshft.restservice;

import com.myndshft.restservice.db.mongodb.PatientRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.io.File;
import java.util.Arrays;

import org.springframework.core.io.ClassPathResource;


@SpringBootApplication
public class RestServiceApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository repository;

    private static final Log log = LogFactory.getLog(RestServiceApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read json file and convert to customer object
        List<Patient> patients = Arrays.asList(objectMapper.readValue(new ClassPathResource("json/MOCK_DATA.json").getFile(), Patient[].class));
        repository.saveAll(patients);

        // fetch all customers
        System.out.println("Patients found with findAll():");
        System.out.println("-------------------------------");
        for (Patient patient : repository.findAll()) {
            System.out.println(patient);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Patient found with findById(10):");
        System.out.println("--------------------------------");
        System.out.println(repository.findById("10"));


    }
}


