package aulas.classes.socials;

public class CompositeFilter extends Filter{
    Filter[] filters;

    public CompositeFilter(){
        this.filters = new Filter[0];
    }

    public CompositeFilter(String filterName, Filter[] filters){
        super(filterName);
        this.filters = filters;
    }

    @Override
    public Group filtering(Group group) {
        return null;
    }
}
