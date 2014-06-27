package com.rose4j.util;

import java.util.ArrayList;
import java.util.List;

import com.honestspring.view.common.Constant;
import com.honestspring.view.model.Toolbar;

public class ButtonUtil {

	public static List getToolBar(String desc1,String des2,String des3){
		List<Object> toolbars = new ArrayList<Object>();;
		Toolbar toolbar = new Toolbar();
		toolbar.setIconCls("icon-add");
		toolbar.setText(desc1);
		toolbar.setHandler("addRow");
		toolbars.add(toolbar);
		toolbars.add(Constant.VIEW_LIST_TOOLBAR_SPLIT_FLAG);
		Toolbar toolbar2 = new Toolbar();
		toolbar2.setIconCls("icon-edit");
		toolbar2.setText(des2);
		toolbar2.setHandler("updateRow");
		toolbars.add(toolbar2);
		toolbars.add(Constant.VIEW_LIST_TOOLBAR_SPLIT_FLAG);
		Toolbar toolbar3 = new Toolbar();
		toolbar3.setIconCls("icon-remove");
		toolbar3.setText(des3);
		toolbar3.setHandler("deleteRow");
		toolbars.add(toolbar3);
		toolbars.add(Constant.VIEW_LIST_TOOLBAR_SPLIT_FLAG);
		return toolbars;
	}
}
