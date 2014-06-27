<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@include file="hs_common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Complex Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../themes/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
		<link rel="stylesheet" type="text/css" href="../themes/demo.css">
	<script type="text/javascript" src="../js/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.easyui.min.js"></script>
	<script src="../js/sys_js/wikmenu.js" type="text/javascript"></script>
    <script src="../js/sys_js/wikmain.js" type="text/javascript"></script>
	<script type="text/javascript">
	 var _menus = { "menus": [
						{ "menuid": "1", "icon": "icon-sys", "menuname": "控件使用",
						    "menus": [{ "menuid": "11", "menuname": "我的博客", "icon": "icon-nav", "url": "<%=basepath%>/users/list" },
									{ "menuid": "12", "menuname": "添加用户", "icon": "icon-add", "url": "demo.html" },
									{ "menuid": "13", "menuname": "用户管理", "icon": "icon-users", "url": "/users/list" },
									{ "menuid": "14", "menuname": "角色管理", "icon": "icon-role", "url": "demo2.html" },
									{ "menuid": "15", "menuname": "权限设置", "icon": "icon-set", "url": "demo.html" },
									{ "menuid": "16", "menuname": "系统日志", "icon": "icon-log", "url": "demo1.html" }
								]
						}, { "menuid": "8", "icon": "icon-sys", "menuname": "毕设管理",
						    "menus": [{ "menuid": "21", "menuname": "系统UI设置", "icon": "icon-set", "url": "demo.html" },
									{ "menuid": "22", "menuname": "功能设置", "icon": "icon-set", "url": "demo1.html" },
										{"menuid": "23", "menuname": "登陆设置", "icon": "icon-set", "url": "demo1.html" 
									}
								]
						}, { "menuid": "56", "icon": "icon-sys", "menuname": "部门管理",
						    "menus": [{ "menuid": "31", "menuname": "添加部门", "icon": "icon-nav", "url": "demo1.html" },
									{ "menuid": "32", "menuname": "部门列表", "icon": "icon-nav", "url": "demo2.html" }
								]
						}, { "menuid": "28", "icon": "icon-sys", "menuname": "财务管理",
						    "menus": [{ "menuid": "41", "menuname": "收支分类", "icon": "icon-nav", "url": "demo.html" },
									{ "menuid": "42", "menuname": "报表统计", "icon": "icon-nav", "url": "demo1.html" },
									{ "menuid": "43", "menuname": "添加支出", "icon": "icon-nav", "url": "demo2.html" }
								]
						}, { "menuid": "39", "icon": "icon-sys", "menuname": "商城管理",
						    "menus": [{ "menuid": "51", "menuname": "商品分类", "icon": "icon-nav", "url": "demo.html" },
									{ "menuid": "52", "menuname": "商品列表", "icon": "icon-nav", "url": "demo1.html" },
									{ "menuid": "53", "menuname": "商品订单", "icon": "icon-nav", "url": "demo2.html" }
								]
						}
				]
		};
		 function openPwd() {
             $('#w').window({
                 title: '修改密码',
                 width: 300,
                 modal: true,
                 shadow: true,
                 closed: true,
                 height: 160,
                 resizable: false
             });
         }
         //关闭登录窗口
         function closePwd() {
             $('#w').window('close');
         }
         
        //初始化左侧
function InitLeftMenu1() {

    $(".easyui-accordion1").empty();
    var menulist = "";
   
    $.each(_menus.menus, function(i, n) {
        menulist += '<div title="'+n.menuname+'"  icon="'+n.icon+'" style="overflow:auto;">';
		menulist += '<ul>';
        $.each(n.menus, function(j, o) {
			menulist += '<li><div><a ref="'+o.menuid+'" href="#" rel="' + o.url + '" ><span class="icon '+o.icon+'" >&nbsp;</span><span class="nav">' + o.menuname + '</span></a></div></li> ';
        })
        menulist += '</ul></div>';
    })

	$(".easyui-accordion1").append(menulist);
	
	$('.easyui-accordion1 li a').click(function(){
		var tabTitle = $(this).children('.nav').text();

		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = getIcon(menuid,icon);
		
		addTab(tabTitle,url,icon);
		$('.easyui-accordion1 li div').removeClass("selected");
		$(this).parent().addClass("selected");
	}).hover(function(){
		$(this).parent().addClass("hover");
	},function(){
		$(this).parent().removeClass("hover");
	});
	
	//导航菜单绑定初始化
	$(".easyui-accordion1").accordion();
}
         $(function () {
             InitLeftMenu1();

             
         });
	
	
	</script>
</head>
<body class="easyui-layout">
	<div style="margin:10px 0;"></div>
	<div class="easyui-layout" style="width:1800px;height:900px;">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
	
		<div data-options="region:'west',split:true" title="导航菜单" style="width:150px;">
			<div class="easyui-accordion1" fit="true" border="false">
		<!--  导航内容 -->
     

				
			</div>

    </div>
		<div data-options="region:'center',title:'Main Title', iconCls:'icon-ok'">
			<div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div title="About" data-options="href:'./_content.html'" style="padding:10px"></div>
				<div title="DataGrid" style="padding:5px">
					<table class="easyui-datagrid"
							data-options="url:'../data/datagrid_data1.json',singleSelect:true,fit:true,fitColumns:true">
						<thead>
							<tr>
								<th data-options="field:'itemid'" width="80">Item ID</th>
								<th data-options="field:'productid'" width="100">Product ID</th>
								<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
								<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
								<th data-options="field:'attr1'" width="150">Attribute</th>
								<th data-options="field:'status',align:'center'" width="50">Status</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>