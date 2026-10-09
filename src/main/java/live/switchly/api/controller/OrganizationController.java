
package live.switchly.api.controller;

import live.switchly.api.dto.CreateOrganizationRequest;
import live.switchly.api.dto.OrganizationResponse;
import live.switchly.api.model.Organization;
import live.switchly.api.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orgs")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationResponse create(
            @Valid @RequestBody CreateOrganizationRequest request) {

        Organization organization =
                organizationService.create(request.getName());

        return new OrganizationResponse(
                organization.getId(),
                organization.getName());
    }

    @GetMapping
    public List<OrganizationResponse> getAll() {
        return organizationService.getAll()
                .stream()
                .map(org -> new OrganizationResponse(
                        org.getId(), org.getName()))
                .toList();
    }

    @GetMapping("/{orgId}")
    public OrganizationResponse getById(@PathVariable UUID orgId) {
        Organization organization = organizationService.getById(orgId);

        return new OrganizationResponse(
                organization.getId(),
                organization.getName());
    }

}
