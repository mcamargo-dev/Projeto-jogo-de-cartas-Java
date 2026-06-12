package Repository;

import Model.CatalogoCartas;

import java.util.ArrayList;
import java.util.List;


public class CatalogoRepository {

    private List<CatalogoCartas> catalogos;

    public CatalogoRepository(){

        this.catalogos = new ArrayList<>();

    }
    public void salvar(CatalogoCartas catalogo){

        catalogos.add(catalogo);

    }

    public void atualizar(CatalogoCartas catalogoAtualizado){

        for (int i = 0; i < catalogos.size(); i++) {

            if (catalogos.get(i).getId() == catalogoAtualizado.getId()){

                catalogos.set(i, catalogoAtualizado);
                return;

            }
            
        }

    }

    public void excluir(int id) {

        catalogos.removeIf(catalogo -> catalogo.getId() == id);

    }

    public CatalogoCartas buscarPorId(int id) {

        for (CatalogoCartas catalogo : catalogos) {

            if (catalogo.getId() == id) {

                return catalogo;
            }
        }

        return null;
    }

    public List<CatalogoCartas> listarTodos(){

        return catalogos;
    }
}
