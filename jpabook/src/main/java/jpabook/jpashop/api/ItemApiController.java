package jpabook.jpashop.api;

import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemApiController {

    private final ItemRepository itemRepository;

    @Transactional
    @PostMapping("/api/v2/items")
    public CreateItemResponse saveItemV2(@RequestBody CreateItemRequest request){

        Item item = new Item();
        item.setName(request.getName());
        item.setPrice(request.getPrice());
        item.setStockQuantity(request.getStockQuantity());

        itemRepository.save(item);


        return new CreateItemResponse(item.getId());
    }

    @GetMapping("/api/v2/items")
    public List<Item> itemsV2(){
        List<Item> list = new ArrayList<>();

        //임시
        Item findItem = new Item();
        findItem.setId(1L);
        findItem.setName("JPA");
        findItem.setPrice(20000);
        findItem.setStockQuantity(50);
        list.add(findItem);

        return list;
    }

    @Data
    static class CreateItemResponse{
        private Long id;

        public CreateItemResponse(Long id){
            this.id = id;
        }
    }

    @Data
    public class CreateItemRequest{
        private String name;
        private int price;
        private int stockQuantity;
    }
}
