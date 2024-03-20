import java.util.ArrayList;

public class Epic extends Task {
    ArrayList<Subtask> subtasksId = new ArrayList<>();

    public Epic(String name, ArrayList<Subtask> subtasksId) {
        super(name);
        this.subtasksId = subtasksId;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtasksId=" + subtasksId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
