import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        System.out.println("Создаем Задачи...");
        taskManager.createTask(new Task("Задача № 1", "Описание задачи № 1", Status.NEW));
        taskManager.createTask(new Task("Задача № 2", "Описание задачи № 2", Status.DONE));
        System.out.println("Созданные Задачи: ");
        taskManager.getTasksList();
        System.out.println("Получаем Задачу по id");
        taskManager.getTaskById(2);
        System.out.println("Обновляем Задачу...");
        taskManager.updateTask(new Task("Задача № 1", "Новое описание задачи № 1", Status.DONE));
        System.out.println("Обновленные Задачи");
        taskManager.getTasksList();
        System.out.println("Удаляем Задачу по id...");
        taskManager.deleteTaskById(1);
        System.out.println("Теперь список Задач такой: ");
        taskManager.getTasksList();
        System.out.println("Удаляем все Задачи...");
        taskManager.deleteAllTasks();
        System.out.println("Теперь список Задач пуст: ");
        taskManager.getTasksList();

        System.out.println("Создаем Эпики...");
        taskManager.createEpic(new Epic("Epic № 1", new ArrayList<>()));
        taskManager.createEpic(new Epic("Epic № 2", new ArrayList<>()));
        System.out.println("Созданные Эпики");
        taskManager.getEpicsList();
        System.out.println("Получаем Эпик по id");
        taskManager.getEpicsById(3);

        System.out.println("Создаем Подзадачи...");
        taskManager.createSubtask(new Subtask("Подзадача № 1",
                "Описание подзадачи № 1", Status.NEW, "Epic № 1"));
        taskManager.createSubtask(new Subtask("Подзадача № 2",
                "Описание подзадачи № 2", Status.DONE, "Epic № 1"));
        taskManager.createSubtask(new Subtask("Подзадача № 3",
                "Описание подзадачи № 3", Status.IN_PROGRESS, "Epic № 2"));
        System.out.println("Созданные Подзадачи");
        taskManager.getSubtasksList();

        System.out.println("Статус Эпиков изменился");
        taskManager.getEpicsList();

        System.out.println("Получаем Подзадачу по id");
        taskManager.getSubtaskById(5);

        System.out.println("Обновляем Подзадачу...");
        taskManager.updateSubtask(new Subtask("Подзадача № 1",
                "Новое описание подзадачи № 1", Status.DONE, "Epic № 1"));
        System.out.println("Обновленные подзадачи: ");
        taskManager.getSubtasksList();

        System.out.println("Статус Эпиков изменился");
        taskManager.getEpicsList();

        System.out.println("Удаляем Эпик по id");
        taskManager.deleteEpicById(4);
        System.out.println("Новый список Эпиков: ");
        taskManager.getEpicsList();
        System.out.println("Получаем список Подзадач определенного эпика:");
        taskManager.getSubtasksByEpic("Epic № 1");
        System.out.println("Обновляем Epic № 1...");
        ArrayList<Subtask> testSubtasks = new ArrayList<>();
        testSubtasks.add(new Subtask("Подзадача № 4",
                "Описание подзадачи № 4", Status.IN_PROGRESS, "Epic № 1"));
        taskManager.updateEpics(new Epic("Epic № 1", testSubtasks));
        System.out.println("Новый список Эпиков: ");
        taskManager.getEpicsList();
        System.out.println("Удаляем все Эпики");
        taskManager.deleteAllEpics();
        System.out.println("Список Эпиков пуст");
        taskManager.getEpicsList();

        System.out.println("Удаляем Подзадачу по id");
        taskManager.deleteSubtaskById(5);
        System.out.println("Новый список Подзадач: ");
        taskManager.getSubtasksList();
        System.out.println("Удаляем все Подзадачи");
        taskManager.deleteAllSubtasks();
        System.out.println("Пустой список Подзадач");
        taskManager.getSubtasksList();


    }
}
