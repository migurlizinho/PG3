package aulas.classes;

public class Person {
  private final String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  void setAge(int age) {
    if (age >= 0)
      this.age = age;
  }

  @Override
  public String toString() {
    return this.name + ": " + this.age + " years old.";
  }

  @Override
  public boolean equals(Object obj) {
    Person other = (Person) obj;
    return this.name.equals(other.name) &&
        this.age == other.age;
  }

  void writeOutput() {
    System.out.println(this.name + ": " + this.age + " years old.");
  }
}
