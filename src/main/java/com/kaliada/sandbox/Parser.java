package com.kaliada.sandbox;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
//        parser.parseNews();
        parser.parseSingleNews("https://news.harvard.edu/gazette/story/2021/06/happiness-scholar-offers-lessons-in-healing-rifts/");
    }

    public void parseNews() throws IOException {
        Document document = Jsoup.connect("https://news.harvard.edu/gazette/")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("https://www.google.com")
                .get();
        Elements news = document.select("article[id]");
        for(Element element : news) {
            String id = element.attr("id");
            Element hrefElement =  element.select("a[href]").first();
            String href = hrefElement != null ? hrefElement.attr("href") : null;
        }
    }

    public void parseSingleNews(String link) throws IOException {
        Document document = Jsoup.connect(link)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("https://www.google.com")
                .get();
        String tag = document.select("a.article-titles__cat-link").first().text();
        String title = document.select("h1.article-titles__title").first().text();
        Element imageElement = document.select("div.article-media__media-content")
                .select("img[src]").first();
        String image = imageElement != null ? imageElement.attr("src") : null;
        String data = document.select("div.article-body").html();
        String text = document.select("div.article-body").text();
    }
}
