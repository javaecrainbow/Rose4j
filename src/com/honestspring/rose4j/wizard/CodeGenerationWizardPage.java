package com.honestspring.rose4j.wizard;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.honestspring.rose4j.model.PackageNameInfo;

@SuppressWarnings( { "restriction" })
public class CodeGenerationWizardPage extends WizardPage
{
	private Text entityPackageText;//dao包名
	private Text daoPackageText;//dao包名
	private Text servicPackageText; //service包名
	private Text actionPackageText;//action包名

	private ISelection selection;

	protected CodeGenerationWizardPage(ISelection selection)
	{
		super("slave4j");
		setTitle("代码生成");
		setDescription("相应的包名设置");
		this.selection = selection;
	}

	@Override
	public void createControl(Composite parent)
	{
		//创建一个新的Composite
		Composite container = new Composite(parent, SWT.NULL);
		//设置网格布局
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;//2列
		layout.verticalSpacing = 9;//垂直间距
		//---------------------------------------------------------------
		Label label = new Label(container, SWT.NULL);
		label.setText("model包路径:");
		entityPackageText = new Text(container, SWT.BORDER | SWT.SINGLE);
		entityPackageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//---------------------------------------------------------------
		label = new Label(container, SWT.NULL);
		label.setText("dao包路径:");
		daoPackageText = new Text(container,  SWT.BORDER | SWT.SINGLE);
		daoPackageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//---------------------------------------------------------------
		label = new Label(container, SWT.NULL);
		label.setText("service包路径:");
		servicPackageText = new Text(container,  SWT.BORDER | SWT.SINGLE);
		servicPackageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//---------------------------------------------------------------
		label = new Label(container, SWT.NULL);
		label.setText("controller包路径:");
		actionPackageText = new Text(container,  SWT.BORDER | SWT.SINGLE);
		actionPackageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//---------------------------------------------------------------
		//设置焦点
		parent.setFocus();
		//初始化界面默认值
		initialize();

		dialogChanged();

		setControl(container);
	}

	/**
	 * 初始化界面默认值
	 */
	private void initialize()
	{
		if (selection != null && selection.isEmpty() == false && selection instanceof IStructuredSelection)
		{
			IStructuredSelection ssel = (IStructuredSelection) selection;

			Object obj = ssel.getFirstElement();
			if (obj instanceof PackageFragment)
			{
				PackageFragment packageFragment = (PackageFragment) obj;
				PackageNameInfo packageNameInfo = new PackageNameInfo(packageFragment);
				entityPackageText.setText(packageNameInfo.getEntityPackageName());
				daoPackageText.setText(packageNameInfo.getDaoPackageName());
				servicPackageText.setText(packageNameInfo.getServicPackageName());
				actionPackageText.setText(packageNameInfo.getActionPackageName());
			}
		}
	}

	/**
	 * 验证
	 */
	private void dialogChanged()
	{
		String entityPackageName = entityPackageText.getText();
		if (entityPackageName.length() == 0)
		{
			updateStatus("你没有选择正确的实体包！！！");
			return;
		}
		if (!entityPackageName.endsWith(".model"))
		{
			updateStatus("你选择的实体包名必须为model，如“com.google.blog.model”中的model");
			return;
		}
		if (StringUtils.countMatches(entityPackageName, ".") < 3)
		{
			updateStatus("实体包必须在4层以上，注意实体包名的上一层包名为模块名，如“com.honestspring.blog.model”中“blog”为博客模块");
			return;
		}
		updateStatus(null);
	}

	/**
	 * 改变向导页状态
	 * @param message
	 */
	private void updateStatus(String message)
	{
		setErrorMessage(message);
		setPageComplete(message == null);//完成按钮是否有效
	}
}
