package com.ctrlaltdileep.questlog.service;

import com.ctrlaltdileep.questlog.model.Quest;
import com.ctrlaltdileep.questlog.repository.QuestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class QuestService {
    private QuestRepository questRepository;

    QuestService(QuestRepository repo) {
        this.questRepository = repo;
    }

    public List<Quest> getAll() {
        return questRepository.findAll();
    }

    public Quest getById(long id) {
        Optional<Quest> output = questRepository.findById(id);

        if (!output.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"A quest with ID=" + id + " does not exist");
        }

        return output.get();
    }

    public long save(Quest quest) {
        //build object to save
        Quest toSave = new Quest(quest.getName(), quest.getDescription());
        Quest q = questRepository.save(toSave);
        return q.getId();
    }

    public Quest update(Quest quest) {
        if (!validateQuest(quest)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Description and Name fields should not be null");
        }

        if (!questRepository.existsById(quest.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find Quest with id=" + quest.getId());
        }

        return questRepository.save(quest);
    }

    public List<Quest> getAllByComplete(boolean complete) {
        return questRepository.findByComplete(complete);
    }

    public void deleteById(long id) {
        if (!questRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"A quest with ID=" + id + " does not exist");
        }

        questRepository.deleteById(id);
    }

    private boolean validateQuest(Quest quest) {
        return quest.getName() != null
                && quest.getDescription() != null;
    }
}
