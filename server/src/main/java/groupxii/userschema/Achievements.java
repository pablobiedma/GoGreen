package groupxii.userschema;

public class Achievements {

    private String type;
    private String description;

    public Achievements(String type,String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
