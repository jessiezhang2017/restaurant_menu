package menu.menuAPI;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewContoller {
	@Autowired
	  private ReviewRepository repository;
	@Autowired
	  private MenusRepository menuRepo;
	  
	  @GetMapping("/")
	  public List<Review> getAllReview() {
	    return repository.findAll();
	  }

	  @GetMapping("/{id}")
	  public Review getReviewById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	  }
	  
	  @GetMapping("/users/{userId}")
	  public List<Review> getReviewByUserId(@PathVariable("userId") String userId) {
       
		List<Review> reviews = repository.findByUserId(userId);
		
		if (reviews.size() > 0) {
		
		    for (Review review : reviews) {
		   
		    	String dishid = review.getDishId();
		    
		    	Menus item = menuRepo.findBy_id(dishid);
		  
		    	review.setRestaurantName(item.getRestaurantName());
		 
		    	review.setDishName(item.getName());
		    	
		    }
		}
		System.out.println(reviews);
	    return reviews;
	  }
	  
	  @GetMapping("/dishes/{dishId}")
	  public List<Review> getReviewByDishId(@PathVariable("dishId") String dishId) {
       
		List<Review> reviews = repository.findByDishId(dishId);
		
		if (reviews.size() > 0) {
		
		    for (Review review : reviews) {
		   
		    	String dishid = review.getDishId();
		    
		    	Menus item = menuRepo.findBy_id(dishid);
		  
		    	review.setRestaurantName(item.getRestaurantName());
		 
		    	review.setDishName(item.getName());
		    	
		    }
		}
		System.out.println(reviews);
	    return reviews;
	  }
	  
	  @PutMapping("/{id}")
	  public void modifyReviwById(@PathVariable("id") ObjectId id, @Valid @RequestBody Review review){
		review.set_id(id);
	    repository.save(review);
	  }
	  
	  @PostMapping("/")
	  public Review createMenu(@Valid @RequestBody Review review) {
	    review.set_id(ObjectId.get());
	    repository.save(review);
	    return review;
	  }
	  
	  @DeleteMapping("/{id}")
	  public void deleteReview(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }
	  
	 

}


