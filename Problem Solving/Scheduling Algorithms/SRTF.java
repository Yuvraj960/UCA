import java.util.*;

public class SRTF {

    private Map<Task, Thread> taskThreadMap;

    public SRTF() {
        taskThreadMap = new HashMap<>();
    }

    public void execute(List<Task> taskList)  throws InterruptedException {
        PriorityQueue<Task> queue = new PriorityQueue<Task>((t1, t2) -> {
            if (t1.getRemainingTime() != t2.getRemainingTime()) {
                return Integer.compare(t1.getRemainingTime(), t2.getRemainingTime());
            }

            if (t1.getPriority() != t2.getPriority()) {
                return Integer.compare(t2.getPriority(), t1.getPriority());
            }

            return Integer.compare(t1.getArrivalTime(), t2.getArrivalTime());
        });

        int currentTime = 0;
        int completed = 0;
        int idx = 0;

        while (completed < taskList.size()) {
            while (idx < taskList.size() && taskList.get(idx).getArrivalTime() <= currentTime) {
                queue.offer(taskList.get(idx));
                idx++;
            }

            if (queue.isEmpty()) {
                currentTime++;
                Thread.sleep(100);
                continue;
            }

            Task currentTask = queue.poll();
            currentTask.resume();
            Thread.sleep(100);
            currentTime++;

            if (currentTask.isCompleted()) {
                currentTask.calculateTimes(currentTime);
                completed++;
                System.out.printf("Task %d is completed at this time %d", currentTask.getTaskId(), currentTime);
            } else {
                queue.offer(currentTask);
            }
        }

        printStatistic(taskList);
    }

    private void printStatistic(List<Task> taskList) {
        System.out.println("\nTask | Completion | Turnaround | Waiting");
        for (Task t : taskList) {
            System.out.printf(" %2d  |     %2d     |     %2d     |    %2d\n",
                    t.getTaskId(), t.getCompletionTime(),
                    t.getTurnaroundTime(), t.getWaitingTime());
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time for Task " + (i + 1) + ": ");
            int at = sc.nextInt();
            System.out.print("Enter burst time for Task " + (i + 1) + ": ");
            int bt = sc.nextInt();
            taskList.add(new Task(i + 1, at, bt));
        }

        taskList.sort(Comparator.comparingInt(Task::getArrivalTime));
        SRTF scheduler = new SRTF();
        scheduler.execute(taskList);
        sc.close();
    }
}

