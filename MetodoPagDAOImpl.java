package dao;

import java.util.Iterator;
import java.util.List;

import model.MetodoPag;
import model.Ordine;
import model.Utente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MetodoPagDAOImpl implements MetodoPagDAO {
	private SessionFactory sf;
	
	public MetodoPagDAOImpl(SessionFactory sf){
		this.sf=sf;
	}

	@Override
	public void getMetodi(Utente utente) {
		
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("select m from model.MetodoPag as m left join fetch m.utente where m.utente=:utente"); 
	        query.setEntity("utente",utente);
	        utente.setMetodi(query.list());
	        tx.commit();
		}catch (RuntimeException ex){
			try{
				ex.printStackTrace();
				tx.rollback();
			}catch (RuntimeException rbex){
				System.out.println("Rollback fallito");
			}
			throw ex;
		} finally{
			session.close();
		}
    }

	@Override
	public void addMetodo(MetodoPag metodo) {
		
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        session.saveOrUpdate(metodo);
	        tx.commit();
		}catch (RuntimeException ex){
			try{
				ex.printStackTrace();
				tx.rollback();
			}catch (RuntimeException rbex){
				System.out.println("Rollback fallito");
			}
			throw ex;
		} finally{
			session.close();
		}
	}

}

