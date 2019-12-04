var ctx = "\/";
jQuery(function () {
    var $inputThis = null;
    var $inputThisUser1 = null;
    var $inputThisAssignee = null;

    // 候选组
    jQuery('#groupFieldDiv').on('click', '.form-control', function () {
        //开启模态框
        jQuery('#myModal').modal('show');
        $inputThis = $(this);
        //加载角色列表
        jQuery.getJSON(ctx+"system/role/roleList",null,function (result) {
            if(result!=null){
                //清空列表
                jQuery("#role-table .tr").remove();
                for(i in result){
                    if(result[i].roleId!=null){
                        jQuery("#role-table").append("<tr class='tr'><td><input type='radio' name='roleInfo'></td><td>"+result[i].roleId+"</td><td>"+result[i].roleName+"</td></tr>");
                    }
                }
            }

        });

    });

    jQuery("#submitRole").click(function () {
        var roleId = jQuery("#role-table input:radio[name='roleInfo']:checked").parent().next().text();
        //遍历所有选择的数据，如果存在，则不让回显
        var flag = false;
        jQuery("#groupFieldDiv .form-control").each(function () {
            var val = jQuery(this).val();
            if(val==roleId){
                flag=true;
            }
        });

        if(flag){
            alert("该角色已经被选择");
            jQuery('#myModal').modal('hide');
            return;
        }

        jQuery('#myModal').modal('hide');
        jQuery($inputThis).val(roleId).trigger('change');
    });


    //候选人
    jQuery('#userFieldGroup1').on('click', '.form-control', function () {
        //开启模态框
        jQuery('#myModalUser1').modal('show');
        $inputThisUser1 = $(this);
        //加载角色列表
        jQuery.getJSON(ctx+"system/user/userList",null,function (result) {
            if(result!=null){
                //清空列表
                jQuery("#user1-table .tr").remove();
                for(i in result){
                    if(result[i].userId!=null){
                        jQuery("#user1-table").append("<tr class='tr'><td><input type='radio' name='userInfo'></td><td>"+result[i].userId+"</td><td>"+result[i].loginName+"</td><td>"+result[i].userName+"</td></tr>");
                    }
                }
            }

        });

    });

    jQuery("#submitUser1").click(function () {
        var userId = jQuery("#user1-table input:radio[name='userInfo']:checked").parent().next().text();
        //遍历所有选择的数据，如果存在，则不让回显
        var flag = false;
        jQuery("#userFieldGroup1 .form-control").each(function () {
            var val = jQuery(this).val();
            if(val==userId){
                flag=true;
            }
        });

        if(flag){
            alert("该用户已经被选择");
            jQuery('#myModalUser1').modal('hide');
            return;
        }

        jQuery('#myModalUser1').modal('hide');
        jQuery($inputThisUser1).val(userId).trigger('change');
    });


    //代理人
    jQuery('#assigneeFieldGroup').on('click', '.form-control', function () {
        //开启模态框
        jQuery('#myModalUser2').modal('show');
        $inputThisAssignee = $(this);
        //加载角色列表
        jQuery.getJSON(ctx+"system/user/userList",null,function (result) {
            if(result!=null){
                //清空列表
                jQuery("#user2-table .tr").remove();
                for(i in result){
                    if(result[i].userId!=null){
                        jQuery("#user2-table").append("<tr class='tr'><td><input type='radio' name='userInfo'></td><td>"+result[i].userId+"</td><td>"+result[i].loginName+"</td><td>"+result[i].userName+"</td></tr>");
                    }
                }
            }

        });

    });

    jQuery("#submitUser2").click(function () {
        var userId = jQuery("#user2-table input:radio[name='userInfo']:checked").parent().next().text();
        //遍历所有选择的数据，如果存在，则不让回显
        var flag = false;
        jQuery("#assigneeFieldGroup .form-control").each(function () {
            var val = jQuery(this).val();
            if(val==userId){
                flag=true;
            }
        });
        jQuery('#myModalUser2').modal('hide');
        jQuery($inputThisAssignee).val(userId).trigger('change');
    });
});