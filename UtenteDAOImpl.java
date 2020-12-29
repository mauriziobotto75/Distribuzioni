package dao;

import model.Utente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

public class UtenteDAOImpl implements UtenteDAO {

	private SessionFactory sf;
    
    public UtenteDAOImpl(SessionFactory sf){
        this.sf = sf;
    }
    
    @Override
    public Utente getUtenteByCredentials(String userName, String password) {
    	Utente user=null;
    	Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
		    Query query = session.createQuery("from Utente where username=:username and password=:password"); 
		    query.setString("username", userName); query.setString("password", password);
		    user = (Utente) query.uniqueResult();
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
       
        return user;
    }

	@Override
	public void createUtente(Utente utente) throws ConstraintViolationException{
		Session session=null;
		Transaction tx=null;
		try{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(utente); 
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

