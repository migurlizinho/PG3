package aulas.classes.socials;

public interface Contact extends Comparable<Contact>{
    String name = new String("unknown");
    int age = 0;

    int getAge();
}
