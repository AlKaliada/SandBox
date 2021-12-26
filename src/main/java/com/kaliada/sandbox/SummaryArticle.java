package com.kaliada.sandbox;

public class SummaryArticle {
    public static String getSummaryArticle(int countWords, String article) {
        int index = 0;
        while (countWords != 0) {
            if (article.indexOf(" ", ++index) == -1) {
                break;
            }
            index = article.indexOf(" ", index);
            countWords--;
        }
        return article.substring(0, index);
    }
}
