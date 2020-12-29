package dao;

import java.util.Iterator;

import model.OrdineFin;
import model.Utente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrdineFinDAOImpl implements OrdineFinDAO {
	private SessionFactory sf;
	
	public OrdineFinDAOImpl(SessionFactory sf){
		this.sf=sf;
	}

	@Override
	public void loadOrdini(Utente utente) {
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
			Query query = session.createQuery("select o from model.OrdineFin as o left join fetch o.metodo where o.utente=:utente order by o.id desc"); 
	        query.setEntity("utente",utente);
	        utente.setOrdiniFin(query.list());
	        /*Iterator itr=utente.getOrdiniFin().iterator();
	        while(itr.hasNext()){
	        	query = session.createQuery("select o from model.Ordine as o left join fetch o.articolo left join fetch o.utente where o.utente=:utente and o.stato=:stato"); //select m from model.Magazzino as m left join fetch m.articolo
	        query.setEntity("utente",utente);
	        query.setBoolean("stato", stato);
	        ordini=query.list();
	        utente.setOrdini(ordini);
	        OrdineFin currentOrdineFin=(OrdineFin)itr.next();
	        System.out.println(currentOrdineFin);
	        	query = session.createQuery("select o from model.Ordine as o left join fetch o.articolo left join fetch o.utente where o.utente=:utente and ordineFin=:ordineFin");
	        	query.setEntity("utente",utente);
	        	query.setEntity("ordineFin",currentOrdineFin);
	        	currentOrdineFin.setOrdini(query.list());
	        }*/
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
