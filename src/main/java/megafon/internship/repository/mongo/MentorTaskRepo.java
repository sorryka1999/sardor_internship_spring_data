package megafon.internship.repository.mongo;

import megafon.internship.entity.mongo.MentorTask;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MentorTaskRepo extends MongoRepository<MentorTask, String> {
    public List<MentorTask> findByExecutorId(long executor_id);
}
