package com.ex.portfolio.portfolio.enums;

public enum ProjectStatus {
    CREATED("CREATED"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE");

    private final String status;

    ProjectStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
