
package live.switchly.api.repository;

import live.switchly.api.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProjectRepository {

    private final Map<UUID, Project> projects =
            new ConcurrentHashMap<>();

    public Project save(Project project) {
        projects.put(project.getId(), project);
        return project;
    }

    public Project findById(UUID id) {
        return projects.get(id);
    }

    public List<Project> findAll() {
        return new ArrayList<>(projects.values());
    }

    public List<Project> findByOrganizationId(UUID organizationId) {
        return projects.values()
                .stream()
                .filter(project ->
                        project.getOrganizationId().equals(organizationId))
                .toList();
    }

    public Project update(Project project) {
        projects.put(project.getId(), project);
        return project;
    }

    public void delete(UUID id) {
        projects.remove(id);
    }

}
