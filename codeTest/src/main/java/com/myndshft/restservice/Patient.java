package com.myndshft.restservice;

import org.springframework.data.annotation.*;
import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.List;

/* handling for patient crud ops*/
public class Patient {

    @Id
    String id;
    String first_name;
    String last_name;
    String gender;
    String phone_number;
    String email;
    String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/DD/YYYY")
    Date visit_date;
    String diagnosis;
    String drug_code;
    List<Note> additional_information;

    public Patient() {}

    public Patient(String id, String first_name, String last_name, String gender, String phone_number, String email, String address, Date visit_date, String diagnosis, String drug_code, List<Note> additional_information) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.visit_date = visit_date;
        this.diagnosis = diagnosis;
        this.drug_code = drug_code;
        this.additional_information = additional_information;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Date visit_date) {
        this.visit_date = visit_date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDrug_code() {
        return drug_code;
    }

    public void setDrug_code(String drug_code) {
        this.drug_code = drug_code;
    }

    public List<Note> getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(List<Note> additional_information) {
        this.additional_information = additional_information;
    }

    @Override
    public String toString() {
        return String.format(
                "Patient[id=%s, firstName='%s', lastName='%s']",
                id, first_name, last_name);    }
}












