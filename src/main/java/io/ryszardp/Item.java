package io.ryszardp;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
   private String title;
    private BigDecimal price ;
    private String url ;

    public Item() {
    }

    public Item(String title, BigDecimal price, String url) {
        this.title = title;
        this.price = price;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(title, item.title) &&
                Objects.equals(price, item.price) &&
                Objects.equals(url, item.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, url);
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }
}
