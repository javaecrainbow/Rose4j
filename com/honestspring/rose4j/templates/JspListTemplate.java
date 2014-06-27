package com.honestspring.rose4j.templates;

import java.util.List;
import com.honestspring.rose4j.model.*;

public class JspListTemplate
{
  protected static String nl;
  public static synchronized JspListTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    JspListTemplate result = new JspListTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<%@ page contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>" + NL + "<%@include file=\"../../hs_common.jsp\"%>" + NL + "<%@ taglib uri=\"/SYSVIEW\" prefix=\"sysview\"%>" + NL + " \t<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">" + NL + "\t<html>" + NL + "  <head>" + NL + "           <link href=\"<%=basepath %>/css/validator.css\" rel=\"stylesheet\" type=\"text/css\" />" + NL + "  " + NL + "  " + NL + "  </head>" + NL + "  <body>" + NL + "<script type=\"text/javascript\">" + NL + " var date=Date.parse(new Date());" + NL + " var primiarykey ;" + NL + " " + NL + "\tfunction showWindow(options){" + NL + "\t\t$(\"#MyPopWindow\").window(options);" + NL + "\t}" + NL + "\t//关闭弹出窗口" + NL + "\tfunction closeWindow(){" + NL + "\t\t$(\"#MyPopWindow\").window('close');" + NL + "\t}" + NL + "    //新增" + NL + "    var addRow = function addrow(){" + NL + "    \tshowWindow({" + NL + "  \t\t\ttitle:'增加信息'," + NL + "  \t\t\thref:'<%=basepath %>/";
  protected final String TEXT_2 = "/popWindow'," + NL + "  \t\t\twidth:450," + NL + "  \t\t\theight:400," + NL + "  \t\t\tonLoad: function(){" + NL + "  \t\t\t\t$('#screenForm').form('clear');" + NL + "  \t\t\t}" + NL + "  \t\t\t" + NL + "  \t\t});" + NL + "\t};" + NL + "\t  //更新" + NL + "    var updateRow = function updaterow(){" + NL + "\t\tvar rows = $('#listTable').datagrid('getSelections');" + NL + "\t\t//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选" + NL + "\t\tif(rows.length==0){" + NL + "\t\t\t$.messager.alert('提示',\"请选择你要更新的数据\",'info');" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif(rows.length > 1){" + NL + "\t\t\t$.messager.alert('提示',\"只能选择一条数据进行更新\",'info');" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tshowWindow({" + NL + "  \t\t\ttitle:'更新信息'," + NL + "  \t\t\thref:'<%=basepath %>/";
  protected final String TEXT_3 = "/popWindow'," + NL + "  \t\t\twidth:450," + NL + "  \t\t\theight:400," + NL + "  \t\t\tonLoad: function(){" + NL + "  \t\t\t//自动将数据填充到表单中，无需再查询数据库，这里需要注意：" + NL + "  \t\t\t//如果用的是struts2，它的表单元素的名称都是user.id这样的，那load的时候不能加.user要.form('load', rows[0]);" + NL + "  \t\t\t//而spring mvc中表单元素的名称不带对象前缀，直拉就是id，所以这里load的时候是：.form('load', rows[0].user)" + NL + "  \t\t\t\t$(\"#screenForm\").form('load', rows[0]);" + NL + "  \t\t\t}" + NL + "  \t\t});" + NL + "\t};" + NL + "\t//删除" + NL + "  \tvar deleteRow = function deleterow(){" + NL + "  \tvar rows = $('#listTable').datagrid('getSelections');" + NL + "\t\t//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选" + NL + "\t\tif(rows.length==0){" + NL + "\t\t\t$.messager.alert('提示',\"请选择数据\",'info');" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "  \t\t$.messager.confirm('提示','确定要删除吗?',function(result){" + NL + "\t        if (result){" + NL + "\t        \tvar rows = $('#listTable').datagrid('getSelections');" + NL + "\t        \tvar ps = \"\";" + NL + "\t        \t$.each(rows,function(i,n){" + NL + "\t        \t\tif(i==0) " + NL + "\t        \t\t\tps += \"?uid=\"+n[primiarykey];" + NL + "\t        \t\telse" + NL + "\t        \t\t\tps += \"&uid=\"+n[primiarykey];" + NL + "\t        \t});" + NL + "\t        \t$.post('<%=basepath %>/";
  protected final String TEXT_4 = "/delete'+ps,function(data){" + NL + "\t\t        \t$('#listTable').datagrid('reload'); " + NL + "\t        \t\t$.messager.alert('提示',data.mes,'info');" + NL + "\t        \t});" + NL + "\t        }" + NL + "\t    });" + NL + "  \t};" + NL + "  \tvar clearData = function cleardata(){" + NL + "\t\t$('#listTable').datagrid('clearSelections');" + NL + "\t};" + NL + "    $(function(){" + NL + "    \t" + NL + "    \t$.getJSON(\"<%=basepath %>\"+\"/para/list/getViewList/";
  protected final String TEXT_5 = "\",function(data) { " + NL + "    \t\t}).success(function(data) {" + NL + "    \t\t\tdata.onLoadSuccess=function(){" + NL + "    \t\t\t\t$('#listTable').datagrid('clearSelections');" + NL + "    \t\t\t};" + NL + "    \t\t" + NL + "    \t\t\tfor(var i = 0;i<data.columns[0].length;i++){" + NL + "\t\t\t\t\tvar fieldName = data.columns[0][i].field;" + NL + "\t\t\t\t\tif(fieldName.indexOf(\".\")>0){" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tvar name = fieldName;" + NL + "    \t\t\t\tdata.columns[0][i].formatter = function(value,row,index){" + NL + "    \t\t\t\t\tvar names = fieldName.split(\".\");" + NL + "    \t\t\t\t\treturn row[names[0]][names[1]];" + NL + "    \t\t\t\t};" + NL + "    \t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "    \t\t\t}" + NL + "    \t\t\t$('#listTable').datagrid(data);" + NL + "    \t\t\tconsole.info(data);" + NL + "    \t\t\tprimiarykey = data.idField;" + NL + "    \t\t\t})" + NL + "    \t\t\t.error(function() { alert(\"error\"); });" + NL + "\t});" + NL + "" + NL + "" + NL + "    function addOrUpdateUser(){" + NL + "\t\t$(\"#screenForm\").Validform({" + NL + "\t\t\ttiptype:2," + NL + "\t\t\tajaxPost:true," + NL + "\t\t\tcallback:function(data){" + NL + "\t\t\t\t//返回数据data是json格式，{\"info\":\"demo info\",\"status\":\"y\"}" + NL + "\t\t\t\t//info: 输出提示信息;" + NL + "\t\t\t\t//status: 返回提交数据的状态,是否提交成功。如可以用\"y\"表示提交成功，\"n\"表示提交失败，在ajax_post.php文件返回数据里自定字符，主要用在callback函数里根据该值执行相应的回调操作;" + NL + "\t\t\t\t//你也可以在ajax_post.php文件返回更多信息在这里获取，进行相应操作；" + NL + "\t\t\t\t" + NL + "\t\t\t\t//这里执行回调操作;" + NL + "\t\t\t\tif(data.status==\"y\"){" + NL + "\t\t\t\t\tsetTimeout(function(){" + NL + "\t\t\t\t\t\t$.Hidemsg(); //公用方法关闭信息提示框;" + NL + "\t\t\t\t\t},2000);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\t" + NL + "\t\t$.post(\"<%=basepath %>/";
  protected final String TEXT_6 = "/addOrUpdate\",$(\"#screenForm\").serializeArray(),function(data){" + NL + "\t\t\t$('#MyPopWindow').window('close');" + NL + "\t\t\t$('#listTable').datagrid('reload');  " + NL + "\t\t\t$.messager.alert('提示',data.mes,'info');" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "  " + NL + "    //表格查询" + NL + "\tfunction searchUser(){" + NL + "    \tdebugger;" + NL + "\t\tvar params = $('#listTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数" + NL + "\t\tvar fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象" + NL + "\t\t$.each( fields, function(i, field){" + NL + "\t\t\tparams[field.name] = field.value; //设置查询参数" + NL + "\t\t}); " + NL + "\t\t$('#listTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了" + NL + "\t}" + NL + "\t//清空查询条件" + NL + "\tfunction clearForm(){" + NL + "\t\t$('#queryForm').form('clear');" + NL + "\t\t//searchUser();" + NL + "\t}" + NL + "\t</script>" + NL + "     <form id=\"queryForm\" style=\"margin:10;text-align: center;\">" + NL + "\t\t<table width=\"100%\">" + NL + "\t\t\t<sysview:cata module=\"";
  protected final String TEXT_7 = "\"/>" + NL + "\t\t\t<tr>" + NL + "\t\t\t<td align=\"right\" colspan=\"4\"><a href=\"#\" onclick=\"clearForm();\" class=\"easyui-linkbutton\" iconCls=\"icon-search\">清空</a><a href=\"#\" onclick=\"searchUser();\" class=\"easyui-linkbutton\" iconCls=\"icon-search\">查询</a></td>" + NL + "\t\t\t</tr>" + NL + "\t\t</table>" + NL + "\t</form>" + NL + "\t<div style=\"padding:10\" id=\"tabdiv\">" + NL + "\t" + NL + "\t\t<table id=\"listTable\"></table>" + NL + "\t</div>" + NL + "\t" + NL + "  </body>" + NL + "</html>";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	JspTemplateArgs args = (JspTemplateArgs)argument;
	
	String modeName = args.getModeName();
	String entityName = args.getEntityName();
	String jspName = args.getJspName();
	
	List<EntityFieldInfo> entityFieldInfoList = args.getEntityFieldInfoList();
	
	String entityPackageName = args.getPackageNameInfo().getEntityPackageName();
	String daoPackageName = args.getPackageNameInfo().getDaoPackageName();
	String servicePackageName = args.getPackageNameInfo().getServicPackageName();
	String actionPackageName = args.getPackageNameInfo().getActionPackageName();
	
	String entityClassName = args.getClassNameInfo().getEntityClassName();
	String daoClassName = args.getClassNameInfo().getDaoClassName();
	String serviceClassName = args.getClassNameInfo().getServicClassName();
	String actionClassName = args.getClassNameInfo().getActionClassName();
	
	String entityObjectName = args.getClassNameInfo().getEntityObjectName();
	String daoObjectName = args.getClassNameInfo().getDaoObjectName();
	String serviceObjectName = args.getClassNameInfo().getServicObjectName();
	String actionObjectName = args.getClassNameInfo().getActionObjectName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(entityObjectName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(entityClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
