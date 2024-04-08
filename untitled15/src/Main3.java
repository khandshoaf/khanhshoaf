import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main3 {
    public static void main(String[] args) {
        try{
            Document doc = Jsoup.connect("https://cotich.net/co-tich-ve-loai-vat.html").get();
            Elements link = doc.select("div[class=\"main-content\"] [class=\"news-item\"] ");
            Elements linkk = doc.select("div[class=\"title\"]");
            String danhMuc = linkk.select("a").text();
            for(Element link1 : link) {

                String tenTruyen = link1.select("a").attr("title");
                Elements link2 = link1.select("div[class=\"img\"]");

                for(Element link3 : link2){
                    String url = link3.select("a").attr("href");
                    String imgUrl = link3.select("img").attr("src");


                    System.out.println("Danh Mục: " + danhMuc);
                    System.out.println("Image: " + imgUrl);
                    System.out.println("Tên Truyện: " + tenTruyen);
                    System.out.println("URL: " + url);


                    System.out.println("--------------------------------------------------------");

                }
            }

        }catch (Exception e){
            e.getMessage();
        }
    }
}

