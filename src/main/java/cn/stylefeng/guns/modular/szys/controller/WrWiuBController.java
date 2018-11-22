package cn.stylefeng.guns.modular.szys.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.WrWiuB;
import cn.stylefeng.guns.modular.szys.service.IWrWiuBService;

import java.util.Date;

/**
 * 取用水户管理控制器
 *
 * @author superC
 * @Date 2018-11-21 10:28:41
 */
@Controller
@RequestMapping("/wrWiuB")
public class WrWiuBController extends BaseController {

    private String PREFIX = "/szys/wrWiuB/";

    @Autowired
    private IWrWiuBService wrWiuBService;

    /**
     * 跳转到取用水户管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wrWiuB.html";
    }

    /**
     * 跳转到添加取用水户管理
     */
    @RequestMapping("/wrWiuB_add")
    public String wrWiuBAdd() {
        return PREFIX + "wrWiuB_add.html";
    }

    /**
     * 跳转到修改取用水户管理
     */
    @RequestMapping("/wrWiuB_update/{wrWiuBId}")
    public String wrWiuBUpdate(@PathVariable String wrWiuBId, Model model) {
        WrWiuB wrWiuB = wrWiuBService.selectById(wrWiuBId);
        model.addAttribute("item",wrWiuB);
        LogObjectHolder.me().set(wrWiuB);
        return PREFIX + "wrWiuB_edit.html";
    }

    /**
     * 获取取用水户管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return wrWiuBService.selectList(null);
    }

    /**
     * 新增取用水户管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WrWiuB wrWiuB) {
        Date date = new Date();
        wrWiuB.setTs(date);
        wrWiuBService.insert(wrWiuB);
        return SUCCESS_TIP;
    }

    /**
     * 删除取用水户管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String wrWiuBId) {
        wrWiuBService.deleteById(wrWiuBId);
        return SUCCESS_TIP;
    }

    /**
     * 修改取用水户管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WrWiuB wrWiuB) {
        Date date = new Date();
        wrWiuB.setTs(date);
        wrWiuBService.updateById(wrWiuB);
        return SUCCESS_TIP;
    }

    /**
     * 取用水户管理详情
     */
    @RequestMapping(value = "/detail/{wrWiuBId}")
    @ResponseBody
    public Object detail(@PathVariable("wrWiuBId") String wrWiuBId) {
        return wrWiuBService.selectById(wrWiuBId);
    }
}
