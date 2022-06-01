package org.springframework.samples.petclinic.vet.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.samples.petclinic.vet.controller.VetService;
import org.springframework.samples.petclinic.vet.db.VetRepository;
import org.springframework.samples.petclinic.vet.domain.SpecialtyDTO;
import org.springframework.samples.petclinic.vet.domain.VetDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Qualifier("oldVetService")
public class OldVetService implements VetService {

        private final VetRepository vetRepository;

        public OldVetService(VetRepository vetRepository) {
            this.vetRepository = vetRepository;
        }

        @Override
        public Collection<VetDTO> findAll() {
            return vetRepository.findAll().stream()
                    .map(vet -> new VetDTO(vet.getFirstName(),
                            vet.getLastName(),
                            vet.getSpecialties().stream()
                                    .map(s -> new SpecialtyDTO(s.getName()))
                                    .collect(Collectors.toList())))
                    .collect(Collectors.toList());
        }
    }