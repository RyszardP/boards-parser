package io.ryszardp.parser;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptErrorListener;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class OzonParser {
    private static Document getPage(String url) throws IOException, InterruptedException {
        // Document page = Jsoup.parse(new URL(url), 15000);
        WebClient webClient2 = new WebClient();
        webClient2.getOptions().setThrowExceptionOnScriptError(false);
        webClient2.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient2.setCssErrorHandler(new SilentCssErrorHandler());

        //   webClient2.setJavaScriptErrorListener(new JavaScriptErrorListener(){});
        HtmlPage myPage = webClient2.getPage(new URL(url));
        Document doc = Jsoup.parse(myPage.asXml());
        // Document page = Jsoup.parse(new URL(url), 30000);
        // page = Jsoup.connect(url).get();
        //  Document page = Jsoup.connect(url).maxBodySize(Integer.MAX_VALUE).get();
          Thread.sleep(3000);
        return doc;
    }

    private static Document getPageSimple(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 15000);
        return page;
    }


    private static final String MAIN = "https://www.ozon.ru/category/nastolnye-igry-13507/";
    private static final String href = "https://www.ozon.ru";

    public static void main(String[] args) throws Exception {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        System.setProperty("javax.net.ssl.trustStore", "/path/to/web2.uconn.edu.jks");
        int pageNumbers = 3;
        Document page = getPage(MAIN);
        //  System.out.println(page);


        Element tableCont = page.select("#layoutPage > div.a4e4 > div.container.b6e3 > div:nth-child(2) > div:nth-child(2) > div.b6k2.b5y1 > div:nth-child(1) > div > div").first();
        //System.out.println(tableCont);

        Elements articles = tableCont.select("div:nth-child(1) > div > div");
        //  System.out.println(articles);
        for (Element element : articles) {
            //    System.out.println(articles);
//            String gameLinkE = element.selectFirst("a").attr("href");
            String gameLink0 = element.select("a").attr("href");
           // System.out.println(gameLink);
             //  System.out.println(href + gameLink0);
            System.out.println(gameLink0);
               String gameLink = href.concat(gameLink0);
            System.out.println(gameLink);
            Thread.sleep(1000);
            Document innerPage = getPageSimple(gameLink);
            Element descriptionSection = innerPage.select("#layoutPage > div.a4e4 > div.container.b6e3 > div:nth-child(2) > div > div > div.b0h8.b0i.b0j8 > div:nth-child(2) > h1").first();
            System.out.println(descriptionSection);


        }




        //   System.out.println(gameLink);
        // }
    }
}
