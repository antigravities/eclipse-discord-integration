package fr.kazejiyu.discord.rpc.integration.listener;

import static java.util.Objects.requireNonNull;

import java.util.function.Consumer;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;

/**
 * An {@link IWorkbenchListener} which behavior on {@link #postShutdown(IWorkbench) postShutdown}
 * event can be parameterized. 
 */
public class OnPostShutdown implements IWorkbenchListener {
	
	/** Called on {@link #postShutdown(IWorkbench)} */
	private final Consumer<IWorkbench> postShutdownCallback;
	
	/**
	 * Creates a new listener.
	 * 
	 * @param postShutdownCallback
	 * 			The callback to execute when the workbench is closed.
	 */
	public OnPostShutdown(Consumer<IWorkbench> postShutdownCallback) {
		this.postShutdownCallback = requireNonNull(postShutdownCallback, "The callback must not be null");
	}

	@Override
	public boolean preShutdown(IWorkbench workbench, boolean forced) {
		return true;
	}

	@Override
	public void postShutdown(IWorkbench workbench) {
		postShutdownCallback.accept(workbench);
	}
	
}
