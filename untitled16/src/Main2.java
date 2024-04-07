import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main2 {
    public static void main(String[] args) {
        try{
            Document doc = Jsoup.connect("https://cotich.net/co-tich-viet-nam.html").get();
            Elements link1 = doc.select("div[class=main-content]");
            for(Element link2 : link1){
                Elements link3 = link2.select("div[class=\"title\"]");
                String category = link3.select("a").text();
                System.out.println("Thể Loại: " + category);
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}
