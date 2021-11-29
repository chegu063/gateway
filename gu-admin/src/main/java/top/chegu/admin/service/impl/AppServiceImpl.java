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

package top.chegu.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.chegu.admin.bean.App;
import top.chegu.admin.mapper.AppMapper;
import top.chegu.admin.service.IAppService;
import top.chegu.common.entity.dto.RegisterAppDTO;
import top.chegu.common.entity.dto.UnRegisterAppDTO;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chegu
 * @since 2021-04-13
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements IAppService {

    @Override
    public Integer register(RegisterAppDTO dto) {
        final App one = this.getOne(Wrappers.<App>lambdaQuery().eq(App::getAppName, dto.getAppName()));
        if (one != null){
            if (Boolean.FALSE.equals(one.getEnabled())){
                one.setEnabled(true);
                updateById(one);
            }
            return one.getId();
        }else {
            final App app = App.builder()
                    .appName(dto.getAppName())
                    .contextPath(dto.getContextPath())
                    .enabled(true)
                    .createdTime(LocalDateTime.now())
                    .build();
            save(app);
            return app.getId();
        }
    }

    @Override
    public void unRegister(UnRegisterAppDTO dto) {

    }
}
