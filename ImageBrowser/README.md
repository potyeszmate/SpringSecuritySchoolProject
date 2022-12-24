# A képböngésző kötelező program leírása

A kötelező programhoz elég sok helyről utánanéztem, és főként csak a forrásokból dolgoztam (kivéve a html-css mókolásaim)
Ezek nagy része egyébként sablon, a legtöbb ilyen feladatra hasonló megoldási mód van fenn a neten.

A program elindítása után, ha legelőször az adminnal bejelentkezünk, akkor az error oldalra dob. Onnan nyomjuk meg a kijelentkezés gombot, majd jelentkezzünk be újra és működik. Csak akkor van ez a hiba, ha először jelentkezünk be és akkor is az adminnal.

# Program indítása

0. Megfelelő Java jdk (java 11) és maven ( 3.6.*) verziók hasznalata
1. mvn clean install
2. mvn clean package
3. Program indítása


# Források amiket felhasználtam

*  Ebben a videóban lévő kódok 70%-a adja a projektem (security + editelés): https://www.youtube.com/watch?v=i21h6ThUiWc
*  DB nélkül is probalkoztam ez alapjan, végül elvetettem: https://www.youtube.com/watch?v=d7ZmZFbE_qY
* Login - reg (vegul a regisztralas hibas volt)
* Sqlite felhasznalasa a projektemben ez alapjan:
	*https://www.baeldung.com/spring-boot-sqlite
	*https://fullstackdeveloper.guru/2020/05/01/how-to-integrate-sqlite-database-	    with-spring-boot/   ( az SQL dialektus és a properties beallitasa innen van)
* https://www.w3schools.com
*  login template: https://freshdesignweb.com/css-login-form-templates/
* Jenkins job: https://www.youtube.com/watch?v=FX322RVNGj4

# Videó a működésről
https://youtu.be/ovSOx3djGZg

