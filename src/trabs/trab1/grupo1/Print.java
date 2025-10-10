package trabs.trab1.grupo1;

import trabs.trab1.grupo2.SG;

public class Print {
  public static void main(String[] args) {
    Student s1 = new Student(1, "aa", new SG(10, null));
    Student s2 = new Student(1, "aa", new SG(10, null));
    Student s3 = s2; // Alterar
    System.out.println(s1);
    System.out.println(s1.equals(s3));
    System.out.println(s1.equals(s3));

    System.out.println("");

    String stringToParse = "52573: Miguel - 10";
    System.out.println("String parsed : " + "\"" + stringToParse + "\"");
    Student s4 = Student.parseStudent(stringToParse);

    System.out.println("Name: " + "\"" + s4.getName() + "\"");
    System.out.println("Number: " + "\"" + s4.getNumber() + "\"");
    System.out.println("Grade: " + "\"" + s4.getGrade() + "\"");
  }
}
