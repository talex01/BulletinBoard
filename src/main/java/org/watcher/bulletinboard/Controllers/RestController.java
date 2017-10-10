package org.watcher.bulletinboard.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.watcher.bulletinboard.Models.Bulletin;
import org.watcher.bulletinboard.Repositories.BulletinRepository;
import org.watcher.bulletinboard.Repositories.CategoryRepository;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final BulletinRepository bulletinRepository;
    private final CategoryRepository categoryRepository;

    public RestController(BulletinRepository bulletinRepository, CategoryRepository categoryRepository) {
        this.bulletinRepository = bulletinRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(path = "/api/getBulletinById", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Bulletin> getBulletinById(@RequestParam(value = "id", defaultValue = "0") String id){

        if(!id.equals("0")) {
            return bulletinRepository.findBulletinsByCategory(categoryRepository.findOne(Long.parseLong(id)));
        }else {
            return bulletinRepository.findAll();
        }
    }
}
