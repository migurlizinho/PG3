package trabs.trab1.grupo2;

public class GreaterGrade extends MG{
    Grade max;
    public GreaterGrade(Type type, Grade... sequence) throws GradeException{
        super(type, sequence);
        max = greater(sequence);
    }

    @Override
    public int getGrade() {
        return max.getGrade();
    }

    @Override
    public boolean isApproved() {
        for (Grade grade : getSequence()) {
           if(grade.isApproved())
                return super.isApproved();
        }
        return false;
    }

    @Override
    public void list(String prefix) {
        super.list(prefix);
        max.list(prefix);
    }
}