package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.*;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception{
        Member member = createMember();
        Item book = createBook("JPA",10000,10);//이름, 가격, 재고

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        Order getOrder = orderRepository.findOne(orderId);

        assertThat(getOrder.getStatus()).isEqualTo(OrderStatus.ORDER);//주문 상태 확인
        assertThat(getOrder.getOrderItems().size()).isEqualTo(1); //주문한 상품 종류 수가 맞는지
        assertThat(getOrder.getTotalPrice()).isEqualTo(10000*orderCount);
        assertThat(book.getStockQuantity()).isEqualTo(8);
    }

    @Test
    public void 주문취소() throws Exception{
        Member member = createMember();
        Item book = createBook("JPA",10000,10);

        int orderCount=2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        orderService.cancelOrder(orderId);

        Order getOrder = orderRepository.findOne(orderId);

        assertThat(getOrder.getStatus()).isEqualTo(OrderStatus.CANCEL);
        assertThat(book.getStockQuantity()).isEqualTo(10);
    }

    @Test
    public void 상품주문_재고수량초과() throws Exception{
        Member member = createMember();
        Item book = createBook("JPA",10000,10);

        int orderCount=11;

        assertThatThrownBy(()-> orderService.order(member.getId(), book.getId(), orderCount))
                .isInstanceOf(IllegalStateException.class);
    }

    private Member createMember(){
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","강남","123-123"));
        em.persist(member);
        return member;
    }

    private Item createBook(String name, int price, int stockQuantity){
        Item book = new Item();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }
}
