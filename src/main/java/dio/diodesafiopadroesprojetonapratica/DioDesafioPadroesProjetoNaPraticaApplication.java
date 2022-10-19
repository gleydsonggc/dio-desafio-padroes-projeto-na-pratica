package dio.diodesafiopadroesprojetonapratica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioDesafioPadroesProjetoNaPraticaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DioDesafioPadroesProjetoNaPraticaApplication.class, args);
    }

}
