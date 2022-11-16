package ro.mta.ip.tema_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyThread extends Thread{
    private final Socket clientSocket;

    public MyThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        /*luam arraylist de humans*/
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Profesor> profesors = new ArrayList<Profesor>();

        try {

            // get the outputstream of client
            out = new PrintWriter(
                    clientSocket.getOutputStream(), true);

            // get the inputstream of client
            in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {

                if(line.contains("Student")){
                    students.add(new Student(line));
                }
                else if(line.contains("Profesor")){
                    profesors.add(new Profesor(line));
                }
                else if(line.equals("exit")){
                    students.sort(Collections.reverseOrder());
                    profesors.sort(Collections.reverseOrder());
                    String all_Students = new String("");
                    String all_Profs = new String("");
                    for(Student s : students){
                        //out.println(s.toString());
                        //out.print(s.toString());
                        all_Students += s;
                        all_Students += "\n";

                    }
                    for(Profesor p : profesors){
                        //out.println(p.toString());
                        //out.print(p.toString());
                        all_Profs += p;
                        all_Profs += "\n";
                    }
                    if(!all_Students.isEmpty())
                        out.print(all_Students);
                    if(!all_Profs.isEmpty())
                        out.print(all_Profs);

                }

                // writing the received message from
                // client
                System.out.printf(
                        " Sent from the client: %s\n",
                        line);
                out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                    clientSocket.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
