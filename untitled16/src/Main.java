import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://cotich.net/").get();
            Elements link1 = doc.select("div[class=\"menuTop \"] ul[id] li");
            for (Element link2 : link1) {
                String categories = link2.select("a").attr("title");
                String url1 = link2.select("a").attr("href");
                System.out.println("Thể Loại: " + categories);
                System.out.println("URL: " + url1);
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}

