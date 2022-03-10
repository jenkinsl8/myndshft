package com.myndshft.restservice;

public class Note {
    String notes;
    Boolean new_patient;
    String race;
    String ssn;

    public String getNotes() {
        return notes;
    }
    public Boolean isNewPatient() {
        return new_patient;
    }

    public String getRace() {
        return race;
    }

    public String getSsn() {
        return ssn;
    }

    public void setNew_patient(Boolean new_patient) {
        this.new_patient = new_patient;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
