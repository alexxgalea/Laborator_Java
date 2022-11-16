package ro.mta.ip.tema_java;

import java.util.StringTokenizer;

public class Profesor extends Human implements Comparable<Profesor>{
    protected String acronym;
    protected String materie;

    @Override
    public String toString() {
        return "[Prof." + this.lastName + " " + this.firstName + ", Fac. " + this.acronym + ", Varsta " + this.age + ", Materie predata " + this.materie + "]";
    }

    @Override
    public int compareTo(Profesor o) {
        return this.getAge().compareTo(o.getAge());
    }

    public Profesor(String dataString) {
        StringTokenizer st = new StringTokenizer(dataString," ");
        st.nextToken(); //primul token e Student/Profesor
        this.lastName = st.nextToken();
        this.firstName = st.nextToken();
        this.acronym = st.nextToken();
        this.age= Integer.parseInt(st.nextToken());
        this.materie = st.nextToken();
    }
}
