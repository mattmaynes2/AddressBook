package buddy; /**
 * Created by mattmaynes on 1/26/2017.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.ApplicationRunner;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringLauncher {
    public static void main(String[] args) {
        SpringApplication.run(SpringLauncher.class, args);

    }
}
