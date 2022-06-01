package org.springframework.samples.petclinic.vet.controller;

import org.springframework.samples.petclinic.vet.domain.VetDTO;

import java.util.Collection;

public interface VetService {

    Collection<VetDTO> findAll();
}
