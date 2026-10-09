
package live.switchly.api.model;

import java.util.UUID;

public class Project {

    private UUID id;
    private UUID organizationId;
    private String name;

    public Project() {
    }

    public Project(UUID id, UUID organizationId, String name) {
        this.id = id;
        this.organizationId = organizationId;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public String getName() {
        return name;
    }
}
