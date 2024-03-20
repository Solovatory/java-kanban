public class Subtask extends Task {
    String epicId;

    public Subtask(String name, String description, Status status, String epicId) {
        super(name, description, status);
        this.epicId = epicId;
    }


    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + epicId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
