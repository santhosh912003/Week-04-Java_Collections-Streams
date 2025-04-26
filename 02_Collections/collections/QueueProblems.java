import java.util.*;

class QueueProblems {

    public static <T> Queue<T> reverseQueue(Queue<T> q) {
        Stack<T> stack = new Stack<>();
        while (!q.isEmpty()) stack.push(q.poll());
        while (!stack.isEmpty()) q.add(stack.pop());
        return q;
    }

    public static List<String> generateBinaryNumbers(int n) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for (int i = 0; i < n; i++) {
            String curr = q.poll();
            res.add(curr);
            q.add(curr + "0");
            q.add(curr + "1");
        }
        return res;
    }

    static class Patient implements Comparable<Patient> {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public int compareTo(Patient other) {
            return Integer.compare(other.severity, this.severity);
        }
    }

    public static List<String> hospitalTriage(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(patients);
        List<String> order = new ArrayList<>();
        while (!pq.isEmpty()) {
            order.add(pq.poll().name);
        }
        return order;
    }

    static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int c) {
            q2.add(c);
            while (!q1.isEmpty()) q2.add(q1.poll());
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }
    }

    static class CircularBuffer {
        int[] buff;
        int size, start = 0, count = 0;

        CircularBuffer(int size) {
            this.size = size;
            buff = new int[size];
        }

        void insert(int val) {
            buff[(start + count) % size] = val;
            if (count < size) count++;
            else start = (start + 1) % size;
        }

        int[] getBuffer() {
            int[] res = new int[count];
            for (int i = 0; i < count; i++) {
                res[i] = buff[(start + i) % size];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Reversed Queue: " + reverseQueue(q));

        System.out.println("Binary Numbers: " + generateBinaryNumbers(5));

        List<Patient> patients = Arrays.asList(
                new Patient("John", 3),
                new Patient("Alice", 5),
                new Patient("Bob", 2));

        System.out.println("Triage Order: " + hospitalTriage(patients));

        StackUsingQueues st = new StackUsingQueues();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println("Stack pop: " + st.pop());

        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);

        System.out.println("Circular Buffer: " + Arrays.toString(cb.getBuffer()));
    }
} 
