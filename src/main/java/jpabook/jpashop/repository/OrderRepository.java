package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    // 주문등록
    public void save(Order order){
        em.persist(order);
    }

    // 주문조회
    /*
        단건 조회
     */
    public Order findOne(Long id){
        return em.find(Order.class,id);
    }

    /*
        검색 단어 조회
     */
    //public List<Order> findAll(OrderSearch orderSearch){}
}
