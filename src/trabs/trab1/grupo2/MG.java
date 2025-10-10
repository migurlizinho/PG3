package trabs.trab1.grupo2;

public abstract class MG extends Grade{
    private Grade[] sequence;

    protected MG(Type type, Grade... sequence) throws GradeException{
        super(type);
        if(sequence.length < 2)
            throw new GradeException("Sequência com menos de 2 parametros");
        this.sequence = sequence;
    }

    public Grade[] getSequence() {
        return sequence;
    }

    public static Grade greater(Grade... sequence){
        Grade max = sequence[0];
        for(Grade grade : sequence){
            if(max.getGrade() < grade.getGrade())
                max = grade;
        }
        return max;
    }

    public static int sum(Grade... sequence){
        int sum = 0;
        for(Grade grade : sequence){
            sum += grade.getGrade();
        }
        return sum;
    }
}