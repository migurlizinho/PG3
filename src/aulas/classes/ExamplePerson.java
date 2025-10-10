package aulas.classes;

public class ExamplePerson {

  public static void main(String[] args) {

    Person p = new Person("foo", 1);
    p.setAge(20);
    p.writeOutput();
    Person p1 = new Person("bar", 2);
    p1.setAge(25);
    p1.writeOutput();

    System.out.println("toString: ");
    System.out.println(p.toString());
    System.out.println(p1.toString());

    System.out.println("equals: ");
    System.out.println(p.equals(p));
    System.out.println(p.equals(p1));
  }
}
