<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/SYSVIEW" prefix="sysview"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  
  </head>

  <body>
  	<!-- 验证还是jquery-validation好用，这里省事没用 -->
	<form id="screenForm" method="post" style="margin: 10;text-align: center;">
		<table width="100%">
		<sysview:screen module="Userinfo"></sysview:screen>
			</table>
		<div style="padding-top: 163px">
		<a href="#" id="btn-back" onclick="closeWindow();" class="easyui-linkbutton" iconCls="icon-back">返回</a>
		<a href="#" id="btn-add" onclick="addOrUpdateUser();" class="easyui-linkbutton" iconCls="icon-save">保存</a>
		</div>
	</form>
	<script type="text/javascript">
  	  $(function(){
  			//$(".registerform").Validform();  //就这一行代码！下面是演示两种不同的验证效果;
  			//提示效果二;
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
  		});
   </script>
  </body>
  	 
</html>
