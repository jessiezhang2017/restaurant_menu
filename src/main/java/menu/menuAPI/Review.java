package menu.menuAPI;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Review {
	@Id
	private ObjectId _id;
	
	private String userId;
	private String dishId;
    private String userName;
    private int rating;
    private String comment;
    
    private String dishName;
    private String restaurantName;

    protected Review() {
    }

    public Review(ObjectId _id, String dishId, String userId, String userName, int rating, String comment) {
    	this._id = _id;
    	this.dishId = dishId;
    	this.userId = userId;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
        this.dishName = "";
        this.restaurantName ="";
    }
    
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }
    
    public String getDishId() {
        return dishId;
    }
    
    public void setDishId(String id) {
        this.dishId = id;
    }
    
    public String getDishName() {
        return dishName;
    }
    
    public void setDishName(String name) {
        this.dishName = name;
    }
    
    public String getRestaurantName() {
        return restaurantName;
    }
    
    public void setRestaurantName(String name) {
        this.restaurantName = name;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String name) {
        this.userName = name;
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