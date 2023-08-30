package com.ex.portfolio.portfolio.service;

import com.ex.portfolio.dto.ProjectDto;
import com.ex.portfolio.portfolio.dto.converter.ProjectDtoConverter;
import com.ex.portfolio.portfolio.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectDtoConverter projectDtoConverter;

    public List<ProjectDto> getProjects(int size, int page) {
        return projectRepository.findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .map(projectDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public List<ProjectDto> getProjects2() {
        return projectRepository.findAll()
                .stream()
                .map(projectDtoConverter::convert)
                .collect(Collectors.toList());
    }
}