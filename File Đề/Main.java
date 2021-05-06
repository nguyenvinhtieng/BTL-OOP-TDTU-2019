import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StudentManagement A1 = new StudentManagement();
        //Doc file DSSV.txt
        A1.readStudent("DSSV.txt");
        //Requirement 1
        Student student1 = new MathStudent("C1502010", "Nguyen An", "Khang","150C0301", 2015, 5.6);
        A1.addStudent(student1);
        Student student2 = new MathStudent("C1702056", "Tran Thi", "Bich", "170C0201", 2017, 8.2);
        A1.addStudent(student2);
        Student student3 = new ITStudent(51603021, "Dinh Minh", "Phu","16050301", 2019, 8.0);
        A1.addStudent(student3);        
        A1.deleteStudentByIndex(2);
        Student student4 = new ITStudent(51903001, "Nguyen Binh", "An","19050301", 2019, 4.0);
        A1.addStudentByIndex(student4,2);
        A1.writeFile("Req1.txt");
        //Requirement 2
        A1.writeFile("Req2.txt",2019);        
        //Requirement 3
        A1.writeFile("Req3.txt","14050302");
        //Requirement 4
        A1.writeFile("Req4.txt","Sort");
    }
}