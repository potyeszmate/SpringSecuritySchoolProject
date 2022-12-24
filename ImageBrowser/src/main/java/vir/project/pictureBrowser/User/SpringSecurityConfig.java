package vir.project.pictureBrowser.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // ezek is mind sablon metodusok (generate -> overload method), a websecconfigadapter springframework interface működéséhez
    // kellenek. Kell az encode a jelszohoz, kell a authenticationProvider az autentikáláshoz
    // meg kell configure(hhtpsecurity) ahhoz, hogy melyik role =atentikáció) melyik oldalt érhesse el, honnan hova dobjon, stb.
    // Ez is egy tipikus saplon fájl


    //BCrypt jelszo encoder
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        return new UService();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProv = new DaoAuthenticationProvider();
        authProv.setUserDetailsService(userDetailsService());
        authProv.setPasswordEncoder(passwordEncoder());

        return authProv;
    }



    @Override
    protected void configure(AuthenticationManagerBuilder a) {
        a.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity auth) throws Exception {

        auth
                .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/home").hasAnyAuthority("JPG", "PNG", "GIF", "WEBP", "ADMIN", "PNG_JPG", "PNG_GIF","JPG_GIF","PNG_WEBP","JPG_WEBP","GIF_WEBP","PNG_JPG_WEBP","PNG_GIF_WEBP","PNG_JPG_GIF")
                    .antMatchers("/edit").hasAuthority("ADMIN")
                    .antMatchers("/edit/**").hasAuthority("ADMIN")
                    .and()
                //.formLogin().defaultSuccessUrl("/home");
                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home"))
                .logout()
                    .logoutSuccessUrl("/login")
                    .permitAll()
                    .and()
                .exceptionHandling().accessDeniedPage("/error");
    }
}
