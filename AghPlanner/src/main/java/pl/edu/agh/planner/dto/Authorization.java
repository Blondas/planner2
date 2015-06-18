package pl.edu.agh.planner.dto;


public class Authorization implements java.io.Serializable{
    private Long id;
    private AuthorizationType type;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorizationType getType() {
        return type;
    }

    public void setType(AuthorizationType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
