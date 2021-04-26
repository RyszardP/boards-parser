package io.ryszardp.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class P2 {
    private static Document getPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 15000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage("http://www.nastolki.by/все-игры/ужас-аркхэма.-карточная-игра-забытая-эпоха.-город-архивов-дополнение/");
        System.out.println(page);
    }
}
