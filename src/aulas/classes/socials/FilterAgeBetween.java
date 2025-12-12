package aulas.classes.socials;

public class FilterAgeBetween extends SimpleFilter{
    private int youngerThan;
    private int olderThan;

    public FilterAgeBetween(String filterName, int youngerThan, int olderThan){
        super(filterName);
        this.youngerThan = youngerThan;
        this.olderThan = olderThan;
    }

    @Override
    public boolean validate(Contact contact) {
        return contact.getAge() > olderThan &&
                contact.getAge() < youngerThan;
    }
}
