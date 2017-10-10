package org.watcher.bulletinboard.Repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.watcher.bulletinboard.Models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("select a from Category a where a.category = :name")
    Category findCategoryByName(@Param("name") String name);

    @Override
    @Query("select a from Category a order by a.category")
    Iterable<Category> findAll();
}
