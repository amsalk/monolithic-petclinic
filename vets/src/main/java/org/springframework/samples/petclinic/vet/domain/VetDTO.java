package org.springframework.samples.petclinic.vet.domain;

import java.util.List;

public class VetDTO {

    private final String firstName;
    private final String lastName;
    private final List<SpecialtyDTO> specialties;
    private final int nrOfSpecialties;

    public VetDTO(String firstName, String lastName, List<SpecialtyDTO> specialties, int nrOfSpecialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialties = specialties;
        this.nrOfSpecialties = nrOfSpecialties;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNrOfSpecialties() {
        return nrOfSpecialties;
    }

    public List<SpecialtyDTO> getSpecialties() {
        return specialties;
    }
}
