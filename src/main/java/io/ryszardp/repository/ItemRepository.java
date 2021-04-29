package io.ryszardp.repository;

import io.ryszardp.beans.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAllByAge(String age);

    List<Item> findAllByAgeAfter(String age);

    List<Item> findAllByGames_quantity(String gamersQuantity);

    List<Item> findAllByPrice(String price);

    List<Item> findAllByPriceAfter(String price);

    List<Item> findAllByPriceBefore(String price);

    List<Item> findAllByPriceBetween(String priceMin, String priceMax);

    Item findByTitle(long name);
}
