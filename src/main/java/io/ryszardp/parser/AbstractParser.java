package io.ryszardp.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class AbstractParser {

    private static Document getPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 15000);
        return page;
    }


}
