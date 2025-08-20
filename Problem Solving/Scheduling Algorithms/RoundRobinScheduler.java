import java.util.*;

public class RoundRobinScheduler {
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void execute(List<Task> tasks) {
        int currentTime = 0;
        Queue<Task> readyQueue = new LinkedList<>();
        List<Task> arrivedTasks = new ArrayList<>();
        int completedTasks = 0;
        int n = tasks.size();

        // Sort tasks by arrival time
        tasks.sort(Comparator.comparingInt(t -> t.arrivalTime));

        while (completedTasks < n) {
            // Add new arriving tasks to the ready queue
            for (Task task : tasks) {
                if (task.arrivalTime <= currentTime && !arrivedTasks.contains(task)) {
                    readyQueue.add(task);
                    arrivedTasks.add(task);
                    System.out.println("Time " + currentTime + ": Task " + task.id + " arrived.");
                }
            }

            if (readyQueue.isEmpty()) {
                currentTime++;
                continue;
            }

            Task currentTask = readyQueue.poll();

            int timeToRun = Math.min(timeQuantum, currentTask.remainingTime);
            System.out.println("Time " + currentTime + ": Running Task " + currentTask.id + " for " + timeToRun + " unit(s).");
            currentTask.remainingTime -= timeToRun;
            currentTime += timeToRun;

            // Check for new arrivals during this quantum and add them to ready queue
            for (Task task : tasks) {
                if (task.arrivalTime > currentTime - timeToRun && task.arrivalTime <= currentTime && !arrivedTasks.contains(task)) {
                    readyQueue.add(task);
                    arrivedTasks.add(task);
                    System.out.println("Time " + task.arrivalTime + ": Task " + task.id + " arrived.");
                }
            }

            if (currentTask.isCompleted()) {
                currentTask.completionTime = currentTime;
                currentTask.turnaroundTime = currentTask.completionTime - currentTask.arrivalTime;
                currentTask.waitingTime = currentTask.turnaroundTime - currentTask.burstTime;
                completedTasks++;
                System.out.println("Time " + currentTime + ": Task " + currentTask.id + " completed.");
            } else {
                readyQueue.add(currentTask);
            }
        }

        System.out.println("\nAll Tasks Completed:");
        for (Task task : tasks) {
            System.out.println("Task " + task.id + ": Completion=" + task.completionTime +
                    ", Turnaround=" + task.turnaroundTime + ", Waiting=" + task.waitingTime);
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 0, 5));
        tasks.add(new Task(2, 1, 3));
        tasks.add(new Task(3, 2, 1));
        int timeQuantum = 2;

        RoundRobinScheduler rr = new RoundRobinScheduler(timeQuantum);
        rr.execute(tasks);
    }
}
