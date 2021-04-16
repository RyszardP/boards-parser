package io.ryszardp.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.ryszardp.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {

    static String boardGamesTitles;
    static String price;

    private static Document getPage() throws IOException {
        String url = "http://www.nastolki.by/%D0%B2%D1%81%D0%B5-%D0%B8%D0%B3%D1%80%D1%8B/";
        Document page = Jsoup.parse(new URL(url), 5000);
        return page;
    }

    public static void main(String[] args) throws Exception {
        Document page = getPage();
        Element tableCont = page.select("#content > div > div.catalog-view-display.catalog-products.spacer.clearfix").first(); // find table

        Elements titles = tableCont.select("div.catalog-product-title");
        //  System.out.println(titles);
        Elements urls = tableCont.select("a");
        //   System.out.println(urls);

//#content > div > div.catalog-view-display.catalog-products.spacer.clearfix > div.catalog-product.catalog-product-8626 > div > div.catalog-product-title > a
        for (Element names : titles) {
            boardGamesTitles = names.select("a").text();
            String boardGamesTitlesUrl = names.attr("href");
            price = names.select("span").text();

            // String ralS = getRalFromString(nameRal);
            System.out.println(boardGamesTitles + " " + price + " " + boardGamesTitlesUrl);
        }

        for (Element link : urls) {
            String linkHref = link.attr("href");
            String linkText = link.text();

            //        System.out.println(linkHref);
        }

    }

}
