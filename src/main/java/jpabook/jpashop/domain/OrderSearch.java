package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

    private String memberName;  // 회원이름 : parameter가 존재하면 where문으로 검색
    private OrderStatus orderStatus;    // 주문 상태[ORDER, CANCEL]
}
