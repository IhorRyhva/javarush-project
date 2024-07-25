package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d&items_on_page=20";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;
        try {
            while (true){
                Document document = getDocument(searchString, page);
                Elements mainElement = document.getElementsByAttributeValue("class", "serp-item");
                if(mainElement.isEmpty())
                    break;
                for(Element element: mainElement){
                    ////title, salary, city, companyName, siteName, url.
                    Elements title = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
                    Elements salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");
                    Elements city = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address");
                    Elements companyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName("hh.ru");
                    vacancy.setUrl(title.get(0).attr("href"));
                    vacancy.setCity(city.get(0).text());
                    vacancy.setCompanyName(companyName.get(0).text());
                    vacancy.setTitle(title.get(0).text());
                    vacancy.setSalary(salary.size() > 0 ? salary.get(0).text(): "");
                    vacancies.add(vacancy);
                }
                page++;
            }
        }
        catch (IOException e){}
        return vacancies;
    }
    protected Document getDocument(String searchString, int page) throws IOException{
        return Jsoup.connect(String.format(URL_FORMAT ,searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36")
                .referrer("https://hh.ru/")
                .get();
    }
}
