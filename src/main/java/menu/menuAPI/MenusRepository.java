package menu.menuAPI;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MenusRepository extends MongoRepository<Menus, String> {
  Menus findBy_id(ObjectId _id);
  List<Menus> findByRestaurantId(String restaurantId);
  

}