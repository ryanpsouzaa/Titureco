package entitites;
import java.util.ArrayList;
import java.util.List;

public class TiturecoList implements TiturecoInterface{
    private List<AtrativoTuristico> atrativos = new ArrayList<>();


    @Override
    public boolean cadastrarAtrativo(AtrativoTuristico atrativo) {
        this.atrativos.add(atrativo);
        return true;
    }

    @Override
    public boolean apagarAtrativo(String nomeAtrativo, String cidade, String estado) {
        for (AtrativoTuristico a : this.atrativos){
            if(a.getNome().equals(nomeAtrativo) && a.getCidade().equals(cidade) && a.getEstado().equals(estado)){
                this.atrativos.remove(a);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<AtrativoTuristico> getAtrativos() {
        List<AtrativoTuristico> listaAtrativos = new ArrayList<>();
        for (AtrativoTuristico a : this.atrativos){
            listaAtrativos.add(a);
        }
        return listaAtrativos;
    }

    @Override
    public List<AtrativoTuristico> pesquisaAtrativosDaCidade(String cidade, String estado) {
        List<AtrativoTuristico> listaAtrativosCidade = new ArrayList<>();
        for (AtrativoTuristico a: this.atrativos){
            if(a.getCidade().equalsIgnoreCase(cidade) && a.getEstado().equalsIgnoreCase(estado)){
                listaAtrativosCidade.add(a);
            }
        }
        return listaAtrativosCidade;
    }
}
