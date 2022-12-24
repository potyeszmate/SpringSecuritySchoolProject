package vir.project.pictureBrowser.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vir.project.pictureBrowser.Entity.User;

//adatbazissal való megfelelo mukodest biztositja. a springframework-nek van egy beepitett JPaRepo interface-e
// Ez a beépitett interface query-vel keri le itt most a usereket username alapjan (forras peldaban is igy volt).

public interface UserInterface extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);

}