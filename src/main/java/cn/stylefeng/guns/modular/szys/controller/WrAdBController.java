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
import cn.stylefeng.guns.modular.system.model.WrAdB;
import cn.stylefeng.guns.modular.szys.service.IWrAdBService;

import java.util.Date;

/**
 * 行政区划管理控制器
 *
 * @author fengshuonan
 * @Date 2018-11-21 16:11:48
 */
@Controller
@RequestMapping("/wrAdB")
public class WrAdBController extends BaseController {

    private String PREFIX = "/szys/wrAdB/";

    @Autowired
    private IWrAdBService wrAdBService;

    /**
     * 跳转到行政区划管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wrAdB.html";
    }

    /**
     * 跳转到添加行政区划管理
     */
    @RequestMapping("/wrAdB_add")
    public String wrAdBAdd() {
        return PREFIX + "wrAdB_add.html";
    }

    /**
     * 跳转到修改行政区划管理
     */
    @RequestMapping("/wrAdB_update/{wrAdBId}")
    public String wrAdBUpdate(@PathVariable Integer wrAdBId, Model model) {
        WrAdB wrAdB = wrAdBService.selectById(wrAdBId);
        model.addAttribute("item",wrAdB);
        LogObjectHolder.me().set(wrAdB);
        return PREFIX + "wrAdB_edit.html";
    }

    /**
     * 获取行政区划管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return wrAdBService.selectList(null);
    }

    /**
     * 新增行政区划管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(WrAdB wrAdB) {
        Date date = new Date();
        wrAdB.setTs(date);
        wrAdBService.insert(wrAdB);
        return SUCCESS_TIP;
    }

    /**
     * 删除行政区划管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wrAdBId) {
        wrAdBService.deleteById(wrAdBId);
        return SUCCESS_TIP;
    }

    /**
     * 修改行政区划管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(WrAdB wrAdB) {
        Date date = new Date();
        wrAdB.setTs(date);
        wrAdBService.updateById(wrAdB);
        return SUCCESS_TIP;
    }

    /**
     * 行政区划管理详情
     */
    @RequestMapping(value = "/detail/{wrAdBId}")
    @ResponseBody
    public Object detail(@PathVariable("wrAdBId") Integer wrAdBId) {
        return wrAdBService.selectById(wrAdBId);
    }
}
