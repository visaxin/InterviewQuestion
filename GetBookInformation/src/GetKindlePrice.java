import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by jason-zhang on 4/23/2015.
 */
public class GetKindlePrice {
    static int getKindlePrice(String isbn) throws IOException {

        String url = "http://www.amazon.cn/s/ref=nb_sb_noss?__mk_zh_CN=%E4%BA%9A%E9%A9%AC%E9%80%8A%E7%BD%91%E7%AB%99&url=search-alias%3Ddigital-text&field-keywords="+isbn;

        Document doc = Jsoup.connect(url).get();

        Elements ele = doc.select("#noResultsTitle");
        if(ele.toString().equals("")){
            System.out.print("result");
            Element price_ele = doc.select(".a-size-base a-color-price s-price a-text-bold").first();
            System.out.println(price_ele.toString());
        }else{
            System.out.println("has result");
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        int d = getKindlePrice("9787544270878");
        System.out.println(d);
    }
}
