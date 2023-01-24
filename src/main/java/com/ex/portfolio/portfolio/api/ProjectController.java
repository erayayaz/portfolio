package com.ex.portfolio.portfolio.api;

import com.ex.portfolio.dto.ProjectDto;
import com.ex.portfolio.portfolio.dto.SaveProjectRequest;
import com.ex.portfolio.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/save")
    public ResponseEntity<ProjectDto> saveProject(@RequestBody SaveProjectRequest saveProjectRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.saveProject(saveProjectRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getProjects() {
        return ResponseEntity.ok(projectService.getProjects(2, 3));
    }
}