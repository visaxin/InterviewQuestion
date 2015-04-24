# InterviewQuestion

1.用至少两种方法实现方法字符串的逆序。比如输入abcdefg，返回 gfedcba
2.写一个 Web 应用，输入关键词（比如编程），将豆瓣搜索出来的书籍 http://book.douban.com/tag/%E7%BC%96%E7%A8%8B 列出来，并且将亚马逊 Kindle 版本购买价格查询出来。
3.读取网页 http://taoduanfang.baijia.baidu.com/article/40410 的正文, 算出其中出现次数最多的词汇, “的”, “我们”, “你们”之类的常见词不算, 取 top10 即可。


IDE: IntelliJ 

Solution#1: reverse_a_string.py

Solution#2: Deploy the project on IntelliJ IDE, start tomcat server and search the key work eg "programming". You will get the list.
BUT NO KINDLE PRICE  SOLUTION. 

![Aaron Swartz](https://github.com/visaxin/InterviewQuestion/blob/master/2.png)

Solution#3: Run GetArticle.java.    

![Aaron Swartz](https://github.com/visaxin/InterviewQuestion/blob/master/1.png)

        Result Show: 
                长:13 times
                周日:16 times
                会党:17 times
                社会:18 times
                马克隆法案:18 times
                前:21 times
                马克:23 times
                克隆:23 times
                法国:26 times
                法案:30 times


Dependency:
    1: Jsoup.jar   http://jsoup.org/
    2:paoding opensource project   http://code.google.com/p/paoding/downloads/list   
    
