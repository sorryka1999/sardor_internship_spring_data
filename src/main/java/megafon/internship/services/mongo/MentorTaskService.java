package megafon.internship.services.mongo;

import megafon.internship.entity.mongo.MentorTask;
import megafon.internship.repository.mongo.MentorTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MentorTaskService {

    @Autowired
    private MentorTaskRepo mentorTaskRepo;

    public List<MentorTask> getAllTasks() {
        return mentorTaskRepo.findAll();
    }

    public List<MentorTask> getExecutorTasks(long executor_id) {
        return mentorTaskRepo.findByExecutorId(executor_id);
    }

    public void createTask(long userCreatedTaskId, long executorId,
                           String taskDescription, LocalDate dateCreated) {
        MentorTask task = new MentorTask(userCreatedTaskId, executorId, taskDescription, dateCreated);
        mentorTaskRepo.save(task);
    }

    public void updateTask(String id, long userCreatedTaskId, long executorId,
                           String taskDescription, LocalDate dateCreated) {
        MentorTask task = mentorTaskRepo.findById(id).get();
        task.setUserCreatedTaskId(userCreatedTaskId);
        task.setExecutorId(executorId);
        task.setTaskDescription(taskDescription);
        task.setDateCreated(dateCreated);
        mentorTaskRepo.save(task);
    }

    public void deleteTask(String id) {
        mentorTaskRepo.deleteById(id);
    }
}
