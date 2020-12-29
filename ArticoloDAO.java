package Action;

import java.util.List;

import model.Articolo;

public interface ArticoloDAO {
	void addArticolo(Articolo articolo);
	Articolo getArticoloFromId(int id);
	void modifyArticolo(Articolo articolo);
}
