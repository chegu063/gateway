package top.chegu.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;
import top.chegu.admin.GuAdminApplication;
import top.chegu.mybatis.generate.CodeGenerator;

import javax.annotation.Resource;

/**
 * @author chegu
 * @date 2021/4/15  15:16
 */
@SpringBootTest(classes = GuAdminApplication.class)
@RunWith(SpringRunner.class)
public class GeneratorTest {
    @Resource
    @Lazy
    public CodeGenerator codeGenerator;

    @Test
    public void test() {
        codeGenerator.generate();
    }
}
