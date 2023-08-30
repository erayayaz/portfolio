package com.ex.portfolio.portfolio.api;

import com.ex.portfolio.dto.ProjectDto;
import com.ex.portfolio.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/project")
@RequiredArgsConstructor
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/list")
    public ResponseEntity<List<ProjectDto>> getProjects() {
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getProjects2());
    }
}