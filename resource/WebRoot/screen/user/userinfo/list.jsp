<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../hs_common.jsp"%>
<%@ taglib uri="/SYSVIEW" prefix="sysview"%>
 	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
  <head>
           <link href="<%=basepath %>/css/validator.css" rel="stylesheet" type="text/css" />
  
  
  </head>
  <body>
<script type="text/javascript">
 var date=Date.parse(new Date());
 var primiarykey ;
 
	function showWindow(options){
		$("#MyPopWindow").window(options);
	}
	//关闭弹出窗口
	function closeWindow(){
		$("#MyPopWindow").window('close');
	}
    //新增
    var addRow = function addrow(){
    	showWindow({
  			title:'增加信息',
  			href:'<%=basepath %>/userinfo/popWindow',
  			width:450,
  			height:400,
  			onLoad: function(){
  				$('#screenForm').form('clear');
  			}
  			
  		});
	};
	  //更新
    var updateRow = function updaterow(){
		var rows = $('#listTable').datagrid('getSelections');
		//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要更新的数据",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一条数据进行更新",'info');
			return;
		}
		showWindow({
  			title:'更新信息',
  			href:'<%=basepath %>/userinfo/popWindow',
  			width:450,
  			height:400,
  			onLoad: function(){
  			//自动将数据填充到表单中，无需再查询数据库，这里需要注意：
  			//如果用的是struts2，它的表单元素的名称都是user.id这样的，那load的时候不能加.user要.form('load', rows[0]);
  			//而spring mvc中表单元素的名称不带对象前缀，直拉就是id，所以这里load的时候是：.form('load', rows[0].user)
  				$("#screenForm").form('load', rows[0]);
  			}
  		});
	};
	//删除
  	var deleteRow = function deleterow(){
  	var rows = $('#listTable').datagrid('getSelections');
		//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
		if(rows.length==0){
			$.messager.alert('提示',"请选择数据",'info');
			return;
		}
  		$.messager.confirm('提示','确定要删除吗?',function(result){
	        if (result){
	        	var rows = $('#listTable').datagrid('getSelections');
	        	var ps = "";
	        	$.each(rows,function(i,n){
	        		if(i==0) 
	        			ps += "?uid="+n[primiarykey];
	        		else
	        			ps += "&uid="+n[primiarykey];
	        	});
	        	$.post('<%=basepath %>/userinfo/delete'+ps,function(data){
		        	$('#listTable').datagrid('reload'); 
	        		$.messager.alert('提示',data.mes,'info');
	        	});
	        }
	    });
  	};
  	var clearData = function cleardata(){
		$('#listTable').datagrid('clearSelections');
	};
    $(function(){
    	
    	$.getJSON("<%=basepath %>"+"/para/list/getViewList/userinfo",function(data) { 
    		}).success(function(data) {
    			data.onLoadSuccess=function(){
    				$('#listTable').datagrid('clearSelections');
    			};
    		
    			for(var i = 0;i<data.columns[0].length;i++){
					var fieldName = data.columns[0][i].field;
					if(fieldName.indexOf(".")>0){
						
						var name = fieldName;
    				data.columns[0][i].formatter = function(value,row,index){
    					var names = fieldName.split(".");
    					return row[names[0]][names[1]];
    				};
    				break;
					}
    			}
    			$('#listTable').datagrid(data);
    			console.info(data);
    			primiarykey = data.idField;
    			})
    			.error(function() { alert("error"); });
	});


    function addOrUpdateUser(){
		$("#screenForm").Validform({
			tiptype:2,
			ajaxPost:true,
			callback:function(data){
				//返回数据data是json格式，{"info":"demo info","status":"y"}
				//info: 输出提示信息;
				//status: 返回提交数据的状态,是否提交成功。如可以用"y"表示提交成功，"n"表示提交失败，在ajax_post.php文件返回数据里自定字符，主要用在callback函数里根据该值执行相应的回调操作;
				//你也可以在ajax_post.php文件返回更多信息在这里获取，进行相应操作；
				
				//这里执行回调操作;
				if(data.status=="y"){
					setTimeout(function(){
						$.Hidemsg(); //公用方法关闭信息提示框;
					},2000);
				}
			}
		});
		
		$.post("<%=basepath %>/userinfo/addOrUpdate",$("#screenForm").serializeArray(),function(data){
			$('#MyPopWindow').window('close');
			$('#listTable').datagrid('reload');  
			$.messager.alert('提示',data.mes,'info');
		});
	}

  
    //表格查询
	function searchUser(){
    	debugger;
		var params = $('#listTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#listTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('clear');
		//searchUser();
	}
	</script>
     <form id="queryForm" style="margin:10;text-align: center;">
		<table width="100%">
			<sysview:cata module="Userinfo"/>
			<tr>
			<td align="right" colspan="4"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a><a href="#" onclick="searchUser();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			</tr>
		</table>
	</form>
	<div style="padding:10" id="tabdiv">
	
		<table id="listTable"></table>
	</div>
	
  </body>
</html>
