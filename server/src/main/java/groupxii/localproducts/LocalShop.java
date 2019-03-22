package groupxii.localproducts;

public class LocalShop {

    private String name;
    private String icon;
    private int rating;
    private boolean openNow;

    public LocalShop(String name, String icon, int rating, boolean openNow){
        this.name = name;
        this.icon = icon;
        this.rating = rating;
        this.openNow = openNow;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpenNow(boolean openNow) {
        this.openNow = openNow;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isOpenNow() {
        return openNow;
    }

    public int getRating() {
        return rating;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }
}
