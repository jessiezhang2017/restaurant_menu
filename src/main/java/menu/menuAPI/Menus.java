package menu.menuAPI;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Menus {
  @Id
  public ObjectId _id;
  
  public String name;
  public double price;
  

  private List<Review> reviews;
  
  // Constructors 
  private Menus() {
      this.reviews = new ArrayList<>();
  }

  
  public Menus(ObjectId _id, String name, double price, List<Review> reviews) {
    this._id = _id;
    this.name = name;
    this.price = price;
    this.reviews = reviews;
  }
  
  // ObjectId needs to be converted to string
  public String get_id() { return _id.toHexString(); }
  public void set_id(ObjectId _id) { this._id = _id; }
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  
  public double getPrice() { return price; }
  public void setPrice(double price) { this.price = price; }
  
  public List<Review> getReviews() {
      return this.reviews;
  }
  public void addReview(Review review) { this.reviews.add(review); }
}
