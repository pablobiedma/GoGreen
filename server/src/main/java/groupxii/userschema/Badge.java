package groupxii.userschema;

public class Badge {

    private String icon;
    private int level;

    public Badge(String icon,int level) {
        this.icon = icon;
        this.level = level;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getLevel() {
        return this.level;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
