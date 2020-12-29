package dao;

import java.util.Iterator;
import java.util.List;

import model.Articolo;
import model.Magazzino;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MagazzinoDAOImpl implements MagazzinoDAO{
	
	private SessionFactory sf;
	
	public MagazzinoDAOImpl(SessionFactory sf){
		this.sf=sf;
	}

	@Override
	public List<Magazzino> caricaMagazzino() {
		
		List<Magazzino> magazzinoList=null;
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("select m from model.Magazzino as m left join fetch m.articolo"); //from model.Magazzino
	        magazzinoList=query.list();
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
		return magazzinoList;
	}

	@Override
	public void aggiungiArticolo(Articolo articolo, int pezzi) {
		
		Magazzino art=new Magazzino();
		art.setArticolo(articolo);
		art.setPezzi(pezzi);
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
			session.save(art);
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
	public void updateArticolo(int id, int add) {
		
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("from model.Magazzino where id= :id");
	        query.setInteger("id",id);
	        Magazzino magazzinoUpd=(Magazzino)query.uniqueResult();
	        magazzinoUpd.setPezzi( magazzinoUpd.getPezzi() + add);
	        session.save(magazzinoUpd);
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
	public void deleteFromMagazzino(int id) { //modificato, fa l'update e setta a -1
		
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("update model.Magazzino set pezzi= -1 where id=:id"); 
	        query.setInteger("id",id);
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

	@Override
	public List<Magazzino> caricaPerPaginaz(int counter, int quantità, boolean order, String orderTipo) {
		List<Magazzino> magazzinoList=null;
		Session session=null;
		Transaction tx=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
			Query query;
			if(order)
				query = session.createQuery("select m from model.Magazzino as m left join fetch m.articolo order by m.articolo."+orderTipo); //from model.Magazzino
			else
				query = session.createQuery("select m from model.Magazzino as m left join fetch m.articolo order by m.articolo."+orderTipo+" desc");
			
			query.setMaxResults(quantità);
	        query.setFirstResult((counter-1)*quantità);
	        magazzinoList=query.list();
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
		return magazzinoList;
	}

	@Override
	public int count() {
		Session session=null;
		Transaction tx=null;
		Long totale=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("select count(*) from model.Magazzino"); //from model.Magazzino
	        totale=(long)query.uniqueResult();
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
		System.out.println("numero totale articoli in magazz: " + totale);
		Integer intValue = totale.intValue();
		return intValue;
	}

	@Override
	public List<Magazzino> searchNome(int counter, int quantità, boolean order, String nome) {

		Session session=null;
		Transaction tx=null;
		List<Magazzino> list=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("select m from model.Magazzino as m left join fetch m.articolo where m.articolo.nome=:nome"); //from model.Magazzino
	        query.setString("nome", nome);
	        query.setMaxResults(quantità);
	        query.setFirstResult((counter-1)*quantità);
	        list=query.list();
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
		return list;
	}

	@Override
	public List<Magazzino> searchMarca(int counter, int quantità, boolean order,String marca) {
		
		Session session=null;
		Transaction tx=null;
		List<Magazzino> list=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("select m from model.Magazzino as m left join fetch m.articolo where m.articolo.marca=:marca"); //from model.Magazzino
	        query.setString("marca", marca);
	        query.setMaxResults(quantità);
	        query.setFirstResult((counter-1)*quantità);
	        list=query.list();
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
		return list;
	}
	
	@Override
	public List<Magazzino> searchCategoria(int counter, int quantità, boolean order,String tipo, String orderTipo) {
		Session session=null;
		Transaction tx=null;
		List<Magazzino> list=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
			Query query;
			if(order)
				query = session.createQuery("select m from model.Magazzino as m left join fetch m.articolo where m.articolo.tipo=:tipo order by m.articolo."+orderTipo);
			else
				query = session.createQuery("select m from model.Magazzino as m left join fetch m.articolo where m.articolo.tipo=:tipo order by m.articolo."+orderTipo+" desc");
	        query.setString("tipo", tipo);
	        query.setMaxResults(quantità);
	        query.setFirstResult((counter-1)*quantità);
	        list=query.list();
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
		return list;
	}

	@Override
	public int countCategoria(String categoria) {
		Session session=null;
		Transaction tx=null;
		Long totale=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("select count (*) from model.Articolo where tipo=:tipo"); //from model.Magazzino
	        query.setString("tipo", categoria);
	        totale=(long)query.uniqueResult();
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
		Integer intValue = totale.intValue();
		return intValue;
	}

	@Override
	public int countNome(String nome) {
		Session session=null;
		Transaction tx=null;
		Long totale=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("select count (*) from model.Articolo where nome=:nome"); //from model.Magazzino
	        query.setString("nome", nome);
	        totale=(long)query.uniqueResult();
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
		Integer intValue = totale.intValue();
		return intValue;
	}

	@Override
	public int countMarca(String marca) {
		Session session=null;
		Transaction tx=null;
		Long totale=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
	        Query query = session.createQuery("select count (*) from model.Articolo where marca=:marca"); //from model.Magazzino
	        query.setString("marca", marca);
	        totale=(long)query.uniqueResult();
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
		Integer intValue = totale.intValue();
		return intValue;
	}

	@Override
	public List<Magazzino> search(int counter, int quantità, boolean order,
			String searchString, String orderTipo) {
		Session session=null;
		Transaction tx=null;
		List<Magazzino> list=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
			Query query;
			if(order)
				query = session.createQuery("select m from model.Magazzino as m left join fetch m.articolo where m.articolo.nome=:nome or m.articolo.marca=:marca order by m.articolo."+orderTipo);
			else
				query = session.createQuery("select m from model.Magazzino as m left join fetch m.articolo where m.articolo.nome=:nome or m.articolo.marca=:marca order by m.articolo."+orderTipo+" desc");
	        query.setString("nome", searchString);
	        query.setString("marca", searchString);
	        query.setMaxResults(quantità);
	        query.setFirstResult((counter-1)*quantità);
	        list=query.list();
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
		return list;
	}

	@Override
	public int countSearch(String searchString) {
		Session session=null;
		Transaction tx=null;
		Long totale=null;
		try{	
			session = sf.openSession();
			tx=session.beginTransaction();
			Query query = session.createQuery("select count (*) from model.Articolo where nome=:nome or marca=:marca"); //from model.Magazzino
	        query.setString("nome", searchString);
	        query.setString("marca", searchString);
	        totale=(long)query.uniqueResult();
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
		Integer intValue = totale.intValue();
		return intValue;
	}

}

