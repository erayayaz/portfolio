package com.ex.portfolio.service;

import com.ex.portfolio.dto.ProjectGetRequest;
import com.ex.portfolio.dto.ProjectDto;
import com.ex.portfolio.dto.SaveProjectRequest;
import com.ex.portfolio.dto.converter.ProjectDtoConverter;
import com.ex.portfolio.model.Project;
import com.ex.portfolio.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectDtoConverter projectDtoConverter;

    @Transactional
    public ProjectDto saveProject(SaveProjectRequest saveProjectRequest) {

        Optional<Project> project = projectRepository.findByProjectName(saveProjectRequest.getName());
        if (project.isPresent()) {

        }

        Project newProject = new Project(
                saveProjectRequest.getName(),
                saveProjectRequest.getDescription(),
                null,
                saveProjectRequest.getStartDate() != null ? saveProjectRequest.getStartDate() : getDate(),
                saveProjectRequest.getEndDate() != null ? saveProjectRequest.getEndDate() : null,
                saveProjectRequest.getStatus());

        return projectDtoConverter.convert(projectRepository.save(newProject));
    }

    @Transactional
    public List<ProjectDto> getProjects(int size, int page) {
       return projectRepository.findAll(PageRequest.of(page, size))
               .getContent()
               .stream()
               .map(projectDtoConverter::convert)
               .collect(Collectors.toList());
    }

    private String getDate () {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(date);
    }
}
