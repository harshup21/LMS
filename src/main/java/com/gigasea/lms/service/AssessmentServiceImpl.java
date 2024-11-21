package com.gigasea.lms.service;

import com.gigasea.lms.model.Assessment;
import com.gigasea.lms.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService{

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Override
    public void saveAssessment(Assessment assessment) {
        assessmentRepository.save(assessment);
    }

    @Override
    public List<Assessment> findAssessments() {
        return assessmentRepository.findAll();
    }

    @Override
    public Assessment getAssessmentById(Long id) {
        return assessmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAssessment(Long id) {
        assessmentRepository.deleteById(id);
    }
}
