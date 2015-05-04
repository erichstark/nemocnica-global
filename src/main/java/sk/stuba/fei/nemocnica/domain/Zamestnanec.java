package sk.stuba.fei.nemocnica.domain;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity(name = "users")
@XmlRootElement
public class Zamestnanec implements Serializable, UserDetails, CredentialsContainer {

    private String password;
    private String username;
    private Set<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private Set<Ambulancia> ambulancie;
    private List<String> specializacie;

    public Zamestnanec() {
        password = "";
        username = "";
        authorities = new HashSet<>();
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
        firstName = "";
        lastName = "";
        ambulancie = new HashSet<>();
        specializacie = new ArrayList<>();
    }

    public Zamestnanec(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.password = password;
        this.username = username;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
        firstName = username;
        lastName = "";
        ambulancie = new HashSet<>();
        specializacie = new ArrayList<>();
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities =
                new TreeSet<>(new AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Transient
    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "authority")
    @CollectionTable(
            name = "authorities",
            joinColumns = @JoinColumn(name = "username")
    )
    public Set<String> getStringAuthorities() {
        return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    }

    public void setStringAuthorities(Set<String> authorities) {
        this.authorities = authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }


    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(columnDefinition = "VARCHAR(256) DEFAULT ''")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(columnDefinition = "VARCHAR(256) DEFAULT ''")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "zamestnanec_ambulancia",
            joinColumns =
            @JoinColumn(name = "zamestnanec", referencedColumnName = "username"),
            inverseJoinColumns =
            @JoinColumn(name = "ambulancia", referencedColumnName = "id")
    )
    public Set<Ambulancia> getAmbulancie() {
        return ambulancie;
    }

    public void setAmbulancie(Set<Ambulancia> ambulancie) {
        this.ambulancie = ambulancie;
    }

    @ElementCollection
    public List<String> getSpecializacie() {
        return specializacie;
    }

    public void setSpecializacie(List<String> specializacie) {
        this.specializacie = specializacie;
    }

    @Override
    public void eraseCredentials() {
        password = null;
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to the set.
            // If the authority is null, it is a custom authority and should precede others.
            if (g2.getAuthority() == null) {
                return -1;
            }

            if (g1.getAuthority() == null) {
                return 1;
            }

            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }
}
