package megafon.internship.services.mongo;

import megafon.internship.entity.mongo.ManagerTask;
import megafon.internship.repository.mongo.ManagerTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ManagerTaskService {

    @Autowired
    private ManagerTaskRepo managerTaskRepo;

    public List<ManagerTask> getAllTasks() {
        return managerTaskRepo.findAll();
    }

    public List<ManagerTask> getExecutorTasks(long executor_id) {
        return managerTaskRepo.findByExecutorId(executor_id);
    }

    public void createTask(long userCreatedTaskId, long executorId,
                           String taskDescription, LocalDate dateCreated) {
        ManagerTask task = new ManagerTask(userCreatedTaskId, executorId, taskDescription, dateCreated);
        managerTaskRepo.save(task);
    }

    public void deleteTask(String id) {
        managerTaskRepo.deleteById(id);
    }
}
