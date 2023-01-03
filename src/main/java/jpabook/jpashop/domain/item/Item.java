package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   // 한 테이블에 쿼리 다 넣고 실행
@DiscriminatorColumn(name = "dtype")    // book, album, movie 선택
@Getter @Setter
public abstract class Item {    // 구현체로 구현할 예정이기 때문에 추상클래스로 선언

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
