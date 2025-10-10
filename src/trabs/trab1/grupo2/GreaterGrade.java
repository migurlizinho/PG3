package trabs.trab1.grupo2;

public class GreaterGrade extends MG{
    public GreaterGrade(Type type, Grade... sequence) throws GradeException{
        super(type, sequence);
    }

    @Override
    public int getGrade() {
        return greater(this.getSequence()).getGrade();
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
        for (Grade grade : getSequence()) {
            grade.list("  ");
        }
    }
}