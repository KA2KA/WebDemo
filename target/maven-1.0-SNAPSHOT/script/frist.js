/**
 * Created by wuwan on 2016/9/24.
 */
var UserAction = {
    URI: {
        login: 'login.action',
    },
    Method: {
        /*登陆跳转主页面*/
        loginAction: function () {
            var username = $('#username').val();
            var password = $('#password').val();
            $.post(UserAction.URI.login, {username: username, password: password}, function (result) {
                if (result) {
                    window.location.href = "index.html";
                } else {
                    $('#loginInfoMessage').show();
                }
            });
        },
        /*此方法是“动态”加载菜单的方法*/
        openTab: function (node) {
            if ($('#content_tab').tabs('exists', node.text)) {
                $('#content_tab').tabs('select', node.text);
            } else {
                var nodeId = node.id;
                $('#content_tab').tabs("add", {
                    title: node.text,
                    closable: true,
                    fit: true,
                    iconCls: node.iconCls,
                    href: node.attributes.url
                });
            }
        },
    },
}

