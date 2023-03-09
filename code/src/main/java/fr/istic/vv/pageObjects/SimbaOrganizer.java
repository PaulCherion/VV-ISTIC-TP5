package fr.istic.vv.pageObjects;

import java.time.LocalDateTime;
import java.util.List;

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
    SimbaOrganizer selectFirstChoice();
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