package com.gigasea.lms.service;

import com.gigasea.lms.model.Result;
import java.util.List;
public interface ResultService {
    void saveResult(Result result);
    List<Result> findResults();
    Result getResultById(Long id);
    void deleteResult(Long id);
}
