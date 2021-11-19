package top.chegu.gate;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author chegu
 * @date 2021/4/9  15:47
 */
@Configuration
@Import(AutoRegisterListener.class)
@EnableConfigurationProperties(value = { GuClientProperties.class })
public class GuClientAutoConfigure {

}
