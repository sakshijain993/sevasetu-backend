
package com.sevasetu.need_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class OrganizationClient {

    private final RestClient restClient;

    public OrganizationClient() {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public Object getOrganizationById(Long id) {
        return restClient.get()
                .uri("/api/organizations/" + id)
                .retrieve()
                .body(Object.class);
    }
}
 