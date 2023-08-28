package com.ex.portfolio.portfolio.api;

import com.ex.portfolio.dto.ProjectDto;
import com.ex.portfolio.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/list")
    public ResponseEntity<List<ProjectDto>> getProjects(@RequestParam(name = "size") int size, @RequestParam(name = "page") int page) {
        return ResponseEntity.ok(projectService.getProjects(size, page));
    }
}