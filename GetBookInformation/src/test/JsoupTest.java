package test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jason-zhang on 4/23/2015.
 */
public class JsoupTest {

    public static void main(String []args) throws IOException {

        String url_tag ="http://book.douban.com/tag/"+"编程";
        Document doc = Jsoup.connect(url_tag).get();
        Elements subject_list =  doc.select(".subject-list");
        Elements book_list = subject_list.select("h2");

        Iterator<Element> e = book_list.iterator();
        ArrayList book_name_list = new ArrayList();
        while(e.hasNext()){
            book_name_list.add(e.next().text());
        }
        //handle every page
        Elements page_list = doc.select(".paginator").select("a");
        Iterator it = page_list.iterator();

        //get next page link
        while(it.hasNext()){
            Document doc_link =Jsoup.parse(it.next().toString());
            String page_link = doc_link.select("a").attr("href");

            String next_page_url = "http://book.douban.com"+page_link;
            Document single_link_doc = Jsoup.connect(next_page_url).get();

            Elements subjest_list = single_link_doc.select(".subject-list");
            Elements book_list_p = subjest_list.select("h2");
            Iterator<Element> it_blp  = book_list_p.iterator();
            while (it_blp.hasNext()){
                book_name_list.add(it_blp.next().text());
            }
        }
        for(int i=0;i<book_name_list.size();i++){
            System.out.println(book_name_list.get(i));
        }

    }
}
