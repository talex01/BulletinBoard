package org.watcher.bulletinboard.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.watcher.bulletinboard.Models.Bulletin;
import org.watcher.bulletinboard.Models.Category;
import org.watcher.bulletinboard.Repositories.BulletinRepository;
import org.watcher.bulletinboard.Repositories.CategoryRepository;

@Controller
public class HomeController {

    private final CategoryRepository categoryRepository;
    private final BulletinRepository bulletinRepository;

    @Autowired
    public HomeController(CategoryRepository categoryRepository, BulletinRepository bulletinRepository) {
        this.categoryRepository = categoryRepository;
        this.bulletinRepository = bulletinRepository;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {

        String[] categories = {"Авто-мото", "Недвижимость", "Знакомства"};

        for (String s : categories) {
            if (categoryRepository.findCategoryByName(s) == null)
                categoryRepository.save(new Category(s));
        }

        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @RequestMapping(path = "/addBulletin")
    public String addBulletin(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "newbulletin";
    }

    @RequestMapping(path = "/addBulletin", method = RequestMethod.POST)
    public String addBulletinPOST(Model model, @RequestParam("category") Long category,
                                  @RequestParam("content") String content, @RequestParam("phone") String phone) {

        System.out.println("category: " + category + " content: " + content + " phone: " + phone);
        bulletinRepository.save(new Bulletin(content, phone, categoryRepository.findOne(category)));
        return "index";
    }
}
