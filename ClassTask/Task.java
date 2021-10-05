public class Task {
    String title;
    String types;
    int priority;
    String task;
    LocalDateTime;
    //static int count = 0; - можна зробити таку штуку, щоб вона автоматично підраховувала кількість об'єктів

    public Task(String title, String types, int priority){
        this.title = title;
        this.types = types;
        this.priority = priority;
    }
    public Task(String task){
        this.task = task;
    }


    public void getTaskDescription(){
        System.out.println("Task title: " + title);
        System.out.println("Task type: " + types);
        System.out.println("Priority: " + priority);
    }
    public void toString(){
    }
}
