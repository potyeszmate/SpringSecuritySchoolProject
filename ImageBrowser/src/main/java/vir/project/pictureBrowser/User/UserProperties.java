package vir.project.pictureBrowser.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vir.project.pictureBrowser.Entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Userdetails framework interface felhasznalasa. Hogy működjön minden ovverride metodus kell
// a felhasznalo adatait kapjuk itt meg, többek között a role-t
//Ez egy tipikus saplon fájl

public class UserProperties implements UserDetails {
    private User user;

    public UserProperties(User user) {
        this.user = user;
    }

    //hozzaadjuk a user authority-het a user role-ját
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }

    // nem hasznaljuk az alábbiakat, de kelleni fog a UserDetails interface-nek, kell neki minden

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }



}
