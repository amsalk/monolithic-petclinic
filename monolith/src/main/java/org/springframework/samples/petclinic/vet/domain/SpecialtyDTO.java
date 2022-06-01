package org.springframework.samples.petclinic.vet.domain;

public class SpecialtyDTO {

    private final String name;

    public SpecialtyDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
