package org.springframework.samples.petclinic.vet.service;

import org.springframework.samples.petclinic.vet.controller.VetService;
import org.springframework.samples.petclinic.vet.domain.VetDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;

@Service
public class NewVetService implements VetService {

    private RestTemplate restTemplate;

    public NewVetService() {
        restTemplate = new RestTemplate();
    }

    @Override
    public Collection<VetDTO> findAll() {
        VetDTO[] result = restTemplate.getForObject("http://localhost:8081/vets", VetDTO[].class);
        return Arrays.asList(result);
    }
}
