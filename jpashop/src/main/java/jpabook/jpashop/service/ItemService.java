package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, Book bookParam) {
        Item findItem = itemRepository.findOne(itemId);
        findItem.setPrice(bookParam.getPrice());
        findItem.setName(bookParam.getName());
        //itemRepository.save(findItem);
        //@Transactionla에 의해 commit, jpa는 flush(영속성 엔티티읩 변경사항 감지)
        //update쿼리 자동 생성
        // ==> 변경 감지 방식
        // ==> 머지 쓰면 같은 매커니즘으로 동작
        //변경 감지는 원하는 속성만 선택 가능, 머지는 모든 필드가 다 바뀜(선택적 변경 불가) -> 조심해야함
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}

//단순히 repository에 위임만 하는 경우 controller에서 바로 접근하는 게 더 효율적
//이 경우 service의 존재 의미 생각해볼 필요