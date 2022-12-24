package vir.project.pictureBrowser;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//letitkosítom a jelszavakat (mivel egyelőre nem kell a regisztrálás, ezért az nem ott történik, hanem itt
//létrehozáskor manuálisan. Ezt alapértelmezetten biztonsági ok miatt törölni kellene a létrehozás után!
public class PasswordGenerator {

    public static void main(String[] args)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        //sorrendbe
        String rawPassword1 = "password1";
        String encodedPassword1 = encoder.encode(rawPassword1);

        String rawPassword2 = "password2";
        String encodedPassword2 = encoder.encode(rawPassword2);

        String rawPassword3 = "password3";
        String encodedPassword3 = encoder.encode(rawPassword3);

        String rawPassword4 = "password12";
        String encodedPassword4 = encoder.encode(rawPassword4);

        String rawPassword5 = "password5";
        String encodedPassword5 = encoder.encode(rawPassword5);

        String rawPassword6 = "password6";
        String encodedPassword6 = encoder.encode(rawPassword6);

        String rawPassword7 = "password7";
        String encodedPassword7 = encoder.encode(rawPassword7);

        String rawPassword8 = "password8";
        String encodedPassword8 = encoder.encode(rawPassword8);

        String rawPassword9 = "password9";
        String encodedPassword9 = encoder.encode(rawPassword9);

        String rawPassword10 = "password10";
        String encodedPassword10 = encoder.encode(rawPassword10);

        String rawPassword11 = "password11";
        String encodedPassword11 = encoder.encode(rawPassword11);

        String rawPassword12 = "password12";
        String encodedPassword12 = encoder.encode(rawPassword12);

        String rawPassword13 = "admin";
        String encodedPassword13 = encoder.encode(rawPassword13);

        //System.out.println(encodedPassword1);
        //System.out.println(encodedPassword2);
        //System.out.println(encodedPassword3);
        //System.out.println(encodedPassword4);
        //System.out.println(encodedPassword5);
        //System.out.println(encodedPassword6);
        //System.out.println(encodedPassword7);
        //System.out.println(encodedPassword13);
        //System.out.println(encodedPassword8);
        //System.out.println(encodedPassword9);
        System.out.println(encodedPassword10);
        System.out.println(encodedPassword11);
        //System.out.println(encodedPassword12);


    }
}
