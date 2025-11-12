package harjoitustyo.backend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="userN")
    private String userN;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    public AppUser() {

    }

    public AppUser(String userN, String password, String role) {
		super();
		this.userN = userN;
		this.password = password;
		this.role = role;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return userN;
    }

    public void setUser(String userN) {
        this.userN = userN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    



}
