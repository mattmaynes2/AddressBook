package buddy; /**
 * Created by mattmaynes on 1/26/2017.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.ApplicationRunner;

@SpringBootApplication
public class SpringLauncher {
    public static void main(String[] args) {
        //String[] contextPaths = new String[]{"app-context.xml"};
        //new ClassPathXmlApplicationContext(contextPaths);
        SpringApplication.run(SpringLauncher.class);

    }

    @Bean
    public ApplicationRunner build () {
        return (args) -> {};
    }
}
