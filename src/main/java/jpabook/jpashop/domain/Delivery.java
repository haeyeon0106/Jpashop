package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded   // 내장타입이기 때문에
    private Address address;

    @Enumerated(EnumType.STRING)    // ORDINAL은 숫자로 저장됨 => 다른 상태가 생성되면 꼬임
    private DeliveryStatus status;  //READY(배송준비) COMP(배송중)
}
