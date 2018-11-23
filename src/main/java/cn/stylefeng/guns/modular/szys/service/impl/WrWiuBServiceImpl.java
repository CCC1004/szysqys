package cn.stylefeng.guns.modular.szys.service.impl;

import cn.stylefeng.guns.modular.system.dao.WrAdBMapper;
import cn.stylefeng.guns.modular.system.model.WrWiuB;
import cn.stylefeng.guns.modular.system.dao.WrWiuBMapper;
import cn.stylefeng.guns.modular.szys.service.IWrWiuBService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 取用水户信息 服务实现类
 * </p>
 *
 * @author superC
 * @since 2018-11-21
 */
@Service
public class WrWiuBServiceImpl extends ServiceImpl<WrWiuBMapper, WrWiuB> implements IWrWiuBService {


    @Override
    public WrWiuB selectByAccount(String account) {
        WrWiuB wrWiuB = this.baseMapper.selectByAccount(account);
        return wrWiuB;
    }
}
