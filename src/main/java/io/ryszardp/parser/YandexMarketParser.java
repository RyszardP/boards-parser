package io.ryszardp.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class YandexMarketParser {

    private static Document getPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 15000);
        return page;
    }

    private static final String MAIN = "http://www.nastolki.by/2-%D0%B8-%D0%B1%D0%BE%D0%BB%D0%B5%D0%B5-%D0%B8%D0%B3%D1%80%D0%BE%D0%BA%D0%BE%D0%B2-page-";

}
