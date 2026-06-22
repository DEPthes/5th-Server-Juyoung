package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    @GetMapping("/items-view")
    public String itemsView(Model model){
        List<Item> items=new ArrayList<>();

        Item item1=new Item();
        item1.setId(1L);
        item1.setName("JPA");
        item1.setPrice(20000);
        items.add(item1);

        model.addAttribute("items",items);

        return "items";
    }
}
