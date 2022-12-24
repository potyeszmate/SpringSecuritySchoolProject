package vir.project.pictureBrowser.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import vir.project.pictureBrowser.Entity.User;

import javax.transaction.Transactional;
import java.util.List;


//  userdetailsservie ( ami szinten egy beepitett springframework) hasznalata
// szukseges user adatok lekerese (role, id, username alapjan maga a user)
@Service
@Transactional
public class UService implements UserDetailsService {

    @Autowired
    private UserInterface userInterface;


    // Sablon override metodus, a usert visszaadja a username alapjan.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userInterface.getUserByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found.");
        }

        return new UserProperties(user);
    }


    //Visszaadja a usereket
    public List<User> listAll(){
        return userInterface.findAll();
    }

    //Visszaadja az user id-t
    public User getID(int id) {
        return userInterface.findById(id).get();
    }


    //Visszaadja a user role-t
    public void updateRole(String name, String role){
        User user = userInterface.getUserByUsername(name);
        user.setRole(role);
    }


    //username visszaadas nem kell, mert mindig a username ből indulunk ki, a  loadUserByUsername el
}
