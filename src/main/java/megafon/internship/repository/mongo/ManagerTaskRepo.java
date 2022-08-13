package megafon.internship.repository.mongo;

import megafon.internship.entity.mongo.ManagerTask;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ManagerTaskRepo extends MongoRepository<ManagerTask, String> {
    public List<ManagerTask> findByExecutorId(long executor_id);
}
