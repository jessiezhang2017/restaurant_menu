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
@RequestMapping("/menus")
public class MenusController {
  @Autowired
  private MenusRepository repository;
  
  @GetMapping( "/")
  public List<Menus> getAllMenus() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Menus getMenuBy_id(@PathVariable("id") ObjectId id) {
	  
    return repository.findBy_id(id);
  }
  
  @GetMapping("/restaurants/{restaurantId}")
  public List<Menus> getMenusByRestaurantId(@PathVariable("restaurantId") String restaurantId) {

    return repository.findByRestaurantId(restaurantId);
  }
  
  @PutMapping(value = "/{id}")
  public void modifyMenuById(@PathVariable("id") ObjectId id, @Valid @RequestBody Menus menus) {
    menus.set_id(id);
   
    repository.save(menus);
  }
  
  @PostMapping(value = "/")
  public Menus createMenu(@Valid @RequestBody Menus menus) {
    menus.set_id(ObjectId.get());
    repository.save(menus);
    return menus;
  }
  
  @DeleteMapping("/{id}")
  public void deleteMenu(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}