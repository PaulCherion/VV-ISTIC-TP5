## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public class simbaOrganizer(
    public simbaOrganizer(WebDriver);
    public String getName();
    public InformationPage typeName(String name);
    public String getMail();
    public InformationPage typeMail(String mail);
    public boolean agendaAccessible();
    public InformationPage setAgendaAccessible(boolean value);
    public boolean prefenrencesAlim();
    public InformationPage setPrefenrencesAlim(boolean value);
    public CalandarView calendarView();
    public TableauVieuw tableauView();
    public List<OptionPanel> options();
    public InformationPage submitWishes();
    public String CommentCreator();
    public InformationPage typeCommentCreator(String creator);
    public String Comment();
    public InformationPage typeComment(String comment);
    public CommentView addComment();
    
)


class OptionPanel {
    public LocalDateTime startsAt();
    public LocalDateTime endsAt();
    public boolean checkBox();
    public InformationPage setCheckBox();
}
```
