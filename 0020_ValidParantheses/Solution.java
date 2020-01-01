import java.util.HashMap;
import java.util.Stack;
public class Solution {
  // Hash table that takes care of the mappings.
  private HashMap<Character, Character> mappings;

  // Initialize hash map with mappings. This simply makes the code easier to read.
  public Solution() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (this.mappings.containsKey(ch)) {
        // dummy charactor '$'
        char topElement = stack.empty() ? '$' : stack.pop();
        System.out.println(topElement);
        if (topElement != this.mappings.get(ch)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(ch);
      }
    }
    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }
}