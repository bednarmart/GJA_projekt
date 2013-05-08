package net.gjashop.custom;

import net.gjashop.dao.ERPDAOBase;

// this class is only generated once. it can be customized and all changes
// will be preserved.
public class ERPDAO extends ERPDAOBase {

	public ERPDAO(Class<?> contextClass) {
		super(contextClass);
	}
	
	public void handleException(Exception e, boolean retry) {
		e.printStackTrace();
	}
}
