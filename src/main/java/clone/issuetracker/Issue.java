package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comments;
    // private CopyMode copyMode;

//    public Issue(String name, LocalDateTime time, Status status, List<Comment> comments, CopyMode copyMode) {
//        this.name = name;
//        this.time = time;
//        this.status = status;
//        this.comments = comments;
//        this.copyMode = copyMode;
//    }

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

    public Issue(Issue anotherIssue, CopyMode copyMode) {
        name = anotherIssue.name;
        time = anotherIssue.time;
        status = anotherIssue.status;
        if (copyMode.equals(CopyMode.WITH_COMMENTS)) {
            List<Comment> copiedComments = new ArrayList<>();
            for (Comment c: anotherIssue.comments) {
                copiedComments.add(new Comment(c));
            }
            comments = copiedComments;
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
