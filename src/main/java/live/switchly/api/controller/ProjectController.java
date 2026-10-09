
package live.switchly.api.controller;

import jakarta.validation.Valid;
import live.switchly.api.dto.CreateProjectRequest;
import live.switchly.api.dto.ProjectResponse;
import live.switchly.api.model.Project;
import live.switchly.api.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse create(
            @Valid @RequestBody CreateProjectRequest request) {
        Project project = projectService.create(
                request.getOrganizationId(),
                request.getName());
        return toResponse(project);
    }

    @GetMapping
    public List<ProjectResponse> getAll() {
        return projectService.getAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{projectId}")
    public ProjectResponse getById(
            @PathVariable UUID projectId) {
        return toResponse(projectService.getById(projectId));
    }

    @GetMapping("/by-organization/{organizationId}")
    public List<ProjectResponse> getByOrganization(
            @PathVariable UUID organizationId) {
        return projectService.getByOrganizationId(organizationId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @PutMapping("/{projectId}")
    public ProjectResponse update(
            @PathVariable UUID projectId,
            @Valid @RequestBody CreateProjectRequest request) {
        Project project = projectService.update(
                projectId,
                request.getName());
        return toResponse(project);
    }

    @DeleteMapping("/{projectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID projectId) {
        projectService.delete(projectId);
    }

    private ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getOrganizationId(),
                project.getName());
    }
}
