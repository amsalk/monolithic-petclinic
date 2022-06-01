package org.springframework.samples.petclinic.vet.domain;

import java.util.List;

public class VetDTO {

    private String firstName;
    private String lastName;
    private List<SpecialtyDTO> specialties;
    private int nrOfSpecialties;

    public VetDTO() {
    }

    public VetDTO(String firstName, String lastName, List<SpecialtyDTO> specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialties = specialties;
        this.nrOfSpecialties = specialties.size();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SpecialtyDTO> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<SpecialtyDTO> specialties) {
        this.specialties = specialties;
    }

    public int getNrOfSpecialties() {
        return nrOfSpecialties;
    }

    public void setNrOfSpecialties(int nrOfSpecialties) {
        this.nrOfSpecialties = nrOfSpecialties;
    }
}
