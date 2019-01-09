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
  private String zomato_id;
 
//  @JsonProperty(value="location")
//  private String location; 
 
  @JsonProperty(value="menu_url")
  private String menu_url;
 
  @JsonProperty(value="photos_url")
  private String photo_url;
 
//  private List<Menus> menus;

  
  // Constructors 
  private Restaurant() {
     
  }

  public Restaurant(String name, String zomato_id,String menu_url, String photo_url) {
//    this._id = _id;
    this.name = name;
    this.zomato_id = zomato_id;
//    this.location = location;
    this.menu_url = menu_url;
    this.photo_url = photo_url;
  }
  
//  // ObjectId needs to be converted to string
//  public String get_id() { return _id.toHexString(); }

  
  public String getName() { return name; }
  
  
  public String getZomatoId() { return zomato_id; }
  
//  public String getLocation() { return location; }
  
  public String getMenuUrl() { return menu_url; }
  
  public String getPhotoUrl() { return photo_url; }

  
//  public List<Menus> getMenus() {
//      return this.menus;
//  }
//  public void addMenu(Menus menu) { this.menus.add(menu); }
}
