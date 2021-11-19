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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.chegu.admin.bean.RouteRule;
import top.chegu.admin.mapper.RouteRuleMapper;
import top.chegu.admin.service.IRouteRuleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chegu
 * @since 2021-04-16
 */
@Service
public class RouteRuleServiceImpl extends ServiceImpl<RouteRuleMapper, RouteRule> implements IRouteRuleService {

}
