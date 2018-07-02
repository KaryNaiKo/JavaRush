package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павлуша on 26.04.2018.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    //private static final String URL_FORMAT_TEST = "http://javarush.ru/testdata/big28data.html";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        Document document = null;
        List<Vacancy> list = new ArrayList<>();
        int page = 0;

        try {
            while (page < 10) {
                document = getDocument(searchString, page);
                Elements elements = document.select("[data-qa=vacancy-serp__vacancy]");

                int num = elements.size();
                for (int i = 0; i < num; i++) {
                    Element element = elements.get(i);
                    Elements subElements = element.child(1).child(0).children();
                    String title = subElements.select("[data-qa=\"vacancy-serp__vacancy-title\"]").text();
                    String salary = subElements.select("[data-qa=\"vacancy-serp__vacancy-compensation\"]").text();
                    String city = subElements.select("[data-qa=\"vacancy-serp__vacancy-address\"]").text();
                    String companyName = subElements.select("[data-qa=\"vacancy-serp__vacancy-employer\"]").text();
                    String siteName = "http://hh.ua";
                    String url = subElements.select("[data-qa=\"vacancy-serp__vacancy-title\"]").attr("href");

                    list.add(new Vacancy(title, salary, city, companyName, siteName, url));
                }
                page++;
            }
        } catch (IOException e) {

        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document doc;
        String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36";
        String referer = "https://hh.ua/search/vacancy?text=java+%D0%9A%D0%B8%D0%B5%D0%B2&page=1";

        String str = String.format(URL_FORMAT, searchString, page);

        doc = Jsoup.connect(str).userAgent(userAgent).referrer(referer).get();

        return doc;
    }
}
