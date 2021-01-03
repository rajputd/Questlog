package com.ctrlaltdileep.questlog.repository;

import com.ctrlaltdileep.questlog.model.Quest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestRepository extends CrudRepository<Quest, Long> {
    Optional<Quest> findById(long id);
    Optional<Quest> findByName(String name);
    List<Quest> findAll();
    List<Quest> findByComplete(boolean complete);
    void deleteById(long id);

}
