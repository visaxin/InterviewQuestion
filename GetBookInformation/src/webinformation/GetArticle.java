package webinformation;


import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.analysis.Token;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;


/**
 * Created by jason-zhang on 4/24/2015.
 */
public class GetArticle {

    private String web_url;
    private HashMap hf_words;

    public String get_essay() throws IOException {
        Document doc = Jsoup.connect(this.web_url).get();
        Elements ele_essay = doc.select("#page p.text");
        String essay ="";

        Iterator<Element> it = ele_essay.iterator();

        while (it.hasNext()){
            essay+=it.next().text()+"\r\n";
        }
        return essay;
    }

    public HashMap get_hf_words(String essay) throws IOException {
        for(int i=0;i<essay.length();i++){
            char word = essay.charAt(i);
        }
        String input = essay;
        PaodingAnalyzer analyzer = new PaodingAnalyzer();

        StringBuilder sb = new StringBuilder();
        org.apache.lucene.analysis.TokenStream ts = analyzer.tokenStream("", new StringReader(input));
        Token token;
        sb.setLength(0);
        while((token = ts.next())!=null){
            sb.append(token.termText()).append("/");
        }

        if(sb.length()>0){
            sb.setLength(sb.length()-1);
        }

        String split_essay = sb.toString();

        String[] word = split_essay.split("/");

        int word_size = word.length;
        HashMap<String,Integer>count_word = new HashMap<String, Integer>();
        for(int i=0;i<word_size;i++){

            if(count_word.get(word[i])==null){
                count_word.put(word[i],1);
            }else {
                count_word.put(word[i], count_word.get(word[i]) + 1);
            }
        }

        return count_word;
    }

    public static  void main(String[] args) throws IOException {
        String url = "http://taoduanfang.baijia.baidu.com/article/40410";
        GetArticle ga = new GetArticle();
        ga.setWeb_url(url);
        String essay = ga.get_essay();
        HashMap<String,Integer> result = ga.get_hf_words(essay);



        Iterator it = result.entrySet().iterator();
        ArrayList<WordCount> arr_word = new ArrayList();
        WordCount wc;
        while(it.hasNext()){
            Map.Entry<String,Integer> en= (Map.Entry) it.next();
            //System.out.println(en.getKey() + ":" + en.getValue());
            wc = new WordCount(en.getKey(),en.getValue());
            arr_word.add(wc);
            it.remove();
        }

        ArrayList<Integer> count = new ArrayList<Integer>();

        for(int i=0;i<arr_word.size();i++){
            count.add(arr_word.get(i).getCount());
        }

        Collections.sort(count);
       // System.out.println(count.get(958));
        int top_count=10;

        for(int j = 0;j<10;j++) {
            for (int i=0; i < arr_word.size(); i++) {
                if (top_count <=0) {
                    break;
                }
                String top_word = arr_word.get(i).getWordByCount(count.get(count.size() - top_count));
                if (null == top_word) {
                } else {

                    System.out.println(top_word+":"+count.get(count.size()-top_count)+" times");
                    top_count--;
                }
            }
        }

        //after sorting


    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}
