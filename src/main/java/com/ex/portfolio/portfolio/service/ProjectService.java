package com.ex.portfolio.portfolio.service;

import com.ex.portfolio.dto.ProjectDto;
import com.ex.portfolio.portfolio.dto.SaveProjectRequest;
import com.ex.portfolio.portfolio.dto.converter.ProjectDtoConverter;
import com.ex.portfolio.portfolio.model.Project;
import com.ex.portfolio.portfolio.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectDtoConverter projectDtoConverter;

    @Transactional
    public ProjectDto saveProject(SaveProjectRequest saveProjectRequest) {

        Optional<Project> project = Optional.ofNullable(projectRepository.findByName(saveProjectRequest.getName()));
        if (project.isPresent()) {
            throw new RuntimeException();
        }

        Project newProject = new Project(
                saveProjectRequest.getName(),
                saveProjectRequest.getDescription(),
                saveProjectRequest.getImage(),
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

    private String getDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(date);
    }
}
