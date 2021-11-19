package top.chegu.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.chegu.admin.bean.App;
import top.chegu.admin.mapper.AppMapper;
import top.chegu.admin.service.AppService;
import top.chegu.common.entity.dto.RegisterAppDTO;
import top.chegu.common.entity.dto.UnRegisterAppDTO;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chegu
 * @since 2021-04-13
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements AppService {

    @Override
    public void register(RegisterAppDTO dto) {

    }

    @Override
    public void unRegister(UnRegisterAppDTO dto) {

    }
}
