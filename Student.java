import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
 class Student implements Comparable<Student>{
    String name1 = new String();
    double cgpa1;
    int id;
    public Student(String n,double c1,int id1)
    {
        this.name1 = n;
        this.cgpa1 = c1;
        this.id = id1;
    }
    public String getName(){
        return this.name1;
    }
    public int compareTo(Student s)
    {
        if(cgpa1 == s.cgpa1)
        {
            if(name1.compareTo(s.name1) == 0)
            {
                if(id == s.id)
                    return 0;
                else if (id > s.id)
                    return 1;
                else
                    return -1;
            }
            else
                return name1.compareTo(s.name1);
        }
    
        else if(cgpa1 > s.cgpa1)
            return -1;
        else
            return 1;
    }
}
class Priorities{
    public ArrayList<Student> getStudents(List<String> events)
    {
        int n = events.size();
        PriorityQueue<Student> PQ = new PriorityQueue<Student>();
        for(String i:events)
        {
            String[] s = new String[4];
            s = i.split("\\s");
            if(s.length>1)
            {
                PQ.add(new Student(s[1],Double.valueOf(s[2]),Integer.valueOf(s[3])));
            }
            else
            {
                PQ.poll();
            }
        }
        while(PQ.size()>1)
        {
            System.out.println(PQ.poll().name1);
        }
        return new ArrayList<Student>(PQ);
    }
}
/*
 * Create the Student and Priorities classes here.
 */
public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
