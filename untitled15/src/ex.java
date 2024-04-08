import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/truyenTranh";
        String username = "root";
        String password = "123456";

        try {
            // Kết nối đến cơ sở dữ liệu MySQL
            Connection conn = DriverManager.getConnection(url, username, password);

            // Kết nối đến trang web cotich.net và lấy dữ liệu HTML
            Document doc = Jsoup.connect("https://cotich.net").get();
            String htmlContent = doc.outerHtml();

            // Lưu dữ liệu HTML vào cơ sở dữ liệu
            String sql = "INSERT INTO your_table_name (html_content) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, htmlContent);
            statement.executeUpdate();

            System.out.println("Dữ liệu đã được lưu vào cơ sở dữ liệu.");

            // Đóng kết nối
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
