
package live.switchly.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CreateProjectRequest {

    @NotNull(message = "Organization ID is required")
    private UUID organizationId;

    @NotBlank(message = "Project name is required")
    private String name;

    public CreateProjectRequest() {
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
