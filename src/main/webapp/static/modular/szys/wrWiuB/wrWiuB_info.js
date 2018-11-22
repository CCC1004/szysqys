/**
 * 初始化取用水户管理详情对话框
 */
var WrWiuBInfoDlg = {
    wrWiuBInfoData : {}
};

/**
 * 清除数据
 */
WrWiuBInfoDlg.clearData = function() {
    this.wrWiuBInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WrWiuBInfoDlg.set = function(key, val) {
    this.wrWiuBInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WrWiuBInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WrWiuBInfoDlg.close = function() {
    parent.layer.close(window.parent.WrWiuB.layerIndex);
}

/**
 * 收集数据
 */
WrWiuBInfoDlg.collectData = function() {
    this
    .set('uuid')
    .set('djxh')
    .set('nsrsbh')
    .set('wiuNm')
    .set('lrNm')
    .set('lawAtt')
    .set('userTp')
    .set('tradTp')
    .set('isHiLev')
    .set('ecoTp')
    .set('monG')
    .set('wiuTp')
    .set('yrWu')
    .set('certSta')
    .set('isVimp')
    .set('adlCd')
    .set('sljgCd')
    .set('swjgCd')
    .set('web')
    .set('eMail')
    .set('addr')
    .set('zip')
    .set('tel')
    .set('fax')
    .set('isuse')
    .set('runSta')
    .set('ts')
    .set('lgtd')
    .set('lttd')
    .set('nt');
}

/**
 * 提交添加
 */
WrWiuBInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wrWiuB/add", function(data){
        Feng.success("添加成功!");
        window.parent.WrWiuB.table.refresh();
        WrWiuBInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wrWiuBInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WrWiuBInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wrWiuB/update", function(data){
        Feng.success("修改成功!");
        window.parent.WrWiuB.table.refresh();
        WrWiuBInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wrWiuBInfoData);
    ajax.start();
}

$(function() {

});
