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

package top.chegu.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.chegu.admin.bean.App;
import top.chegu.common.entity.dto.RegisterAppDTO;
import top.chegu.common.entity.dto.UnRegisterAppDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chegu
 * @since 2021-11-24
 */
public interface IAppService extends IService<App> {

    Integer register(RegisterAppDTO dto);

    void unRegister(UnRegisterAppDTO dto);
}
