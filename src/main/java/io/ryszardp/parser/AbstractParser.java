package io.ryszardp.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser {

   protected static Document getPage(String url) throws IOException {
       return Jsoup.parse(new URL(url), 15000);
    }

    protected static String getFromString(String stringAge, Pattern pattern) throws Exception {
        Matcher matcher = pattern.matcher(stringAge);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("error");
    }

}


