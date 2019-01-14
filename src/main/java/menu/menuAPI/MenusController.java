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
@RequestMapping("/menus")
public class MenusController {
  @Autowired
  private MenusRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET,produces = "application/json")
  public List<Menus> getAllMenus() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = "application/json")
  public Menus getMenuBy_id(@PathVariable("id") ObjectId id) {
	  
    return repository.findBy_id(id);
  }
  
  @RequestMapping(value = "/?restaurant={id}", method = RequestMethod.GET, produces = "application/json")
  public List<Menus> getMenusByRestaurantId(@PathVariable("id") String id) {
//    System.out.println("test");
    return repository.findByRestaurantId(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyMenuById(@PathVariable("id") ObjectId id, @Valid @RequestBody Menus menus) {
    menus.set_id(id);
   
    repository.save(menus);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Menus createMenu(@Valid @RequestBody Menus menus) {
    menus.set_id(ObjectId.get());
    repository.save(menus);
    return menus;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteMenu(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}