package top.chegu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chegu
 */
@MapperScan(basePackages = {"top.chegu.admin.mapper"})
@SpringBootApplication(scanBasePackages = {"top.chegu"})
public class GuAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuAdminApplication.class, args);
    }
}
