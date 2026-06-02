import java.util.*;

public class AthanaeumApp {

    static Scanner sc = new Scanner(System.in);

    // LinkedList for tasks
    static LinkedList<String> tasks = new LinkedList<>();

    // Queue for focus sessions
    static Queue<String> sessions = new LinkedList<>();

    // Stack for undo operations
    static Stack<String> actions = new Stack<>();

    // HashMap for tags
    static HashMap<String, String> tags = new HashMap<>();

    // Add Task
    static void addTask() {
        System.out.print("Enter task: ");
        String task = sc.nextLine().trim();

        if (task.isEmpty()) {
            System.out.println("Task cannot be empty.");
            return;
        }

        tasks.add(task);
        actions.push(task);

        System.out.println("Task added successfully.");
    }

    // View Tasks
    static void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nToday's Commitments:");

        int i = 1;
        for (String task : tasks) {
            System.out.println(i + ". " + task);
            i++;
        }
    }

    // Undo Last Task
    static void undoTask() {

        if (actions.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        String lastTask = actions.pop();
        tasks.removeLastOccurrence(lastTask);

        System.out.println("Undo successful: " + lastTask);
    }

    // Add Focus Session
    static void addSession() {

        System.out.print("Enter focus session name: ");
        String session = sc.nextLine().trim();

        if (session.isEmpty()) {
            System.out.println("Session name cannot be empty.");
            return;
        }

        sessions.add(session);

        System.out.println("Session added successfully.");
    }

    // Start Session
    static void startSession() {

        if (sessions.isEmpty()) {
            System.out.println("No sessions available.");
            return;
        }

        System.out.println("Starting session: " + sessions.poll());
    }

    // Add Tag
    static void addTag() {

        System.out.print("Enter task name: ");
        String task = sc.nextLine();

        System.out.print("Enter tag: ");
        String tag = sc.nextLine();

        tags.put(task, tag);

        System.out.println("Tag added successfully.");
    }

    // View Tags
    static void viewTags() {

        if (tags.isEmpty()) {
            System.out.println("No tags available.");
            return;
        }

        System.out.println("\nTask Tags:");

        for (Map.Entry<String, String> entry : tags.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Search Task (Linear Search)
    static void searchTask() {

        System.out.print("Enter task to search: ");
        String key = sc.nextLine();

        int position = 1;

        for (String task : tasks) {

            if (task.equalsIgnoreCase(key)) {
                System.out.println("Task found at position " + position);
                return;
            }

            position++;
        }

        System.out.println("Task not found.");
    }

    // Sort Tasks (Bubble Sort)
    static void sortTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        String[] arr = tasks.toArray(new String[0]);

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j].compareToIgnoreCase(arr[j + 1]) > 0) {

                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("\nSorted Tasks:");

        for (String task : arr) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n=== ATHENAEUM OF UNFINISHED THINGS ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Undo Task");
            System.out.println("4. Add Focus Session");
            System.out.println("5. Start Session");
            System.out.println("6. Add Tag");
            System.out.println("7. View Tags");
            System.out.println("8. Search Task");
            System.out.println("9. Sort Tasks");
            System.out.println("10. Exit");

            System.out.print("Choose option: ");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        addTask();
                        break;

                    case 2:
                        viewTasks();
                        break;

                    case 3:
                        undoTask();
                        break;

                    case 4:
                        addSession();
                        break;

                    case 5:
                        startSession();
                        break;

                    case 6:
                        addTag();
                        break;

                    case 7:
                        viewTags();
                        break;

                    case 8:
                        searchTask();
                        break;

                    case 9:
                        sortTasks();
                        break;

                    case 10:
                        System.out.println("Exiting application...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}