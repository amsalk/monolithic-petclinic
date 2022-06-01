package org.springframework.samples.petclinic.vet.service;

import org.springframework.samples.petclinic.vet.model.Vet;
import org.springframework.samples.petclinic.vet.db.VetRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VetService {
    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public Collection<Vet> allVets() {
        return vetRepository.findAll();
    }
}