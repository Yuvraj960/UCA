import java.util.*;

public class Task {
    int id;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int completionTime;
    int waitingTime;
    int turnaroundTime;
    int priority = 0; // default priority

    public Task(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }

    public int getTaskId() { return id; }
    public int getArrivalTime() { return arrivalTime; }
    public int getBurstTime() { return burstTime; }
    public int getRemainingTime() { return remainingTime; }
    public int getPriority() { return priority; }
    public int getCompletionTime() { return completionTime; }
    public int getTurnaroundTime() { return turnaroundTime; }
    public int getWaitingTime() { return waitingTime; }

    public boolean isCompleted() {
        return remainingTime == 0;
    }

    // Simulate running for one time unit
    public void resume() {
        if (remainingTime > 0) remainingTime--;
    }

    // Calculate completion, turnaround, and waiting times
    public void calculateTimes(int currentTime) {
        completionTime = currentTime;
        turnaroundTime = completionTime - arrivalTime;
        waitingTime = turnaroundTime - burstTime;
    }
}
