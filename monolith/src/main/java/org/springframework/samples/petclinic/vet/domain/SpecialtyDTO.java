package org.springframework.samples.petclinic.vet.domain;

public class SpecialtyDTO {

    private String name;

    public SpecialtyDTO() {
    }

    public SpecialtyDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
