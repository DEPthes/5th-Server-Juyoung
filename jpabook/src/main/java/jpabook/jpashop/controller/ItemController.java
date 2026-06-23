package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor//생성자 자동 생성
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/items-view")
    public String itemsView(Model model){
//        List<Item> items=new ArrayList<>();
        List<Item> items=itemRepository.findAll();
        Item item1=new Item();
        item1.setId(1L);
        item1.setName("JPA");
        item1.setPrice(20000);
        items.add(item1);

        model.addAttribute("items",items);

        return "items";
    }
}
