/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.vet.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.vet.domain.VetDTO;

import java.util.Collection;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ken Krebs
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Dave Syer
 */
@SpringBootTest
class VetServiceTests {

    private final WireMockServer wireMock = new WireMockServer(options().port(8081));

    @Autowired
    VetService service;

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void shouldFindAllVetsDTO() {
        wireMock.stubFor(get(urlEqualTo("/vets"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"firstName\":\"Linda\",\"lastName\":\"Douglas\",\"specialties\":[{\"name\":\"dentistry\"},{\"name\":\"surgery\"}],\"nrOfSpecialties\":2}]")));

        Collection<VetDTO> vets = service.findAll();

        assertThat(vets)
                .filteredOn(vet -> vet.getFirstName().equals("Linda"))
                .hasSize(1)
                .first()
                .hasFieldOrPropertyWithValue("lastName", "Douglas")
                .hasFieldOrPropertyWithValue("nrOfSpecialties", 2)
                .extracting(VetDTO::getSpecialties).asList()
                .extracting("name")
                .containsExactly("dentistry", "surgery");
    }
}
