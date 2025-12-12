package aulas.classes.socials;

public class SimpleFilter extends Filter{

    public SimpleFilter(String filterName){
        super(filterName);
    }

    @Override
    public Group filtering(Group group) {
        return null;
    }

    public boolean validate(Contact contact){
        return false;
    }
}
