import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        try{
            String url = "https://cotich.net/";
            Document doc = Jsoup.connect(url).get();
            String url2 = "div[class=\"block-news\"]";
            Elements blockNews = doc.select(url2);
            for (Element news : blockNews) {
                String categories = news.select("a").attr("title");
                String urlcategory = news.select("a").attr("href");

                String url3 = "div[class=\"list-news\"]";
                Elements link1 = news.select(url3);
                for(Element link2 : link1) {

                    String url4 = "div[class=\"item \"]";
                    Elements link3 = link2.select(url4);
                    for(Element link4 : link3){
                    String newsTitle = link4.select("a").attr("title");
                    String newsUrl = link4.select("a").attr("href");
                    String imageUrl = link4.select("img").attr("src");
                    String newsContent = link4.select("p").text();

                    System.out.println("Thể Loại: " + categories);
                    System.out.println("URLCategory: " + urlcategory);
                    System.out.println("Title: " + newsTitle);
                    System.out.println("URL: " + newsUrl);
                    System.out.println("Image URL: " + imageUrl);
                    System.out.println("Content: " + newsContent);
                    System.out.println("-----------------------");
                    }
                    String url5 = "div[class=\"item  item3\"]";
                    Elements link5 = link2.select(url5);
                    for(Element link6 : link5){
                        String newsTitle = link6.select("a").attr("title");
                        String newsUrl = link6.select("a").attr("href");
                        String imageUrl = link6.select("img").attr("src");
                        String newsContent = link6.select("p").text();

                        //In ra
                        System.out.println("Thể Loại: " + categories);
                        System.out.println("Title: " + newsTitle);
                        System.out.println("URL: " + newsUrl);
                        System.out.println("Image URL: " + imageUrl);
                        System.out.println("Content: " + newsContent);
                        System.out.println("-----------------------");
                    }
                }
            }
        }catch (Exception e){

            e.getMessage();
        }
    }
}

