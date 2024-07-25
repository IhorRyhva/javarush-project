package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));
    }
    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies){
        try {
            Document document = getDocument();
            Elements temp = document.getElementsByClass("template");
            Elements elements = temp.clone().removeAttr("style").removeClass("template");
            Element template = elements.get(0);
            Elements elements1 = document.getElementsByClass("vacancy");
            for(Element element1: elements1){
                if(!element1.hasClass("template")){
                    element1.remove();
                }
            }

            for(Vacancy vacancy: vacancies){
                Element forFor = template.clone();
                Element city = forFor.getElementsByClass("city").get(0);
                city.appendText(vacancy.getCity());
                Element companyName = forFor.getElementsByClass("companyName").get(0);
                companyName.appendText(vacancy.getCompanyName());
                Element salary = forFor.getElementsByClass("salary").get(0);
                salary.appendText(vacancy.getSalary());
                Element link = forFor.getElementsByAttribute("href").get(0);
                link.appendText(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                temp.before(forFor.outerHtml());
            }
            return document.html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Some exception occurred";
    }
    private void updateFile(String file){
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {
            writer.write(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void userCitySelectEmulationMethod(){
        System.out.println(filePath);
        controller.onCitySelect("Moscow");
    }
}
