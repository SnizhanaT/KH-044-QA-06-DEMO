public class Task {
    private String title;
    private String type;
    private int priority;
    private LocalDateTime dateTime;
    //static int count = 0; - можна зробити таку штуку, щоб вона автоматично підраховувала кількість об'єктів

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getType(){
        return type;
    }

    public void setType(String types){
        this.type = type;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(){
        this.dateTime = dateTime;
    }

    public Task(String title, String types, int priority,LocalDateTime dateTime){
        this.title = title;
        this.type = types;
        this.priority = priority;
        this.dateTime = dateTime;
    }

    public void getTaskDescription(){
        System.out.println("Task title: " + title);
        System.out.println("Task type: " + type);
        System.out.println("Priority: " + priority);
    }
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", priority=" + priority +
                ", dateTime=" + dateTime +
                '}';
    }
}
