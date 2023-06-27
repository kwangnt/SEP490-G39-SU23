package com.teachsync.repositories;


import com.teachsync.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends
        JpaRepository<Question, Long> {

    List<Question> findAllByIdTest(Long idTest);
}
