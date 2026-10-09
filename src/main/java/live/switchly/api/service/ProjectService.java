
package live.switchly.api.service;

import live.switchly.api.exception.NotFoundException;
import live.switchly.api.model.Organization;
import live.switchly.api.model.Project;
import live.switchly.api.repository.OrganizationRepository;
import live.switchly.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final OrganizationRepository organizationRepository;

    public ProjectService(
            ProjectRepository projectRepository,
            OrganizationRepository organizationRepository) {
        this.projectRepository = projectRepository;
        this.organizationRepository = organizationRepository;
    }

    public Project create(UUID organizationId, String name) {
        Organization organization =
                organizationRepository.findById(organizationId);

        if (organization == null) {
            throw new NotFoundException(
                    "Organization not found with ID: " + organizationId);
        }

        Project project = new Project(
                UUID.randomUUID(), organizationId, name);

        return projectRepository.save(project);
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project getById(UUID id) {
        Project project = projectRepository.findById(id);

        if (project == null) {
            throw new NotFoundException(
                    "Project not found with ID: " + id);
        }

        return project;
    }

    public List<Project> getByOrganizationId(UUID organizationId) {
        if (organizationRepository.findById(organizationId) == null) {
            throw new NotFoundException(
                    "Organization not found with ID: " + organizationId);
        }

        return projectRepository.findByOrganizationId(organizationId);
    }

    public Project update(UUID id, String name) {
        Project existingProject = getById(id);

        Project updatedProject = new Project(
                existingProject.getId(),
                existingProject.getOrganizationId(),
                name
        );

        return projectRepository.update(updatedProject);
    }

    public void delete(UUID id) {
        getById(id);
        projectRepository.delete(id);
    }

}
