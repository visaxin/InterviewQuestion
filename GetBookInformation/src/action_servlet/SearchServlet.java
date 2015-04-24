package action_servlet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jason-zhang on 4/23/2015.
 */
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get parameter from jsp
        String data = request.getParameter("tag");
        String tag_name = new String(data.getBytes("ISO-8859-1"), "GBK");

        //get result from douban.com
        String url_tag ="http://book.douban.com/tag/"+tag_name;
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
        //put data in session
        HttpSession session = request.getSession();
        session.setAttribute("book_name_list",book_name_list);
        //redirt to result.jsp
        response.sendRedirect("/result.jsp");
    }
}
