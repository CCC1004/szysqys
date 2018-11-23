package cn.stylefeng.guns.modular.szys.service;

import cn.stylefeng.guns.modular.system.model.WrWiuB;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 取用水户信息 服务类
 * </p>
 *
 * @author superC
 * @since 2018-11-21
 */
public interface IWrWiuBService extends IService<WrWiuB> {


    /**
     * 根据纳税人识别号（或统一社会信用代码）,获取取用水户信息
     */
    WrWiuB selectByAccount(String account);

}
