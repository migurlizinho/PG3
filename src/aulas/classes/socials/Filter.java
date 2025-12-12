package aulas.classes.socials;

public abstract class Filter {
    private String filterName;

    public Filter(){
        this.filterName = "unknown";
    }

    public Filter(String filterName){
        this.filterName = filterName;
    }

    public abstract Group filtering(Group group);

    @Override
    public String toString() {
        return this.filterName;
    }
}
