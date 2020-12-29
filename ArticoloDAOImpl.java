package dao;

import model.Articolo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

public class ArticoloDAOImpl implements ArticoloDAO{
	
	private SessionFactory sf;
	
	public ArticoloDAOImpl(SessionFactory sf){
        this.sf = sf;
    }

	@Override
	public void addArticolo(Articolo articolo) throws ConstraintViolationException{
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
			session.save(articolo);
			tx.commit();
		} catch (RuntimeException ex){
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
	public Articolo getArticoloFromId(int id) {
		Session session=null;
		Transaction tx=null;
		Articolo articolo=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("from model.Articolo where id=:id"); //
	        query.setInteger("id", id);
	        articolo=(Articolo) query.uniqueResult();
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
		return articolo;
	}

	@Override
	public void modifyArticolo(Articolo articolo) {
		Session session=null;
		Transaction tx=null;
		try{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.update(articolo);
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
