function getPersonStatus(status){
    var type ="";
    if("0"==status) {
        type += "<option value='" + status + "'>无效</option>";
    }else if("1"==status){
        type+="<option value='"+status+"'>有效</option>";
    }else if("2"==status){
        type+="<option value='"+status+"'>注销</option>";
    }
    return type;
}

function getPersonNature(nature){
    var type ="";
    if("0"==nature){
        type+="<option value='"+nature+"'>团队负责人</option>";
    }else if("1"==nature){
        type+="<option value='"+nature+"'>销售经理</option>";
    }
    return type;
}

function formatDateTime(date) {
    if(!date){
        return "";
    }
    var d = new Date(date);
    var dformat = [ d.getFullYear(), (d.getMonth() + 1)<10?"0"+(d.getMonth() + 1):d.getMonth() + 1, d.getDate()<10?"0"+d.getDate():d.getDate() ].join('-')
        + ' ' + [ d.getHours()<10?"0"+d.getHours():d.getHours(), d.getMinutes()<10?"0"+d.getMinutes():d.getMinutes(), d.getSeconds()<10?"0"+d.getSeconds():d.getSeconds() ].join(':');
    return dformat;
}

function formatDate(date) {
    if(!date){
        return "";
    }
    var d = new Date(date);
    var dformat = [ d.getFullYear(), (d.getMonth() + 1)<10?"0"+(d.getMonth() + 1):d.getMonth() + 1, d.getDate()<10?"0"+d.getDate():d.getDate() ].join('-');
    return dformat;
}