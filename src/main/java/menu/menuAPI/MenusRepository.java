package menu.menuAPI;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenusRepository extends MongoRepository<Menus, String> {
  Menus findBy_id(ObjectId _id);
}