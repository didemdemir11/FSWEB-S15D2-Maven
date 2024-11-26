package org.example;

import org.example.entity.Priority;
import org.example.entity.Status;
import org.example.entity.Task;
import org.example.entity.TaskData;

import java.util.HashSet;
import java.util.Set;

import static org.example.entity.StringSet.findUniqueWords;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Project A", "Fix login bug", "Ann", Status.IN_QUEUE, Priority.LOW);
        Task task2 = new Task("Project B", "Add new feature", "Bob", Status.ASSIGNED,Priority.MED);
        Task task3 = new Task("Project C", "Update documentation", "Carol", Status.IN_QUEUE, Priority.LOW);
        Task sharedTask = new Task("Project D", "Conduct meeting", "Multiple", Status.ASSIGNED, Priority.HIGH);
        Set<Task> annsTasks = new HashSet<>(Set.of(task1, sharedTask));
        Set<Task> bobsTasks = new HashSet<>(Set.of(task2, sharedTask));
        Set<Task> carolsTasks = new HashSet<>(Set.of(task3));
        Set<Task> unassignedTasks = new HashSet<>();
        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
        System.out.println(taskData.getTasks("all"));
        System.out.println(taskData.getTasks("ann"));
        System.out.println(taskData.getUnassignedTasks());
        System.out.println(taskData.getTasksAssignedToMultipleEmployees());
        System.out.println("************************");

        Set<String> uniqueWords = findUniqueWords();
        System.out.println(uniqueWords.size());
        System.out.println(uniqueWords);
    }
}