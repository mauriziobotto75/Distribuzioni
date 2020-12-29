package dao;

import java.util.List;

import model.Articolo;
import model.Magazzino;

public interface MagazzinoDAO {
	List<Magazzino> caricaMagazzino();
	List<Magazzino> caricaPerPaginaz(int counter, int quantità, boolean order, String orderTipo);
	int count();
	void aggiungiArticolo(Articolo articolo, int pezzi);
	void updateArticolo(int id, int add);
	void deleteFromMagazzino(int id); //modificato, non elimina ma fa update pezzi -1
	List<Magazzino> searchNome(int counter, int quantità, boolean order,String nome);
	List<Magazzino> searchMarca(int counter, int quantità, boolean order,String marca);
	List<Magazzino> searchCategoria(int counter, int quantità, boolean order,String marca, String orderTipo);
	List<Magazzino> search(int counter, int quantità, boolean order,String searchString, String orderTipo);
	int countSearch(String searchString);
	int countCategoria(String categoria);
	int countNome(String nome);
	int countMarca(String marca);
}
