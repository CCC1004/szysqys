package cn.stylefeng.guns.modular.szys.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 资源信息配置
 * @Author: superC
 * @Date: 2018/11/11 11:24
 */
@Component
@ConfigurationProperties(prefix = "param")
@PropertySource(value = "classpath:resources.yml")
public class ResourcesProperties {

    /**
     *   默认密码
     */
    @Value("${dePassword}")
    private String dePassword;

    @Value("${deType}")
    private String deType;

    @Value("${deRole}")
    private String deRole;

    public String getDeRole() {
        return deRole;
    }

    public void setDeRole(String deRole) {
        this.deRole = deRole;
    }

    public String getDePassword() {
        return dePassword;
    }

    public void setDePassword(String dePassword) {
        this.dePassword = dePassword;
    }

    public String getDeType() {
        return deType;
    }

    public void setDeType(String deType) {
        this.deType = deType;
    }
}
