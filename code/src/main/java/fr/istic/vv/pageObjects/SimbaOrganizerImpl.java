package fr.istic.vv.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SimbaOrganizerImpl implements SimbaOrganizer {

    private final WebDriver driver;

    public SimbaOrganizerImpl(WebDriver driver) {
        this.driver = driver;
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public SimbaOrganizer typeName(String name) {
        driver.findElement(By.id("nom")).sendKeys(name);
        return this;
    }

    @Override
    public String getMail() {
        return null;
    }

    @Override
    public SimbaOrganizer typeMail(String mail) {
        driver.findElement(By.id("mail")).sendKeys(mail);
        return this;
    }

    @Override
    public boolean agendaAccessible() {
        return false;
    }

    @Override
    public SimbaOrganizer setAgendaAccessible(boolean value) {
        return null;
    }

    @Override
    public boolean prefenrencesAlim() {
        return false;
    }

    @Override
    public SimbaOrganizer setPrefenrencesAlim(boolean value) {
        return null;
    }

    @Override
    public CalendarView calendarView() {
        return null;
    }

    @Override
    public TableauView tableauView() {
        return null;
    }

    @Override
    public SimbaOrganizer selectFirstChoice() {
        driver.findElements(By.className("fc-event-main")).get(0).click();
        return this;
    }

    @Override
    public List<OptionPanel> options() {
        return null;
    }

    @Override
    public SimbaOrganizer submitWishes() {
        driver.findElement(By.xpath("//span[.='Soumettre voeux']")).click();
        return this;
    }

    @Override
    public String CommentCreator() {
        return null;
    }

    @Override
    public SimbaOrganizer typeCommentCreator(String creator) {
        return null;
    }

    @Override
    public String Comment() {
        return null;
    }

    @Override
    public SimbaOrganizer typeComment(String comment) {
        return null;
    }

    @Override
    public Void addComment() {
        return null;
    }
}
