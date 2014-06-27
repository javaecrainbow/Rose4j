package com.honestspring.rose4j.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rose4j.Activator;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

import com.honestspring.rose4j.model.JavaTemplateArgs;
import com.honestspring.rose4j.model.JspTemplateArgs;
import com.honestspring.rose4j.model.ProjectBean;
import com.honestspring.rose4j.templates.AjaxTemplate;
import com.honestspring.rose4j.templates.BaseDaoImplTemplate;
import com.honestspring.rose4j.templates.BaseDaoTemplate;
import com.honestspring.rose4j.templates.ControllerTemplate;
import com.honestspring.rose4j.templates.DaoTemplate;
import com.honestspring.rose4j.templates.JspInputTemplate;
import com.honestspring.rose4j.templates.JspListTemplate;
import com.honestspring.rose4j.templates.ServiceImplTemplate;
import com.honestspring.rose4j.tools.LogUtils;
import com.honestspring.rose4j.tools.Tools;

public class CodeGenerationWizard extends Wizard implements INewWizard
{

	private CodeGenerationWizardPage page;
	private ISelection selection;
	private ProjectBean projectVo;
	//java代码生成
	private List<JavaTemplateArgs> javaTemplateArgsList;
	//jsp代码生成
	private List<JspTemplateArgs> jspTemplateArgsList;
	//private LogUtils log = new LogUtils();
	 ILog log = Activator.getDefault().getLog();	
	 public CodeGenerationWizard()
	{
		super();
		setNeedsProgressMonitor(true);
		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/wizard.jpg"));
		setWindowTitle("代码生成");
	}

	@Override
	public void addPages()
	{
		page = new CodeGenerationWizardPage(selection);
		addPage(page);
	}

	@Override
	public boolean performFinish()
	{
		IRunnableWithProgress op = new IRunnableWithProgress()
		{
			public void run(IProgressMonitor monitor) throws InvocationTargetException
			{
				monitor.beginTask("代码生成", 100);

				//定义模板
				DaoTemplate daoTemplate = new DaoTemplate();
				ServiceImplTemplate serviceTemplate = new ServiceImplTemplate();
				ControllerTemplate actionTemplate = new ControllerTemplate();
				JspListTemplate jspListTemplate = new JspListTemplate();
				JspInputTemplate jspInputTemplate = new JspInputTemplate();

				//-------------------------------------java代码生成-------------------------------------

				monitor.worked(1);
				monitor.subTask("java代码生成");
				for (JavaTemplateArgs javaTemplateArgs : javaTemplateArgsList)
				{
					try
					{
						//创建包
						IPackageFragmentRoot packageFragmentRoot = projectVo.getJavaProject().findPackageFragmentRoot(new Path("/" + projectVo.getName() + "/src"));
						IPackageFragment packageFragment = packageFragmentRoot.getPackageFragment(javaTemplateArgs.getPackageName());
						if (!packageFragment.exists())
						{
							packageFragment = packageFragmentRoot.createPackageFragment(javaTemplateArgs.getPackageName(), true, null);
						}
						//生成java代码
						String javaCode = "";
						switch (javaTemplateArgs.getType())
						{
						case DAO:
							javaCode = daoTemplate.generate(javaTemplateArgs);
							break;
						case SERVICE:
							javaCode = serviceTemplate.generate(javaTemplateArgs);
							break;
						case ACTION:
							javaCode = actionTemplate.generate(javaTemplateArgs);
							break;
						}
						packageFragment.createCompilationUnit(javaTemplateArgs.getClassName() + ".java", javaCode, true, new NullProgressMonitor());

					} catch (Exception e)
					{
						log.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				                0, "generate code", null));
					}
				}
				
				//-------------------------------------jsp代码生成-------------------------------------
				monitor.worked(1);
				monitor.subTask("jsp代码生成");
				for (JspTemplateArgs jspTemplateArgs : jspTemplateArgsList)
				{
					//创建文件夹
					String directoryPath = projectVo.getWebRoot() + "/screen/" + jspTemplateArgs.getModeName() + "/" + jspTemplateArgs.getClassNameInfo().getEntityObjectName();
					Tools.createDirectory(directoryPath);
					//创建文件
					String filePath = directoryPath + "/" + jspTemplateArgs.getJspName();
					Tools.createFile(filePath);

					//写文件
					String jspCode = "";
					switch (jspTemplateArgs.getType())
					{
					case LIST:
						jspCode = jspListTemplate.generate(jspTemplateArgs);
						break;
					case INPUT:
						jspCode = jspInputTemplate.generate(jspTemplateArgs);
						break;
					default:
						break;
					}
					Tools.writeStringToFile(filePath, jspCode);
				}
				monitor.done();
			}
		};

		try
		{
			getContainer().run(true, false, op);
		} catch (InvocationTargetException e)
		{
			log.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
	                0, "generate code", null));
			return false;
		} catch (InterruptedException e)
		{
			log.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
	                0, "generate code", null));
			return false;
		}

		/**
		 * 刷新工程
		 */
		projectVo.refresh();

		return true;
	}

	private void getBasePackage(){
		
	}
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection)
	{
		this.selection = selection;
		projectVo = new ProjectBean(selection);
		try
		{
			javaTemplateArgsList = Tools.createJavaTemplateArgsList(selection);
			jspTemplateArgsList = Tools.createJspTemplateArgsList(selection);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}