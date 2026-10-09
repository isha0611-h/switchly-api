
package live.switchly.api.dto;

import java.util.UUID;

public class OrganizationResponse {

    private UUID id;
    private String name;

    public OrganizationResponse() {
    }

    public OrganizationResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
