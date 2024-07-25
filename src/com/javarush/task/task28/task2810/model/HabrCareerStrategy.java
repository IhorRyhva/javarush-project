package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerStrategy implements Strategy{
    private static final String URL_FORMAT = "https://career.habr.com/vacancies?q=java+%s&page=%d";
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        int i = 0;
        do{
            //title, salary, city, companyName, siteName, url.
            Document document = getDocument(searchString, i);
            Elements elements = document.getElementsByClass("job");
            if(elements.isEmpty())
                break;
            for(Element element: elements){
                Vacancy vacancy = new Vacancy();
                Elements salarys = element.getElementsByAttributeValue("class", " count");
                if(!salarys.isEmpty()){
                    vacancy.setSalary(salarys.get(0).text());
                }else{
                    vacancy.setSalary("");
                }
                Element title = element.getElementsByAttributeValue("class", "title").get(0);
                Elements cities = element.getElementsByAttributeValue("class", "location");
                if(!cities.isEmpty()){
                    vacancy.setCity(cities.get(0).text());
                }else {
                    vacancy.setCity("");
                }
                Element companyName = element.getElementsByAttributeValue("class", "company_name").get(0);
                vacancy.setTitle(title.text());
                vacancy.setCompanyName(companyName.text());
                vacancy.setSiteName("career.habr.com");
                vacancy.setUrl("https://career.habr.com" + title.getElementsByTag("a").attr("href"));
                vacancies.add(vacancy);
            }
            i++;
        }while (true);
        return vacancies;
    }
    protected Document getDocument(String searchString, int page){
        try {
            return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
                    .referrer("https://career.habr.com/")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
