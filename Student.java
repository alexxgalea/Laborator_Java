package ro.mta.ip.tema_java;
import java.util.StringTokenizer;

public class Student extends Human implements Comparable<Student>{
   protected String acronym;
   protected Integer anStudiu;

    public Student(String dataString) {
        StringTokenizer st = new StringTokenizer(dataString," ");
        st.nextToken(); //primul token e Student/Profesor
        this.lastName = st.nextToken();
        this.firstName = st.nextToken();
        this.acronym = st.nextToken();
        this.age= Integer.parseInt(st.nextToken());
        this.anStudiu = Integer.parseInt(st.nextToken());
    }

    @Override
    public String toString() {
        return "[Sd. " + this.lastName + " " + this.firstName + ", Anul " + this.anStudiu + ", Fac. " + this.acronym + ", Varsta " + this.age + "]";
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge().compareTo(o.getAge());
    }
}
