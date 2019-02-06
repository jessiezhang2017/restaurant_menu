package menu.menuAPI;
 
//import menu.menuAPI.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.stream.Collectors;
import java.util.stream.Stream;


//set up the class as a service
@Service
public class RestClientService {

  //define a RestTemplate object
  private final RestTemplate restTemplate;

  //web service resources endpoints
  private static final String GET_URL_ONE = "https://developers.zomato.com/api/v2.1/restaurant?res_id=";
  private static final String GET_URL_ALL = "https://developers.zomato.com/api/v2.1/search?entity_id=279&entity_type=city&cuisines=";
  private static final String GET_URL2 = "&start=";

  //define an argument constructor, pass in the RestTemplate object
  //and Autowire it
  
  @Autowired
  public RestClientService(RestTemplate restTemplate){
      this.restTemplate = restTemplate;
  }

  public List<Restaurant> findAllRestaurants(String id, String start) throws JsonParseException, JsonMappingException, IOException{
	  
	//Set the headers you need send
	  final HttpHeaders headers = new HttpHeaders();
	  
	  Dotenv userkey = Dotenv.load();
	  String key=userkey.get("USER_KEY");
//	  headers.set("user-key", "e0da88217d6a3bdb53e6142fee4de191");
	  headers.set("user-key", key);
	  
	 //Create a new HttpEntity
	  final HttpEntity<String> entity = new HttpEntity<String>(headers); 
	  
    
	    
	    ResponseEntity<JsonNode> transResponse = restTemplate.exchange(GET_URL_ALL+id+GET_URL2+start, HttpMethod.GET,
	            entity, JsonNode.class);
	    
	    
	    System.out.println(transResponse);
	    
	    JsonNode transResult = transResponse.getBody().path("restaurants");
	       
	  
	    System.out.println(transResult);
	    
	    ObjectMapper om = new ObjectMapper();
    	
	    //Set pretty printing of json
	    om.enable(SerializationFeature.INDENT_OUTPUT);
	    om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	
    	TypeReference<List <Map <String, Restaurant> >> mapType = new TypeReference<List <Map <String, Restaurant> >>() {};
    	
    	List <Map <String, Restaurant>> restaurants_searched = om.readValue(transResult.toString(), mapType);
    	
    	List <Restaurant> restaurants = new ArrayList<> ();
    	
    	for ( Map <String, Restaurant> restaurants_list: restaurants_searched) {
    		restaurants.add(restaurants_list.get("restaurant"));
    	}
    	
    	return restaurants;
	    
  }
 
  
  public Restaurant findRestaurantById(String id) throws JsonParseException, JsonMappingException, IOException{
	 //Set the headers you need send
	  final HttpHeaders headers = new HttpHeaders();
	  headers.set("user-key", "e0da88217d6a3bdb53e6142fee4de191");
	  
	 //Create a new HttpEntity
	  final HttpEntity<String> entity = new HttpEntity<String>(headers);
	    	    	  
	  
	  ResponseEntity<String> transResponse = restTemplate.exchange(GET_URL_ONE+id, HttpMethod.GET, entity, String.class);
	 
	  String transaction = transResponse.getBody();
	 
  
	  ObjectMapper om = new ObjectMapper();
	  
	  om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	  
	 
	  Restaurant restaurant_selected = om.readValue(transaction, Restaurant.class);
	  
 
	  
	  return restaurant_selected;
	 

   }

}
  



    

    
   
 
