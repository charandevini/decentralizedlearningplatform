package com.dlp.peerreviewhubservice.service;

import com.dlp.peerreviewhubservice.dto.SubmissionRequest;
import com.dlp.peerreviewhubservice.dto.SubmissionResponse;

public interface SubmissionService {

	public SubmissionResponse createSubmission(SubmissionRequest request);

}
