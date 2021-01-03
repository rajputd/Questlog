package com.ctrlaltdileep.questlog.repository;

import com.ctrlaltdileep.questlog.model.Quest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private QuestRepository repository;

    @Test
    public void whenFindByNameThenReturnQuest() {
        Quest quest = new Quest("Test repo code", "test to see if thigns work");
        entityManager.persist(quest);
        entityManager.flush();

        Optional<Quest> found = repository.findByName("Test repo code");

        Assert.assertTrue(found.isPresent());
        Assert.assertEquals(quest.getName(),found.get().getName());
        Assert.assertEquals(quest.getDescription(),found.get().getDescription());
    }

    @Test
    public void whenDataAvailableThenReturnAllQuests() {
        Quest quest = new Quest("Test repo code", "test to see if thigns work");
        Quest quest2 = new Quest("Test repo code2", "test to see if thigns work");
        entityManager.persist(quest);
        entityManager.persist(quest2);
        entityManager.flush();

        List<Quest> found = repository.findAll();

        Assert.assertEquals(found.size(), 2);
        Assert.assertEquals(found.get(0).getName(), quest.getName());
        Assert.assertEquals(found.get(0).getDescription(), quest.getDescription());

        Assert.assertEquals(found.get(1).getName(), quest2.getName());
        Assert.assertEquals(found.get(1).getDescription(), quest2.getDescription());
    }






}
