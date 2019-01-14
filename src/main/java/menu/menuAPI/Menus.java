package menu.menuAPI;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Menus {
  @Id
  private ObjectId _id;
  
  private String name;

  private String restaurantId;
  private List<Review> reviews;
  
  // Constructors 
  private Menus() {
      this.reviews = new ArrayList<>();
  }

  
  public Menus(ObjectId _id, String name,  String restaurantId) {
    this._id = _id;
    this.name = name;
    
    this.restaurantId = restaurantId;
    
  }
  
  // ObjectId needs to be converted to string
  public String get_id() { return _id.toHexString(); }
  public void set_id(ObjectId _id) { this._id = _id; }
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  
  
  public String getRestaurantId() { return restaurantId; }
  public void setRestaurantId(String restaurantId) { this.restaurantId = restaurantId; }
  
  public List<Review> getReviews() {
      return this.reviews;
  }
  public void addReview(Review review) { 
	  this.reviews.add(review); 
  }
  
  public double getOverallRating() {
	  double sum = 0;
	  for (Review rev:reviews) {
		  sum = rev.getRating();
	  }
	  
	  double average_rate = sum / reviews.size();
	  return average_rate;
	  
  }
  
}
