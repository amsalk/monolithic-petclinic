package org.springframework.samples.petclinic.vet.controller;

import org.springframework.samples.petclinic.vet.domain.VetDTO;
import org.springframework.samples.petclinic.vet.service.VetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping("/vetsnew")
    public Collection<VetDTO> getAll() {
        return vetService.findAll();
    }
}
