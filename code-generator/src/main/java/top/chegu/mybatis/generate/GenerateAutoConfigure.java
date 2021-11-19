package top.chegu.mybatis.generate;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author chegu
 * @date 2021/4/15  11:15
 */
@Configuration
@Import({CodeGenerator.class})
@EnableConfigurationProperties({GenerateProperties.class})
public class GenerateAutoConfigure {

    @Bean
    public CodeGenerator codeGenerator(CodeGenerator codeGenerator){
        return codeGenerator;
    }
}
