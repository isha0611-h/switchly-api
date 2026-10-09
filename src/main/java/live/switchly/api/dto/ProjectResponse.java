
package live.switchly.api.dto;

import java.util.UUID;

public class ProjectResponse {

    private UUID id;
    private UUID organizationId;
    private String name;

    public ProjectResponse() {
    }

    public ProjectResponse(
            UUID id,
            UUID organizationId,
            String name) {
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
