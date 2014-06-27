package com.honestspring.rose4j.templates;

import com.honestspring.rose4j.model.*;

public class AjaxTemplate
{
  protected static String nl;
  public static synchronized AjaxTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    AjaxTemplate result = new AjaxTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.io.IOException;" + NL + "import java.io.StringWriter;" + NL + "import java.io.Writer;" + NL + "" + NL + "import javax.servlet.http.HttpServletRequest;" + NL + "" + NL + "import org.codehaus.jackson.map.ObjectMapper;" + NL + "import org.springframework.stereotype.Controller;" + NL + "import org.springframework.web.bind.annotation.PathVariable;" + NL + "import org.springframework.web.bind.annotation.RequestMapping;" + NL + "import org.springframework.web.bind.annotation.RequestMethod;" + NL + "import org.springframework.web.bind.annotation.ResponseBody;" + NL + "" + NL + "import com.honestspring.view.component.AbstractSysViewComponent;" + NL + "import com.honestspring.view.component.FunctionMenuComponent;" + NL + "import com.honestspring.view.component.HSListViewComponent;" + NL + "import com.honestspring.view.model.DataGrid;" + NL + "import com.honestspring.view.model.Menu;" + NL + "" + NL + "@Controller" + NL + "@RequestMapping(\"/para/list\")" + NL + "public class ListViewAjaxController {" + NL + "" + NL + "" + NL + "\t@RequestMapping(\"/datagrid\")" + NL + "\tpublic String getListDataGrid() {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t@RequestMapping(\"/getPrimaryKey\")" + NL + "\tpublic String getPrimaryKey() {" + NL + "\t\tAbstractSysViewComponent hsViewComponent = new HSListViewComponent();" + NL + "\t\t" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "\t@RequestMapping(value=\"/getViewList/{module}\" ,method = RequestMethod.GET)" + NL + "\tpublic @ResponseBody DataGrid getViewList(HttpServletRequest request, @PathVariable String module) {" + NL + "\t\tAbstractSysViewComponent hsViewComponent = new HSListViewComponent();" + NL + "\t\tDataGrid dataGridModel = (DataGrid) hsViewComponent.getObj(module);" + NL + "\t\tString productName=request.getContextPath();" + NL + "\t\tdataGridModel.setUrl(productName+\"/module/queryList\");" + NL + "\t\tdataGridModel.setSortName(module.toLowerCase()+\".\"+dataGridModel.getIdField());" + NL + "\t\tObjectMapper om = new ObjectMapper();" + NL + "\t\tWriter w = new StringWriter();" + NL + "\t\ttry {" + NL + "\t\t\tom.writeValue(w, dataGridModel);" + NL + "\t\t\tw.close();" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\t// 错误处理" + NL + "\t\t}" + NL + "\t\treturn dataGridModel;" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\t@RequestMapping(value=\"/getMenuList\" ,method = RequestMethod.GET)" + NL + "\tpublic @ResponseBody Menu getMenuList(HttpServletRequest request) {" + NL + "\t\tAbstractSysViewComponent functionMenuComponent = new FunctionMenuComponent();" + NL + "\t\tMenu menu = (Menu)functionMenuComponent.getObj(null);" + NL + "\t\tUserInfo userinfo = (UserInfo)request.getSession().getAttribute(\"userinfo\");" + NL + "\t\tObjectMapper om = new ObjectMapper();" + NL + "\t\tWriter w = new StringWriter();" + NL + "\t\tif(\"操作员\".equals(userinfo.getRole())){" + NL + "\t\t\tmenu.getMenus().remove(0);" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\tom.writeValue(w, menu);" + NL + "\t\t\tw.close();" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\t// 错误处理" + NL + "\t\t}" + NL + "\t\treturn menu;" + NL + "\t}" + NL + "}" + NL + NL;
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
JavaTemplateArgs args = (JavaTemplateArgs)argument;
	String modeName = args.getModeName();
	String packageName = args.getPackageName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
