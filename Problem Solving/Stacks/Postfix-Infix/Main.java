import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        sc.nextLine(); // Skip the empty line after test case count

        for(int t = 0; t < testCases; t++) {
            List<String> lines = new ArrayList<>();
            // Read one test case (ends on empty line)
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.isEmpty()) break;
                lines.add(line);
            }

            System.out.println(infixToPostfix(lines));

            if(t != testCases-1) System.out.println(); // Blank line between test cases
        }
        sc.close();
    }

    // Helper method: infix-to-postfix for a list of tokens (lines)
    static String infixToPostfix(List<String> tokens) {
        StringBuilder output = new StringBuilder();
        Stack<String> stack = new Stack<>();
        Map<String, Integer> precedence = Map.of(
            "+", 1, "-", 1,
            "*", 2, "/", 2
        );

        for(String token : tokens) {
            if(token.chars().allMatch(Character::isDigit)) {
                output.append(token);
            } else if(token.equals("(")) {
                stack.push(token);
            } else if(token.equals(")")) {
                while(!stack.peek().equals("(")) output.append(stack.pop());
                stack.pop(); // Remove "("
            } else { // operator
                while(!stack.isEmpty() && precedence.getOrDefault(stack.peek(), 0) >= precedence.getOrDefault(token, 0)) {
                    output.append(stack.pop());
                }
                stack.push(token);
            }
        }
        // Pop remaining ops
        while(!stack.isEmpty()) output.append(stack.pop());
        return output.toString();
    }
}
