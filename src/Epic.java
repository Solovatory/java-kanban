import java.util.ArrayList;

public class Epic extends Task {
    ArrayList<Subtask> subtasksIds = new ArrayList<>();

    public Epic(String name, ArrayList<Subtask> subtasksIds) {
        super(name);
        this.subtasksIds = subtasksIds;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtasksId=" + subtasksIds +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
