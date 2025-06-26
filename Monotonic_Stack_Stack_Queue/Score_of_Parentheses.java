public static int scoreOfParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);  // base score

    for (char c : s.toCharArray()) {
        if (c == '(') {
            stack.push(0);  // Start a new score frame
        } else {
            int innerScore = stack.pop();
            int score = (innerScore == 0) ? 1 : 2 * innerScore;
            stack.push(stack.pop() + score);
        }
    }

    return stack.pop();
}
