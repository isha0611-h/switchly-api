
package live.switchly.api.repository;

import live.switchly.api.model.Organization;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrganizationRepository {

    private final Map<UUID, Organization> organizations =
            new ConcurrentHashMap<>();

    public Organization save(Organization organization) {
        organizations.put(organization.getId(), organization);
        return organization;
    }

    public Organization findById(UUID id) {
        return organizations.get(id);
    }

    public java.util.List<Organization> findAll() {
        return new java.util.ArrayList<>(organizations.values());
    }
}
