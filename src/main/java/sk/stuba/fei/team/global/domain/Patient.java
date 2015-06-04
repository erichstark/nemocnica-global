package sk.stuba.fei.team.global.domain;

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

@Entity
@XmlRootElement
public class Patient implements Serializable, UserDetails, CredentialsContainer {

    private String password;
    private String username;
    private Set<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String firstName;
    private String surname;
    private String phone;
    private String email;
    private String prefix_title;
    private String suffix_title;
    private Insurance insurance;
    private List<PatientOrder> orders;

    public Patient() {
        password = "";
        username = "";
        authorities = new HashSet<>();
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
        firstName = "";
        surname = "";
        prefix_title = "";
        suffix_title = "";
        phone = "";
        email = "";
    }

    public Patient(String username, String password, String email, Collection<? extends GrantedAuthority> authorities) {
        this.password = password;
        this.username = username;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
        firstName = "";
        surname = "";
        prefix_title = "";
        suffix_title = "";
        phone = "";
        this.email = email;
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

    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "authority")
    @CollectionTable(
            name = "authorities",
            joinColumns = @JoinColumn(name = "username")
    )
    public Set<String> getStringAuthorities() {
        if (authorities==null){return new HashSet<String>();
        }
        return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    }

    public void setStringAuthorities(Set<String> authorities) {
        try
        {
            this.authorities = authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
        }catch (Exception e){
            this.authorities=null;
        }

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

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrefix_title() {
        return prefix_title;
    }

    public void setPrefix_title(String prefix_title) {
        this.prefix_title = prefix_title;
    }

    public String getSuffix_title() {
        return suffix_title;
    }

    public void setSuffix_title(String suffix_title) {
        this.suffix_title = suffix_title;
    }

    @ManyToOne
    @JoinColumn(name = "insurance")
    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
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

    @Override
    public void eraseCredentials() {
        password = null;
    }

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "patient")
    public List<PatientOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PatientOrder> orders) {
        this.orders = orders;
    }
}
