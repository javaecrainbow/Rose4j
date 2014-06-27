package com.honestspring.rose4j.action;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import rose4j.Activator;

import com.honestspring.rose4j.model.ProjectBean;

public class BuildEnvironmentAction implements IObjectActionDelegate
{
	 ILog log = Activator.getDefault().getLog();
	private Shell shell;
	private ProjectBean projectBean;

	public BuildEnvironmentAction()
	{
		super();
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart)
	{
		shell = targetPart.getSite().getShell();
	}

	@Override
	public void run(IAction action)
	{
		boolean flag = MessageDialog.openQuestion(shell, "Rose4j", "Are you sure to make the environment");
		if (flag)
		{
			//begin to build environment
			System.out.println("begin make the environment");
			ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(shell);

			IRunnableWithProgress runnable = new BuildEnvironmentTask(projectBean);
			try
			{
				progressDialog.run(true, false, runnable);
			} catch (InvocationTargetException e)
			{
				log.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
		                0, "build environment error", null));
			} catch (InterruptedException e)
			{
				log.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
		                0, "build environment error", null));
			}

			/**
			 * 刷新工程
			 */
			projectBean.refresh();
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection)
	{
		projectBean = new ProjectBean(selection);
	}

}
