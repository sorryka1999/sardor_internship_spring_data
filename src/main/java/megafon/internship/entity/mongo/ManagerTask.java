package megafon.internship.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document
public class ManagerTask {

    @Id
    private String id;
    @Field("user_created_task_id")
    private long userCreatedTaskId;
    @Field("executor_id")
    private long executorId;
    @Field("task_description")
    private String taskDescription;
    @Field("date_created")
    private LocalDate dateCreated;

    public ManagerTask(long userCreatedTaskId, long executorId,
                       String taskDescription, LocalDate dateCreated) {
        this.userCreatedTaskId = userCreatedTaskId;
        this.executorId = executorId;
        this.taskDescription = taskDescription;
        this.dateCreated = dateCreated;
    }

    public String getCreationDate() {
        return dateCreated.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getUserCreatedTaskId() {
        return userCreatedTaskId;
    }

    public void setUserCreatedTaskId(long userCreatedTaskId) {
        this.userCreatedTaskId = userCreatedTaskId;
    }

    public long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(long executorId) {
        this.executorId = executorId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
