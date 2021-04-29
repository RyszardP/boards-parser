package io.ryszardp.beans;

import javax.persistence.*;

@Entity
@Table(name = "nastolki_by")
public class Item implements BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String price;
    private String age;
    private String games_quantity;
    private String link;

    public Item() {
    }

    public Item(Long id, String title, String price, String age, String games_quantity, String link) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.age = age;
        this.games_quantity = games_quantity;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getAge() {
        return age;
    }

    public String getGames_quantity() {
        return games_quantity;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", age='" + age + '\'' +
                ", games_quantity='" + games_quantity + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public Boolean getDeleted() {
        return null;
    }

    @Override
    public void setDeleted(Boolean deleted) {

    }
}
