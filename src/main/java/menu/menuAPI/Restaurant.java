package menu.menuAPI;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)


public class Restaurant {
//  @Id
//  private ObjectId _id;
  
  @JsonProperty(value="name")
  private String name;
  
  @JsonProperty(value="id")
  private String id;
 
  @JsonProperty(value="location")
  private Location location; 
 
  @JsonProperty(value="menu_url")
  private String menu_url;
 
  @JsonProperty(value="url")
  private String url;
  
  @JsonProperty(value="thumb")
  private String thumb;
  
  @JsonProperty(value="user_rating")
  private Rating rating;
 
//  private List<Menus> menus;

  //Constructors 
   private Restaurant() {
	     
   }


  public Restaurant(String name, String id,String menu_url, String url,String thumb, Location location, Rating rating) {
//    this._id = _id;
    this.name = name;
    this.id = id;
    this.location = location;
    this.menu_url = menu_url;
    this.url = url;
    this.thumb =thumb;
    this.rating = rating;
  }
  
//  // ObjectId needs to be converted to string
//  public String get_id() { return _id.toHexString(); }

  
  public String getName() { return name; }
  
  public String getId() { return id; }
  
  public Location getLocation() { return location; }
  
  public String getMenu_url() { return menu_url; }
  
  public String getUrl() { return url; }
  
  public String getThumb() { return thumb; }
  
  public Rating getRating() { return rating; }

  
//  public List<Menus> getMenus() {
//      return this.menus;
//  }
//  public void addMenu(Menus menu) { this.menus.add(menu); }
}
