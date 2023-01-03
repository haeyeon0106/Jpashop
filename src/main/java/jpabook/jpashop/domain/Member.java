package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue // sequence값
    @Column(name = "member_id")
    private Long id;
    private String name;

    @Embedded   // 내장타입
    private Address address;

    @OneToMany(mappedBy = "member") // order 안의 member에 의해 mapping 됨(읽기전용)
    private List<Order>orders = new ArrayList<>();
}
