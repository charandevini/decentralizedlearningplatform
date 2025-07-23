package com.dlp.progresstrackerservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProgressUpdateRequest {
    private Long enrollmentId;
    private Integer progressPercent;
}
