package menu.menuAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Location {
	
	 @JsonProperty(value="address")
	  private String address;
	  
	  @JsonProperty(value="latitude")
	  private String latitude;
	 
	  @JsonProperty(value="longitude")
	  private String longitude;
	 
	  
	  // Constructors 
	  private Location() {
	     
	  }

	  public Location(String address, String latitude,String longitude) {

	    this.address = address;
	    this.latitude = latitude;
	    this.longitude = longitude;
	   
	  }
	  
	  public String getAddress() { return address; }
	    
	  public String getLatitude() { return latitude; }
	  
	  public String getLongitude() { return longitude; }
	  


}
