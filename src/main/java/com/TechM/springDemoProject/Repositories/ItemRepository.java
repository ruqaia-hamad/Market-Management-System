package com.TechM.springDemoProject.Repositories;
import com.TechM.springDemoProject.Models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository  extends CrudRepository<Item,Integer> {
    @Query(value="SELECT m FROM Item m")
    List<Item> getAllItems();
}
