package trabs.trab1.grupo1;

import trabs.trab1.grupo2.*;

public class Student {
  private final String name;
  private final int number;
  private Grade grade;
  private static int numberOfStudents = 1;

    public Student(int n, String nm, Grade g) {
        this.name = nm;
        this.number = n;
        this.grade = g;
    }

    public Student(String nm, Grade grade) {
        this.name = nm;
        this.grade = grade;
        this.number = numberOfStudents++;
    }

    public int compareTo(Student other){
        return this.number - other.number;
    }

    public static Student parseStudent(String string){
        /* Formato da String a ser passada:
           <number>: <name> - <grade> <gradeType> <gradeMin> <gradeName>
        */

        // Index do final do numero do aluno na string
        int endOfNumber = string.indexOf(':');

        // Index do final do nome na string
        int endOfName = string.indexOf( '-',endOfNumber);

        //Confirma se temos index validos, segundo o returno do metodo indexOf()
        if(endOfNumber == -1 || endOfName == -1)
            return null;

        // Nome do Student a criar
        // O +2 garante que o char ':' e o espaço em branco antes do nome não fiquem na string final
        String name = string.substring(endOfNumber + 1, endOfName).trim();

        // numero do Student
        int number = Integer.parseInt(string.substring(0, endOfNumber));

        // nota do Student
        // O +2 garante que o char '-' e o espaço em branco depois dele não fique na string final
        int endOfGrade = string.indexOf(' ');
        int gradeInt = Integer.parseInt(string.substring(endOfName + 2, endOfGrade).trim());

        Grade grade = new SG(gradeInt, new Exam("Teste desconhicido"));

        return new Student(number, name, grade);
    }

    public Grade setGrade(Grade grade) {
        Grade oldGrade = this.grade;
        if(grade.getGrade() >= 0 || grade.getGrade() <= 20)
            this.grade = grade;
        return oldGrade;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    public boolean isApproved(){
        return this.grade.isApproved();
    }

    public String toString() {
        return this.number + ": " + this.name + " - " + this.grade;
    }

    public boolean equals(Student other) {
        if(other == null)
            return false;
        return this.number == other.number &&
        this.name.equals(other.name) &&
            this.grade == other.grade;
    }

    public int getNumber() {
        return number;
    }
}