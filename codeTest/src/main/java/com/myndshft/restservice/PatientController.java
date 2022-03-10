package com.myndshft.restservice;


import com.myndshft.restservice.db.mongodb.PatientRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/* service API */

@RestController
public class PatientController {

    private static final Log log = LogFactory.getLog(PatientController.class);

    @Autowired
    private PatientRepository repository;

    /* finders */
    @GetMapping("/patient/{id}")
    Patient findPatientById(@PathVariable(value = "id") String patientId)  throws PatientNotFoundException {
        return repository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found for this id :: " + patientId));
    }

    @GetMapping("/patients")
    List<Patient> getAllPatients()  {
        return repository.findAll();
    }

    @PostMapping("/patient")
    Patient createPatient(@RequestBody Patient newPatient) {
        log.info("creating " + newPatient);
        return repository.save(newPatient);
    }


    @PutMapping("/patient/{id}")
    Patient updatePatient(@RequestBody Patient newPatient, @PathVariable String id) {
        return repository.findById(id)
                .map(patient -> {
                    patient.setFirst_name(newPatient.getFirst_name());
                    patient.setLast_name(newPatient.getLast_name());
                    patient.setAddress(newPatient.getAddress());
                    patient.setAdditional_information(newPatient.additional_information);
                    patient.setDiagnosis(newPatient.getDiagnosis());
                    patient.setDrug_code(newPatient.getDrug_code());
                    patient.setEmail(newPatient.getEmail());
                    patient.setGender(newPatient.getGender());
                    patient.setPhone_number(newPatient.getPhone_number());
                    patient.setVisit_date(newPatient.getVisit_date());
                    return repository.save(patient);
                })
                .orElseGet(() -> {
                    newPatient.setId(id);
                    return repository.save(newPatient);
                });



    }


    @DeleteMapping("/patient/{id}")
    void deletePatient(@PathVariable String id) {
        repository.deleteById(id);
    }



}
