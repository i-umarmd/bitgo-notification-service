package com.bitgo.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Column(name = "created_by")
    @JsonIgnore
    private Long createdBy;

    @Column(name = "created_timeStamp")
    @JsonIgnore
    private LocalDateTime createdTimeStamp;

    @Column(name = "updated_by")
    @JsonIgnore
    private Long updatedBy;

    @Column(name = "updated_timeStamp")
    @JsonIgnore
    private LocalDateTime updatedTimeStamp;
}
