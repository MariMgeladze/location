package softlab.homework.location.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(schema = "public", name = "users")
public class UserDomain implements UserDetails {

    @Id
    private Integer id;

    @Column(name = "email")
    private String username;

    private String password;

    private String firstName;

    private  String lastName;

    private Boolean active;

    private LocalDateTime createdAt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return Objects.equals(active,Boolean.TRUE);
    }

    @Override
    public boolean isAccountNonLocked() {
        return Objects.equals(active,Boolean.TRUE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return Objects.equals(active,Boolean.TRUE);
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(active,Boolean.TRUE);
    }
}
