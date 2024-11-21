package com.gigasea.lms.controller;

import com.gigasea.lms.model.Result;
import com.gigasea.lms.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/results")
    public String viewAllResults(Model model) {
        List<Result> results = resultService.findResults();
        model.addAttribute("results", results); return "results";
    }

    @GetMapping("/registerResult")
    public String showRegistrationForm(Model model) {
        model.addAttribute("result", new Result());
        return "registerResult";
    }

    @PostMapping("/saveResult")
    public String saveResult(@ModelAttribute Result result) {
        resultService.saveResult(result);
        return "redirect:/results";
    }

    @GetMapping("/updateResult/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Result result = resultService.getResultById(id);
        model.addAttribute("result", result);
        return "updateResult";
    }

    @PostMapping("/updateResult/{id}")
    public String updateResult(@PathVariable Long id, @ModelAttribute Result result) {
        resultService.saveResult(result); return "redirect:/results";
    }

    @GetMapping("/deleteResult/{id}")
    public String deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id); return "redirect:/results";
    }
}
