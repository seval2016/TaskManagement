package com.seval.modal;

import jakarta.persistence.Table;

public enum TaskStatus {
    PENDING("PENDING"),
    ASSIGNED("ASSIGNED"),
    DONE("DONE");

    TaskStatus(String done){

    }

}
