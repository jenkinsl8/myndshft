package com.myndshft.restservice.db.mongodb;

import java.util.List;
import com.myndshft.restservice.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    @Query("{ 'first_name' : ?0 }")
    List<Patient> findByFirstName(String first_name);

    @Query("{ 'last_name' : ?0 }")
    List<Patient> findByLastName(String last_name);

    List<Patient> findByGender(String gender);


}