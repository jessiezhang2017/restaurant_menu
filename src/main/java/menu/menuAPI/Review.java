package menu.menuAPI;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Review {
	@Id
	private ObjectId _id;
	
	private String user_id;
	private String dish_id;
    private String user_name;
    private int rating;
    private String comment;
    
//    private boolean approved;

    protected Review() {
    }

    public Review(ObjectId _id, String dish_id, String user_id, String user_name, int rating, String comment) {
    	this._id = _id;
    	this.dish_id = dish_id;
    	this.user_id = user_id;
        this.user_name = user_name;
        this.rating = rating;
        this.comment = comment;
//        this.approved = approved;
    }
    
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }
    
    public String getDish_id() {
        return dish_id;
    }
    
    public void setDish_id(String id) {
        this.dish_id = id;
    }
    
    public String getUser_id() {
        return user_id;
    }
    
    public void setUser_id(String id) {
        this.user_id = id;
    }

    public String getUser_name() {
        return user_name;
    }
    
    public void setUser_name(String name) {
        this.user_name = name;
    }

    public int getRating() {
        return rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
//    public boolean isApproved() {
//        return approved;
//    }
}