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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewContoller {
	@Autowired
	  private ReviewRepository repository;
	  
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

	    return repository.findByUserId(userId);
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
