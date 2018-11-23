package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.WrWiuB;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 取用水户信息 Mapper 接口
 * </p>
 *
 * @author superC
 * @since 2018-11-21
 */
public interface WrWiuBMapper extends BaseMapper<WrWiuB> {

    /**
     * 根据纳税人识别号（当前用户登录名），获取取用水信息
     * @param account 用户的登录名，即对应取用水户的纳税人识别号
     * @return
     */
    WrWiuB selectByAccount(String account);
}
