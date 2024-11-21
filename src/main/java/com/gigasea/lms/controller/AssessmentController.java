package com.gigasea.lms.controller;

import com.gigasea.lms.model.Assessment;
import com.gigasea.lms.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping("/assessments")
    public String viewAllAssessments(Model model) {
        List<Assessment> assessments = assessmentService.findAssessments();
        model.addAttribute("assessments", assessments); return "assessments";
    }

    @GetMapping("/registerAssessment")
    public String showRegistrationForm(Model model) {
        model.addAttribute("assessment", new Assessment());
        return "registerAssessment";
    }

    @PostMapping("/saveAssessment")
    public String saveAssessment(@ModelAttribute Assessment assessment) {
        assessmentService.saveAssessment(assessment);
        return "redirect:/assessments";
    }

    @GetMapping("/updateAssessment/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Assessment assessment = assessmentService.getAssessmentById(id);
        model.addAttribute("assessment", assessment);
        return "updateAssessment";
    }

    @PostMapping("/updateAssessment/{id}")
    public String updateAssessment(@PathVariable Long id, @ModelAttribute Assessment assessment) {
        assessmentService.saveAssessment(assessment); return "redirect:/assessments";
    }

    @GetMapping("/deleteAssessment/{id}")
    public String deleteAssessment(@PathVariable Long id) {
        assessmentService.deleteAssessment(id); return "redirect:/assessments";
    }

}
