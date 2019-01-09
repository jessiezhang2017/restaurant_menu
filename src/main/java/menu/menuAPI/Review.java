package menu.menuAPI;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Review {
    private String userName;
    private int rating;
    private String comment;
    
//    private boolean approved;

    protected Review() {
    }

    public Review(String userName, int rating, String comment) {
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
//        this.approved = approved;
    }

    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
//    public boolean isApproved() {
//        return approved;
//    }
}