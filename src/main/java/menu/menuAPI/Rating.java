package menu.menuAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Rating {
	
	 @JsonProperty(value="aggregate_rating")
	  private String aggregate_rating;
	  
	  @JsonProperty(value="rating_text")
	  private String rating_text;
	  
	  @JsonProperty(value="rating_color")
	  private String rating_color;
	 
	  @JsonProperty(value="votes")
	  private String votes;
	   
	  // Constructors 
	  private Rating() {
	     
	  }

	  public Rating(String aggregate_rating, String rating_text,String rating_color, String votes) {

	    this.aggregate_rating = aggregate_rating;
	    this.rating_text = rating_text;
	    this.rating_color = rating_color;
	    this.votes = votes;
	   
	  }
	  
	  public String getAggregate_rating() { return aggregate_rating; }
	    
	  public String getRating_text() { return rating_text; }
	  
	  public String getRating_color() { return rating_color; }
	  
	  public String getVotes() { return votes; }

}
