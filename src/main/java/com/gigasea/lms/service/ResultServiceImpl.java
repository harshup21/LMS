package com.gigasea.lms.service;

import com.gigasea.lms.model.Result;
import com.gigasea.lms.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService{

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public void saveResult(Result result) {

        resultRepository.save(result);
    }

    @Override
    public List<Result> findResults() {

        return resultRepository.findAll();
    }

    @Override
    public Result getResultById(Long id) {

        return resultRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteResult(Long id) {

        resultRepository.deleteById(id);
    }
}
