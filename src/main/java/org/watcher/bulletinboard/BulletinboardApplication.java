package org.watcher.bulletinboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.watcher.bulletinboard.Models.Category;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class BulletinboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BulletinboardApplication.class, args);
    }
}
