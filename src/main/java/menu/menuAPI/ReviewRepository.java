package menu.menuAPI;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
	  Review findBy_id(ObjectId _id);
	  List<Review> findByUserId(String UserId);
	  List<Review> findByDishId(String DishId);
	}