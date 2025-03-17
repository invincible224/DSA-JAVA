import java.util.Stack;
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (Math.abs(asteroid) > stack.peek()) {
                    stack.pop();  // Right-moving asteroid explodes
                } else if (Math.abs(asteroid) == stack.peek()) {
                    stack.pop();  // Both explode
                    alive = false;
                    break;
                } else {
                    alive = false;  // Left-moving asteroid explodes
                    break;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] result = asteroidCollision(asteroids);

        for (int asteroid : result) {
            System.out.print(asteroid + " ");
        }
    }
}

