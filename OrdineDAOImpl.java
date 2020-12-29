package dao;

import java.util.Iterator;
import java.util.List;

import model.Articolo;
import model.Ordine;
import model.OrdineFin;
import model.Utente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrdineDAOImpl implements OrdineDAO {
	
	private SessionFactory sf;
	
	public OrdineDAOImpl(SessionFactory sf){
		this.sf=sf;
	}
	
	
	//modificato, rimosso boolean e sostituito con ordineFin
	@Override
	public void salvaOrdine(Ordine ordine, OrdineFin ordineFin) {
		
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        ordine.setOrdineFin(ordineFin);
	    	session.save(ordine);
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
	
	//usato in removeFromCartAction
	@Override
	public void rimuoviOrdineTemp(int id) {
		
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("delete from model.Ordine where id=:id"); //select m from model.Magazzino as m left join fetch m.articolo
	        query.setInteger("id", id);
	        System.out.println("record rimossi" + query.executeUpdate());
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
	
	//usato in updateOrdineAction
	@Override
	public void updateOrdine(int id, int pezzi) {
		
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("update from model.Ordine set pezzi=:pezzi where id=:id"); //select m from model.Magazzino as m left join fetch m.articolo
	        query.setInteger("pezzi", pezzi);
	        query.setInteger("id", id);
	        query.executeUpdate();
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

	//usato in addToCartAction... SPOSTARE IN CARRELLO UTIL
	@Override
	public void aggiungiOrdineAlCarrello(List<Ordine> carrello, Ordine ordine) {
		//fa il merge degli ordini dello stesso articolo
		boolean flag=true;
		Iterator<Ordine> itr=carrello.iterator();
		
		while(itr.hasNext()){
			Ordine current=itr.next();
			if(current.getArticolo().equals(ordine.getArticolo())){
				updateOrdine(current.getId(), current.getPezzi()+ordine.getPezzi()); 
				flag=false;
				current.setPezzi(current.getPezzi() + ordine.getPezzi());
				//current.setArticolo(ordine.getArticolo());
				break;
			}
		}
		
		if(flag){
			carrello.add(ordine);//errato
			salvaOrdine(ordine,null); //modificato, rimosso boolean false e sostituito con ordineFin==null
		}	
		
	} 

	@Override
	public List<Ordine> mergeOrInsert(Utente utente, List<Ordine> carrello) {
		
		boolean flag=true;
		List<Ordine> carrelloOld=caricaOrdini(utente, null); //inizializzo la lista con gli ordini non finalizzati della precedente sessione MODIFICATO CON ORDINEFIN
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Iterator<Ordine> itr=carrelloOld.iterator();
	        Iterator<Ordine> itr2;
	        
	        while(itr.hasNext()){//scorro il vecchio carrello
	        	Ordine currentOld=itr.next();
	        	itr2=carrello.iterator();
	        	while(itr2.hasNext()){//scorro il nuovo carrello
	        		Ordine currentCarr=itr2.next();
	        		if(currentOld.getArticolo().equals(currentCarr.getArticolo())){//se esiste gia un ordine x quell' articolo, aggiorno il vecchio ordine
	        			currentOld.setPezzi(currentOld.getPezzi()+currentCarr.getPezzi());
	        			session.update(currentOld);
	        			itr2.remove();
	        			break; 
	        		}
	        	}
	        }
	        
	        //salvo i rimanenti nuovi e li aggiungo alla lista
	        itr=carrello.iterator();
	        while(itr.hasNext()){
	        	Ordine current=itr.next();
	        	current.setUtente(utente);
	        	session.save(current);
	        }
	        
	        carrelloOld.addAll(carrello);
	        
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
        return carrelloOld;
    }

	@Override
	public List<Ordine> caricaOrdini(Utente utente, OrdineFin ordineFin) {
		List<Ordine> ordini=null;
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
			Query query;
        
	        if(ordineFin!=null){
		        query = session.createQuery("select o from model.Ordine as o left join fetch o.articolo left join fetch o.utente where o.utente=:utente and o.ordineFin=:ordineFin"); //select m from model.Magazzino as m left join fetch m.articolo
		        query.setEntity("utente",utente);
		        query.setEntity("ordineFin", ordineFin);
		        ordini=query.list();
		        ordineFin.setOrdini(ordini); //cerca di ottimizzare qui....
	        } else {
	        	query = session.createQuery("select o from model.Ordine as o left join fetch o.articolo left join fetch o.utente where o.utente=:utente and o.ordineFin=null"); //select m from model.Magazzino as m left join fetch m.articolo
		        query.setEntity("utente",utente); 
		        ordini=query.list();
	        }
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
        
        return ordini;
	}

	@Override
	public List<Ordine> caricaVenduti(Articolo articolo) {
		List<Ordine> ordini=null;
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("select o from model.Ordine as o left join fetch o.articolo where o.articolo=:articolo and o.ordineFin is not null");
			query.setEntity("articolo", articolo);
			ordini=query.list();
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
        return ordini;
	}
		
}

/*@Override
	public List<Ordine> mergeOrInsert(Utente utente, List<Ordine> carrello) {
		
		boolean flag=true;
		List<Ordine> carrelloOld=caricaOrdini(utente, null); //inizializzo la lista con gli ordini non finalizzati della precedente sessione MODIFICATO CON ORDINEFIN
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Iterator itr=carrelloOld.iterator();
	        Iterator itr2;
	        
	        while(itr.hasNext()){//scorro il vecchio carrello
	        	Ordine currentOld=(Ordine)itr.next();
	        	itr2=carrello.iterator();
	        	while(itr2.hasNext()){//scorro il nuovo carrello
	        		Ordine currentCarr=(Ordine)itr2.next();
	        		if(currentOld.getArticolo().equals(currentCarr.getArticolo())){//se esiste gia un ordine x quell' articolo, aggiorno il vecchio ordine
	        			currentOld.setPezzi(currentOld.getPezzi()+currentCarr.getPezzi());
	        			session.update(currentOld);
	        			break; 
	        		}
	        	}
	        }
	        
	        //ora parto dal nuovo e controllo se ci sono ordini senza riferimenti precedenti
	        itr=carrello.iterator();
	        while(itr.hasNext()){
	        	Ordine currentCarr= (Ordine) itr.next();
	        	itr2=carrelloOld.iterator();
	        	flag=true;
	        	while(itr2.hasNext()){
	        		Ordine currentOld=(Ordine) itr2.next();
	        		if(currentOld.getArticolo().equals(currentCarr.getArticolo())){
	        			flag=false;
	        			break;
	        		}
	        		
	        	}
	        	if(flag){ //se l'ordine non ha riferimenti, lo aggiungo al vecchio carrello.
	        		currentCarr.setUtente(utente);
	        		session.save(currentCarr);
	        		carrelloOld.add(currentCarr);
	        	}
	        }
	        tx.commit();
	        }catch (RuntimeException ex){
				try{
					ex.printStackTrace();
					tx.rollback();
				}catch (RuntimeException rbex){
					System.out.println("Rollback fallito");
				}
			} finally{
				session.close();
			}
        //carrello=carrelloOld; //NON FUNZIONA. sto salvando la copia della reference di carrello!
        return carrelloOld;
    }*/

