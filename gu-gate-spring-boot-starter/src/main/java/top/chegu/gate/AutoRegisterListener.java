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

package top.chegu.gate;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import top.chegu.common.consts.AdminConsts;
import top.chegu.common.consts.GateConsts;
import top.chegu.common.consts.NacosConsts;
import top.chegu.common.entity.dto.RegisterAppDTO;
import top.chegu.common.entity.dto.UnRegisterAppDTO;
import top.chegu.common.exception.GuGateException;
import top.chegu.common.utils.IpUtil;
import top.chegu.common.utils.OkHttpTool;

import java.util.HashMap;

/**
 * @author chegu
 * @date 2021/4/9  15:51
 */
public class AutoRegisterListener implements ApplicationListener<ContextRefreshedEvent> {

    public static final Logger LOGGER = LoggerFactory.getLogger(AutoRegisterListener.class);
    private final GuClientProperties properties;

    private Boolean isRegister = false;

    @NacosInjected
    private NamingService namingService;

    public AutoRegisterListener(GuClientProperties properties) {
        //校验properties
        if (!check(properties)) {
            throw new GuGateException("Client property cannot be null!");
        }
        this.properties = properties;
    }

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        //判断是否已经注册，未注册则设置注册状态
        if (Boolean.TRUE.equals(isRegister)) {
            return;
        } else {
            isRegister = true;
        }
        doRegister();
        registerShutDownHook();
    }

    private void registerShutDownHook() {
        String url = GateConsts.PRE_HTTP_PROTOCAL + properties.getAdminUrl() + AdminConsts.UNREGISTER_PATH;
        UnRegisterAppDTO unRegisterAppDTO = new UnRegisterAppDTO();
        unRegisterAppDTO.setIp(IpUtil.getIp());
        unRegisterAppDTO.setPort(properties.getPort());
        unRegisterAppDTO.setAppName(properties.getAppName());
        unRegisterAppDTO.setVersion(properties.getVersion());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            OkHttpTool.doPost(url, unRegisterAppDTO);
            LOGGER.info("unRegister success!");
        }));
    }

    private void doRegister() {
        Instance instance = new Instance();
        instance.setIp(IpUtil.getIp());
        instance.setPort(properties.getPort());
        HashMap<String, String> metadata = new HashMap<>();
        metadata.put("version:", properties.getVersion());
        metadata.put("appName:", properties.getAppName());
        instance.setMetadata(metadata);
        try {
            namingService.registerInstance(properties.getAppName(), NacosConsts.APP_GROUP_NAME, instance);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        String adminUrl = GateConsts.PRE_HTTP_PROTOCAL + properties.getAdminUrl() + AdminConsts.REGISTER_PATH;
        RegisterAppDTO dto = buildRegisterDto(instance);
        OkHttpTool.doPost(adminUrl, dto);
    }

    private RegisterAppDTO buildRegisterDto(Instance instance) {
        RegisterAppDTO dto = new RegisterAppDTO();
        dto.setIp(instance.getIp());
        dto.setAppName(properties.getAppName());
        dto.setPort(instance.getPort());
        dto.setContextPath(properties.getContextPath());
        dto.setVersion(properties.getVersion());
        return dto;
    }


    private boolean check(GuClientProperties properties) {
        return !(properties.getPort() == null || properties.getAppName() == null || properties.getVersion() == null
                || properties.getAdminUrl() == null || properties.getContextPath() == null);
    }

}
