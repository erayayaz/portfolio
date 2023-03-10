package com.ex.portfolio.portfolio.dto.converter;

import com.ex.portfolio.dto.ProjectDto;
import com.ex.portfolio.portfolio.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoConverter {
    public ProjectDto convert(Project from) {
        return new ProjectDto(
                from.getId(),
                from.getName(),
                from.getDescription(),
                from.getImage(),
                from.getStartDate(),
                from.getEndDate(),
                from.getStatus()
        );
    }
}
