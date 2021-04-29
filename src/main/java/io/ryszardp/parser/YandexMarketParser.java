package io.ryszardp.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class YandexMarketParser {

    private static Document getPage(String url) throws IOException {
        // Document page = Jsoup.parse(new URL(url), 15000);
       // Document page = Jsoup.parse(new URL(url), 25000);
        Document page = Jsoup.connect(url).maxBodySize(Integer.MAX_VALUE).get();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return page;
    }

    private static final String MAIN = "https://market.yandex.by/catalog--nastolnye-igry-v-minske/59742/list?hid=10682647&track=pieces&onstock=1&local-offers-first=0";
    private static final String href = "https://market.yandex.by/";

    public static void main(String[] args) throws Exception {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        int pageNumbers = 3;
        Document page = getPage(MAIN);
        // System.out.println(page);


        // body > div._111XIPXNiH.main > div:nth-child(4) > div.tamefSzMtq > div:nth-child(4)
        // body > div._111XIPXNiH.main > div:nth-child(4) > div.tamefSzMtq > div:nth-child(4) > div > div:nth-child(1) > div > div > div
        Element tableCont = page.select("body").first();
       //System.out.println(tableCont);
        Elements divs = page.select("article");
       // System.out.println(divs);
        for (Element div : divs) {
         //   System.out.println(div);
            String gameLink = div.select(" a").attr("href");
            System.out.println(gameLink);
        }
        // Element table = page.getElementById()
        //     System.out.println(tableCont);
//         Elements itemCells = tableCont.select("article");

        //   for (Element element : itemCells) {
        //     String gameLink = element.select("a").attr("href");

        //   System.out.println(gameLink);
        // }
    }
}
