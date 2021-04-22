package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comments = new ArrayList<>();

    public Issue(String name, LocalDateTime time, Status status, List<Comment> comments) {
        this.name = name;
        this.time = time;
        this.status = status;
        this.comments = comments;
    }

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
    }

    public Issue(Issue primaryIssue, CopyMode copyMode) {
        name = primaryIssue.name;
        time = primaryIssue.time;
        status = primaryIssue.status;
        if (copyMode.equals(CopyMode.WITH_COMMENTS)) {          // ha a copyMode paraméter: WITH_COMMENTS
            List<Comment> copiedComments = new ArrayList<>();   // új, üres lista példányosítása
            for (Comment c: primaryIssue.comments) {   // Comment tip-ú c végigiterál a másalandó, eredeti obj. comments listáján
                copiedComments.add(new Comment(c));    // minden elemét copy konstrukrorral lepéldányosítja  -> Deep Copy
            }                                          // és hozzáadja az előbb létrehozott listához
            comments = copiedComments;                 // a feltöltött új lista lesz az Issue másolat comments attr-nak értéke
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
