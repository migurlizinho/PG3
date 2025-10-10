package trabs.trab1.grupo2;

public class AverageGrade extends MG{
    public AverageGrade(Type type, Grade... sequence) throws GradeException{
        super(type, sequence);
    }

    @Override
    public int getGrade() {
        return sum(this.getSequence()) / this.getSequence().length;
    }

    @Override
    public boolean isApproved() {
        for(Grade grade : this.getSequence()){
            if(!grade.isApproved())
                return false;
        }
        return super.isApproved();
    }

    @Override
    public void list(String prefix) {
        super.list(prefix);
        for(Grade grade : this.getSequence()){
            grade.list("  ");
        }
    }
}