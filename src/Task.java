import java.time.LocalDateTime;

public class Task {
    String title;
    String types;//type?
    int priority;
    String task;//?
    LocalDateTime dateTime;//добавила dateTime
    //static int count = 0; - можна зробити таку штуку, щоб вона автоматично підраховувала кількість об'єктів

    public Task(String title, String types, int priority, LocalDateTime dateTime){
        this.title = title;
        this.types = types;
        this.priority = priority;
        this.dateTime = dateTime;//добавила
    }
    public Task(String task){//Sasha /*
        String[] taskFields = task.split(" ");
        String title = taskFields[0];
        String types = taskFields[1];//type
        int priority = Integer.parseInt(taskFields[2]);
        LocalDateTime dateTime = LocalDateTime.parse(taskFields[3]);
        new Task(title, types, priority, dateTime);
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTypes(){
        return types;
    }

    public void setTypes(String types){
        this.types = types;
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

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", types='" + types + '\'' +
                ", priority=" + priority +
                ", dateTime=" + dateTime +
                '}';
    } //Sasha */

    public void getTaskDescription(){//Nastia
        System.out.println("Task title: " + title);
        System.out.println("Task type: " + types);
        System.out.println("Priority: " + priority);
    }
}
