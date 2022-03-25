package com.shop.repository;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품저장 테스트")
    public void createItemTest(){

        Item item = new Item();

        item.setItemNm("홍길동"); // 성명
        item.setPrice(123000);   //가격
        item.setStockNumber(2500); //재고수량
        item.setItemDetail("연습"); //상품 상세 설명
        item.setItemSellStatus(ItemSellStatus.SELL); //상품 판매 상태
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());

        Item SavedItem = itemRepository.save(item);
        System.out.println(SavedItem.toString());

    }

    public void createItemList() {

        this.createItemTest();

        for(int i=1;i<=10;i++) {

            Item item = new Item();

            item.setItemNm("테스트상품" + i); // 성명
            item.setPrice(123000 + i);   //가격
            item.setStockNumber(2500 + i); //재고수량
            item.setItemDetail("연습" + i); //상품 상세 설명
            item.setItemSellStatus(ItemSellStatus.SELL); //상품 판매 상태
//            item.setStocNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());

            Item SavedItem = itemRepository.save(item);

            System.out.println(SavedItem.toString());
        }
    }

    @Test
    @DisplayName("상품저장 테스트")
    public void findByItemTest(){

        this.createItemList();
        List<Item> itemList = itemRepository.findByItemNm("테스트상품1");

        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

}