package top.chegu.admin.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.chegu.mybatis.generate.CodeGenerator;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chegu
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/app")
public class AppController {

    @Resource
    public CodeGenerator codeGenerator;

    public void generate(){
        codeGenerator.generate();
    }
}
