#  Java Hibernate Advance Mappings

### Proje Kurulumu

Projeyi öncelikle forklayın ve clone edin.
Daha sonra projeyi IntellijIDEA kullanarak açınız. README.md dosyasını dikkatli bir şekilde okuyarak istenenleri yapmaya çalışın.
Proje sayımız ilerledikçe proje yönetimimizi kolaylaştırmak adına projelerimizi belli klasör kalıplarında saklamak işimizi kolaylaştırmak adına iyi bir alışkanlıktır.
Örnek bir Lokasyon: Workintech/Sprint_1/Etud.

### Hedeflerimiz:

### Movie Rest Api

 ### Başlangıç
 * Spring Initializr kullanarak bir Spring Boot projesi oluşturun.
 * İçerisinde ```Spring Web, Spring Data JPA, Lombok, Postgresql driver``` dependencyler eklenmeli.
 * Maven dependency management sistemini kullanarak tüm dependencyleri install edin.
 * Uygulamanızı  ```9000``` portundan ayağa kaldırın.
 * Filmler için rest api dizayn etmeniz istenmektedir.

### Amaç
 * Amacımız veritabanına ekleme yapabileceğimiz bir movie API'yı hazırlamak.
 * Bu Api'yi oluştururken error handling ve validation kurallarına uymalıyız.
 * Dependency Injection kurallarına uymalıyız.
 
 ### Görev 1
 * main metodunuzun olduğu paket altında ```controller```, ```entity```, ```service```, ```dao``` paketlerini mutlaka eklemelisiniz.
 * ```entity``` paketinin altına ```Movie``` adında bir sınıf tanımlayınız. İçerisinde instance variable olarak ```id, name, directorName, rating, releaseDate``` isminde 5 tane değişken oluşturun.
 * ```entity``` paketinin altına ```Actor``` adında bir sınıf tanımlayınız. İçerisinde instance variable olarak ```id, firstName, lastName, gender, birthDate``` isminde 5 tane değişken oluşturun.
 * ```Movie``` ve ```Actor``` sınıfları arasında many-to-many  bir ilişki tanımlanmalı.
 * Lombok ve JPA annotationlarını bu sınıflara uygulayınız.
 * ```application.properties``` dosyanızı kullanarak veritabanı bağlantınızı kurun.
 * ```logging.level.org.hibernate.SQL, logging.level.org.hibernate.orm.jdbc.bind``` opsiyonları ile oluşan sqlleri inceleyin.

### Görev 2
 * Dao paketi altında ```MovieDao``` ve  ```ActorDao``` isminde iki interface oluşturun.
 * içerisinde şu işlemleri yapıcak methodları tanımlamalısınız.
 * Bu iki interface de movie ve actor için ```CRUD``` işlemlerini yapabilmeli.
 * Service paketinin içine CRUD işlemlerini tanımlayabileceğiniz interface ve sınıfları yazın.

 ### Görev 3
 * ```controller``` paketi altında ```MovieController``` ve ```ActorController ```adında 2 tane controller yazmalısınız.
 * Amacımız CRUD işlemlerini tanımlayan endpointler yazmak.
 * [GET]/workintech/movies => tüm movie listini dönmeli.
 * [GET]/workintech/movies/{id} => İlgili id deki movie objesini dönmeli.
 * [POST]/workintech/movies/ => Bir adet movie objesi ve bir adet actor objesi alır ve ikisini de veritabanına ilişkileri ile birlikte kaydeder.
 * [PUT]/workintech/movies/{id} => İlgili id deki movie objesinin değerlerini yeni gelen data ile değiştirir.
 * [DELETE]/workintech/movies/{id} => İlgili id değerindeki movie objesini veritabanından siler.
 * [GET]/workintech/actors => tüm actors listini dönmeli.
 * [GET]/workintech/actors/{id} => İlgili id deki actor objesini dönmeli.
 * [POST]/workintech/actors =>  Bir adet movie objesi ve bir adet actor objesi alır ve ikisini de veritabanına ilişkileri ile birlikte kaydeder.
 * [PUT]/workintech/actors/{id} => İlgili id deki actor objesinin değerlerini yeni gelen data ile değiştirir.
 * [DELETE]/workintech/actors/{id} => İlgili id değerindeki actor objesini veritabanından siler.

### Optional
 * Her endpointin hata fırlatabileceği senaryolar düşünülmeli ```exceptions``` paketi altına bu Error sınıfları oluşturulmalı.
 * ApiException isminde bir custom exception oluşturulmalı ve runtimeexception dan türetilmeli.
   İçinde instance variable olarak HttpStatus yer almalı.
 * Error Handling Global bir merkezden yönetilmeli. Controller sınıflarının altında olmamalı.
 * ```spring-boot-starter-validation``` dependency ile Entityler için validasyon ekleyebilirsiniz.
 * Her Controller ```@Slf4j``` ile işaretlenmelidir. Endpoint bir şekilde hata döndüğünde ```error logu``` basılmalı.
 * validation işlemleri controller sınıfı içinde kalmamalı. ```util``` paketi altında ```HollywoodValidation``` isimli bir sınıf oluşturunuz. Validation işlemlerini buraya alınız.

### Optional
 * Codepen üzerinden veya bir React uygulaması oluşturarak Spring Boot ile yazdığımız projeye request atmayı deneyiniz.
  cors hatasını nasıl çözebiliriz.

 
