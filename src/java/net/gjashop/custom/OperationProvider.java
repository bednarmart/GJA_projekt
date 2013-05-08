package net.gjashop.custom;

import net.gjashop.dao.OperationProviderBase;
import org.hibernate.cfg.Configuration;

import org.hibernate.classic.Session;

// this class is only generated once. it can be customized and all changes
// will be preserved.
public class OperationProvider extends OperationProviderBase implements IDBOperations {

	public OperationProvider(Session session) {        
		super(session);
	}
}
