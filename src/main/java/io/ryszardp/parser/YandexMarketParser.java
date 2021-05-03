package io.ryszardp.parser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class YandexMarketParser {

    private static WebDriver driver;

    private static Document getPage(String url) throws IOException, InterruptedException {
        // Document page = Jsoup.parse(new URL(url), 15000);
        Document page = Jsoup.parse(new URL(url), 30000);
        page = Jsoup.connect(url).get();
        //Document page = Jsoup.connect(url).maxBodySize(Integer.MAX_VALUE).get();
        Thread.sleep(20000);
        return page;
    }

    private static final String MAIN = "https://market.yandex.ru/catalog--nastolnye-igry/59742/list";
    private static final String href = "https://market.yandex.ru";

    public static void main(String[] args) throws Exception {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        int pageNumbers = 3;
        Document page = getPage(MAIN);
        //    System.out.println(page);
        //body > div._111XIPXNiH.main > div:nth-child(4) > div.tamefSzMtq > div:nth-child(4) > div
        // body > div._111XIPXNiH.main > div:nth-child(4) > div.tamefSzMtq > div:nth-child(4)
        // body > div._111XIPXNiH.main > div:nth-child(4) > div.tamefSzMtq > div:nth-child(4) > div > div:nth-child(1) > div > div > div
        //body > div._111XIPXNiH.main > div:nth-child(4) > div.tamefSzMtq > div:nth-child(4) > div
        Elements content = page.select("[class]");
        System.out.println(content);
       // Element tableCont = page.select("body > div._111XIPXNiH.main > div:nth-child(4) > div.tamefSzMtq > div:nth-child(4) > div").first();
      //  System.out.println(tableCont);
    //    Elements articles = tableCont.select("article");
        // System.out.println(articles);
        for (Element element : content) {
            System.out.println(content);
            String gameLink = element.select("a").attr("href");
            System.out.println(gameLink);
            //   System.out.println(href + gameLink);
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
