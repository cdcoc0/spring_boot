package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member; //연관관계 주인

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItem = new ArrayList<>();

    @OneToOne
    //1 : 1관계인 경우 액세스 빈도수가 많은 곳에 포린키
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

//    private Date date;
    private LocalDateTime orderDate; //주문 시간, hibernate가 알아서 날짜 관련 매핑 지원

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문 상태 [ORDER, CANCEL]
}
