import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ex1 {
    public static void main(String[] args) {
        String url = "https://cotich.net/co-tich-ve-loai-vat.html";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements pagingElement = doc.select("div[class=\"paging\"]");

            // Kiểm tra xem phần tử là null hay không trước khi trích xuất thông tin
            if (pagingElement != null) {
                System.out.println("Thông tin về thẻ <div class=\"paging\">:");
                System.out.println(pagingElement);
            } else {
                System.out.println("Không tìm thấy thẻ <div class=\"paging\"> trên trang web.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
