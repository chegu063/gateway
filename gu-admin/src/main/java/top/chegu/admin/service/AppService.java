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
 * @since 2021-04-13
 */
public interface AppService extends IService<App> {

    void register(RegisterAppDTO dto);

    void unRegister(UnRegisterAppDTO dto);
}
