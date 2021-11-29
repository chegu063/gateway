/*
 * Copyright (c) 2021 chegu <1107313063@qq.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.chegu.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.chegu.admin.service.IAppInstanceService;
import top.chegu.admin.service.IAppService;
import top.chegu.common.entity.dto.RegisterAppDTO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chegu
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/app/")
@RequiredArgsConstructor
public class AppController {

    private final IAppService appService;
    private final IAppInstanceService appInstanceService;

    @PostMapping("register")
    public void register(RegisterAppDTO registerAppDTO){
        appService.register(registerAppDTO);
    }


}
