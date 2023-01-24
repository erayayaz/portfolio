package com.ex.portfolio.dto.converter;

import com.ex.portfolio.dto.ProjectDto;
import com.ex.portfolio.portfolio.model.Project;

public class ProjectDtoConverter {
    public ProjectDto convert(Project from) {
        return new ProjectDto(
                from.getId(),
                from.getName(),
                from.getDescription(),
                from.getStartDate(),
                from.getEndDate(),
                from.getStatus()
        );
    }
}
