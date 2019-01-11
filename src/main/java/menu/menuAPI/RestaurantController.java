package menu.menuAPI;


import java.io.IOException;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class RestaurantController {

    //define a service constant
    private final RestClientService service;
   
    @Autowired
    public RestaurantController(RestClientService service){
       this.service = service;
    }
    
    @RequestMapping(value = "/restaurants/cuisine/{id}", method = RequestMethod.GET,produces = "application/json")
    public List<Restaurant> getRestaurantList(@PathVariable("id") String id) throws JsonParseException, JsonMappingException, IOException {
      return service.findAllRestaurants(id);
    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET, produces = "application/json")
    public Restaurant getRestaurantById(@PathVariable("id") String id) throws JsonParseException, JsonMappingException, IOException {
      Restaurant restaurant = service.findRestaurantById(id);
	return restaurant;
    }
     
      

}