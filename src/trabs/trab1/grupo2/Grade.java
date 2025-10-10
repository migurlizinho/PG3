package trabs.trab1.grupo2;

public abstract class Grade implements Comparable<Grade>{
    protected Type type;
    private String name;

    public Grade(Type type){
        this.type = type;
    }

    public String getName(){
        return type.getName();
    }

    public boolean isApproved(){
        return this.getGrade() >= type.getMinimum();
    }

    @Override
    public int compareTo(Grade o){
        return this.getGrade() - o.getGrade();
    };

    public abstract int getGrade();

    public final String toString() { return getName()+ (isApproved()? " - " : " - R ") + getGrade(); }

    public void list( String prefix ){ System.out.println( prefix + this ); }
}