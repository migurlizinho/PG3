package trabs.trab1.grupo2;

public class SG extends Grade{
    private final int grade;

    public SG(int grade, Type type){
        super(type);
        this.grade = grade;
    }

    public SG(int grade, String name, int minimum){
        super(new Proof(name, minimum));
        this.grade = grade;
    }

    @Override
    public int getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Grade))
            return false;
        return this.getGrade() == ((Grade) obj).getGrade() &&
                this.getName().equals(((Grade) obj).getName());
    }
}