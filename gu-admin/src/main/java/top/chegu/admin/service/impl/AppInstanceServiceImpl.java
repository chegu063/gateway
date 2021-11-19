package top.chegu.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.chegu.admin.bean.AppInstance;
import top.chegu.admin.mapper.AppInstanceMapper;
import top.chegu.admin.service.IAppInstanceService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chegu
 * @since 2021-04-14
 */
@Service
public class AppInstanceServiceImpl extends ServiceImpl<AppInstanceMapper, AppInstance> implements IAppInstanceService {

}
