package com.gigasea.lms.service;

import com.gigasea.lms.model.Assessment;
import java.util.List;
public interface AssessmentService {
    void saveAssessment(Assessment assessment);
    List<Assessment> findAssessments();
    Assessment getAssessmentById(Long id);
    void deleteAssessment(Long id);
}
