import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    private static int id = 0;
    HashMap<Integer, Task> tasks;
    HashMap<Integer, Subtask> subtasks;
    HashMap<Integer, Epic> epics;

    public TaskManager() {
        this.tasks = new HashMap<>();
        this.subtasks = new HashMap<>();
        this.epics = new HashMap<>();
    }

    public ArrayList<Task> getTasksList() {
        ArrayList<Task> tasksList = new ArrayList<>();
        for (Task task : tasks.values()) {
            tasksList.add(task);
        }
        System.out.println(tasksList);
        return tasksList;
    }


    public void deleteAllTasks() {
        tasks.clear();
    }

    public Task getTaskById(int id) {
        System.out.println(tasks.get(id));
        return tasks.get(id);
    }

    public void createTask(Task task) {
        id++;
        task.id = id;
        tasks.put(id, task);
    }

    public void updateTask(Task task) {
        for (Task taskCheck : tasks.values()) {
            if (taskCheck.name.equals(task.name)) {
                task.id = taskCheck.id;
            }
        }
        tasks.put(task.getId(), task);
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public ArrayList<Subtask> getSubtasksList() {
        ArrayList<Subtask> subtasksList = new ArrayList<>();
        for (Subtask subtask : subtasks.values()) {
            subtasksList.add(subtask);
        }
        System.out.println(subtasksList);
        return subtasksList;
    }

    public void deleteAllSubtasks() {
        subtasks.clear();
    }

    public Subtask getSubtaskById(int id) {
        System.out.println(subtasks.get(id));
        return subtasks.get(id);
    }

    public void createSubtask(Subtask subtask) {
        id++;
        subtask.id = id;
        subtasks.put(id, subtask);
        ArrayList<Subtask> subtasksId = new ArrayList<>();
        for (Epic epic : epics.values()) {
            if (subtask.epicId.equals(epic.name)) {
                epic.subtasksId.add(subtask);
            }
        }
        checkStatus();
    }

    public void updateSubtask(Subtask subtask) {
        for (Subtask subtaskCheck : subtasks.values()) {
            if (subtaskCheck.name.equals(subtask.name)) {
                subtask.id = subtaskCheck.id;
                subtasks.remove(subtaskCheck);
            }
        }
        for (Epic epic : epics.values()) {
            for (Subtask subtask1 : epic.subtasksId) {
                if (subtask1.name.equals(subtask.name)) {
                    epic.subtasksId.remove(subtask1);
                }
            }
        }
        for (Epic epic : epics.values()) {
            if (subtask.epicId.equals(epic.name)) {
                epic.subtasksId.add(subtask);
            }
        }
        subtasks.put(subtask.getId(), subtask);
        checkStatus();
    }

    public void deleteSubtaskById(int id) {
        subtasks.remove(id);
    }

    public ArrayList<Epic> getEpicsList() {
        checkStatus();
        ArrayList<Epic> epicsList = new ArrayList<>();
        for (Epic epic : epics.values()) {
            epicsList.add(epic);
        }
        System.out.println(epicsList);
        return epicsList;
    }

    public void deleteAllEpics() {
        epics.clear();
        subtasks.clear();
    }

    public Epic getEpicsById(int id) {
        System.out.println(epics.get(id));
        return epics.get(id);
    }

    public void checkStatus() {

        for (Epic epicCheck : epics.values()) {
            int countNew = 0;
            int countDone = 0;
            int countInProgress = 0;
            int totalCount = 0;
            for (Subtask subtask : epicCheck.subtasksId) {
                if (subtask.epicId.equals(epicCheck.name) && subtask.status == Status.NEW) {
                    countNew++;
                    totalCount++;
                } else if (subtask.epicId.equals(epicCheck.name) && subtask.status == Status.DONE) {
                    countDone++;
                    totalCount++;
                } else if (subtask.epicId.equals(epicCheck.name) && subtask.status == Status.IN_PROGRESS) {
                    countInProgress++;
                    totalCount++;
                }
            }
            if (countNew == totalCount || epicCheck.subtasksId == null) {
                epicCheck.status = Status.NEW;
            } else if (countDone == totalCount) {
                epicCheck.status = Status.DONE;
            } else {
                epicCheck.status = Status.IN_PROGRESS;
            }
        }


    }

    public void createEpic(Epic epic) {
        id++;
        epic.id = id;
        epics.put(id, epic);
        checkStatus();
    }

    public void updateEpics(Epic epic) {
        for (Epic checkEpic : epics.values()) {
            if (checkEpic.name.equals(epic.name)) {
                epic.id = checkEpic.id;
            }
        }
        epics.put(epic.getId(), epic);
    }

    public void deleteEpicById(int key) {
        Epic check = epics.get(key);
        epics.remove(key);
        ArrayList<Integer> temporaryId = new ArrayList<>();
        for (Subtask subtask : subtasks.values()) {
            if (subtask.epicId.equals(check.name)) {
                temporaryId.add(subtask.id);
            }
        }
        subtasks.keySet().removeAll(temporaryId);
    }


    public void getSubtasksByEpic(String epicId) {
        ArrayList<Subtask> subtasksByEpic = new ArrayList<>();
        for (Subtask subtask : subtasks.values()) {
            if (subtask.epicId.equals(epicId)) {
                subtasksByEpic.add(subtask);
            }
        }
        System.out.println(subtasksByEpic);
    }
}
