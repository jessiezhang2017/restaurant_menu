package menu.menuAPI;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reviews")

public class ReviewContoller {
	@Autowired
	  private ReviewRepository repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Review> getAllReview() {
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Review getMenuById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	  }
	  
	  @RequestMapping(value = "/{id}/?dish_id={dish_id}&user_id={user_id}&user_name={user_name}&rating={rating}&comment={comment}", method = RequestMethod.PUT)
	  public void modifyMenuById(@PathVariable("id") ObjectId id, @PathVariable("dish_id") String dish_id, @PathVariable("user_id") String user_id, @PathVariable("user_name") String user_name, @PathVariable("rating") int rating, @PathVariable("comment") String comment, @Valid @RequestBody Review review) {
	    review.set_id(id);
	    review.setDish_id(dish_id);
	    review.setUser_id(user_id);
	    review.setUser_name(user_name);
	    review.setRating(rating);
	    review.setComment(comment);
	    repository.save(review);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public Review createMenu(@Valid @RequestBody Review review) {
	    review.set_id(ObjectId.get());
	    repository.save(review);
	    return review;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteReview(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }

}
