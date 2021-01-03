package com.ctrlaltdileep.questlog.controller;

import com.ctrlaltdileep.questlog.model.Quest;
import com.ctrlaltdileep.questlog.service.QuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestController {
    private static Logger log = LoggerFactory.getLogger(QuestController.class);

    @Autowired
    QuestService questService;

    @GetMapping("/quest")
    public List<Quest> getAllQuests() {
        log.info("Getting all quests");
        return questService.getAll();
    }

    @GetMapping("/quest/{id}")
    public Quest getById(@PathVariable  long id) {
        log.info("Getting Quest with ID={}", id);
        return questService.getById(id);
    }

    @PostMapping("/quest")
    public long saveQuest(@RequestBody Quest quest) {
        log.info("creating new quest with  name='{}', description='{}'", quest.getName(), quest.getDescription());
        return questService.save(quest);
    }

    @PutMapping("/quest")
    Quest updateQuest(@RequestBody Quest quest) {
        log.info("updating {}", quest);
        return questService.update(quest);
    }

    @GetMapping("/quest/complete/false")
    List<Quest> getAllIncomplete() {
        log.info("Getting all incomplete quests");
        return questService.getAllByComplete(false);
    }

    @GetMapping("/quest/complete/true")
    List<Quest> getAllComplete() {
        log.info("Getting all complete quests");
        return questService.getAllByComplete(true);
    }

    @DeleteMapping("/quest/{id}")
    public void deleteById(@PathVariable  long id) {
        log.info("Deleting Quest with ID={}", id);
        questService.deleteById(id);
    }

}
