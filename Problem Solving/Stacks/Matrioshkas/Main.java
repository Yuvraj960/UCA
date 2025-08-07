import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // For each line of input (until EOF)
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println(":-) Matrioshka!");
                continue;
            }
            System.out.println(checkMatrioshka(line));
        }
    }

    static String checkMatrioshka(String line) {
        String[] numbers = line.split("\\s+");
        Stack<Integer> dolls = new Stack<>(); // Stores currently open doll sizes
        Stack<Integer> sumStack = new Stack<>(); // Stores current sum of inner dolls
        sumStack.push(0); // Initialize with 0 for the outermost context

        try {
            for (String numStr : numbers) {
                int n = Integer.parseInt(numStr);
                if (n < 0) {
                    dolls.push(-n);    // Start a new doll of size -n
                    sumStack.push(0);  // Track sum of inner dolls for this new doll
                } else {
                    if (dolls.isEmpty() || dolls.peek() != n) {
                        return ":-( Try again."; // No doll to close or mismatched closing
                    }
                    dolls.pop();
                    int childrenSum = sumStack.pop();

                    if (childrenSum >= n) return ":-( Try again."; // Inner dolls too big

                    // Add this closed doll's size to the sum for its parent (if it exists)
                    sumStack.push(sumStack.pop() + n);
                }
            }
        } catch (Exception e) {
            return ":-( Try again."; // Catch parsing errors etc.
        }

        // All dolls must be closed (stacks empty except the initialized sumStack)
        return (dolls.isEmpty() && sumStack.size() == 1) ? ":-) Matrioshka!" : ":-( Try again.";
    }
}
