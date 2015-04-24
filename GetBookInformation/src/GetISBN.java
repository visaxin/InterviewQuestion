import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by jason-zhang on 4/23/2015.
 */
public class GetISBN {
    static int getISBN(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements ele = doc.select("#info").select("span").select(".pl");
        Iterator<Element> it = ele.iterator();
        while(it.hasNext()){
            Element e = it.next();
            String content = e.text();
            if(content.equals("ISBN:")){
                String d = doc.select("#info").text();

                int isbn = Integer.parseInt(d.split("ISBN:")[1]);
                return isbn;
            }
        }
        return 00000000000;
    }

    public static void main(String []args) throws IOException {
        int d = getISBN("http://book.douban.com/subject/1148282/");
        System.out.println(d);
    }
}
