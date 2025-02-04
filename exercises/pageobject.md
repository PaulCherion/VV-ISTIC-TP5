## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public interface SimbaOrganizer {
    String getName();
    SimbaOrganizer typeName(String name);
    String getMail();
    SimbaOrganizer typeMail(String mail);
    boolean agendaAccessible();
    SimbaOrganizer setAgendaAccessible(boolean value);
    boolean prefenrencesAlim();
    SimbaOrganizer setPrefenrencesAlim(boolean value);
    CalendarView calendarView();
    TableauView tableauView();
    List<OptionPanel> options();
    SimbaOrganizer submitWishes();
    String CommentCreator();
    SimbaOrganizer typeCommentCreator(String creator);
    String Comment();
    SimbaOrganizer typeComment(String comment);
    Void addComment();
}

interface OptionPanel {
    LocalDateTime startsAt();
    LocalDateTime endsAt();
    boolean checkBox();
    SimbaOrganizer setCheckBox();
}
```
