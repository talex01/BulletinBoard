package org.watcher.bulletinboard.Repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.watcher.bulletinboard.Models.Bulletin;
import org.watcher.bulletinboard.Models.Category;

import java.util.List;

public interface BulletinRepository extends CrudRepository<Bulletin, Long> {

    @Query("select a from Bulletin a where a.bulletinCategory = :category order by a.date desc")
    List<Bulletin> findBulletinsByCategory(@Param("category") Category category);

    @Override
    @Query("select a from Bulletin a order by a.date desc")
    List<Bulletin> findAll();
}
