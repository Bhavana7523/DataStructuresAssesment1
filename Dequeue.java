import java.util.*;
    public class test {
        public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int number1 = in.nextInt();
        int number2 = in.nextInt();
        Deque<Integer> dq = new LinkedList<>();
      HashMap<Integer, Integer> hm = new HashMap<>();
      int maximum = 0;
       for (int i = 0; i < number1; i++) {
         int num = in.nextInt();
         if (i >= number2) {
            int first = dq.removeFirst();
            hm.put(first, hm.get(first) - 1);
            if (hm.get(first) == 0)
                hm.remove(first);
        }
        dq.addLast(num);
        hm.put(num, hm.get(num) == null ? 1 : hm.get(num) + 1);
        maximum = Math.max(maximum, hm.size());
        if (maximum == number2)
            break;
    }
    System.out.println(maximum);
}
    }




