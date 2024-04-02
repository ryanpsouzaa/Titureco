package entitites;

public class Praia extends AtrativoTuristico{
    private boolean propriaParaBanho;
    private boolean perigoTubarao;
    private String tipoOrla;

    public static final String TIPO_PISCINAS_NATURAIS = "Piscinas Naturais";
    public static final String TIPO_ONDAS_FORTES = "Ondas Fortes";
    public static final String TIPO_ONDAS_MEDIAS = "Ondas Médias";

    public Praia(String nome, double latitude, double longitude, String comoChegar, String cidade, String estado, boolean propriaParaBanho, boolean perigoTubarao, String tipoOrla) {
        super(nome, latitude, longitude, comoChegar, cidade, estado);
        this.propriaParaBanho = propriaParaBanho;
        this.perigoTubarao = perigoTubarao;
        this.tipoOrla = tipoOrla;
    }
    public Praia(){
        this("",0.0,0.0,"","","",false,false,"");
    }

    public boolean ehPropriaParaBanho() {
        return propriaParaBanho;
    }

    public void setPropriaParaBanho(boolean propriaParaBanho) {
        this.propriaParaBanho = propriaParaBanho;
    }

    public boolean ehPerigoTubarao() {
        return perigoTubarao;
    }

    public void setPerigoTubarao(boolean perigoTubarao) {
        this.perigoTubarao = perigoTubarao;
    }

    public String getTipoOrla() {
        return tipoOrla;
    }

    public void setTipoOrla(String tipoOrla) {
        this.tipoOrla = tipoOrla;
    }
    @Override
    public String toString(){
        String perigoTubarao;
        String propriaParaBanho;
        if(ehPerigoTubarao()){
            perigoTubarao = ", possui perigo com tubarões";
        }else{
            perigoTubarao = ", não possui perigo com tubarões";
        }
        if(ehPropriaParaBanho()){
            propriaParaBanho = ", é apropriada para banho";
        }else{
            propriaParaBanho = ", não é apropriada para banho";
        }
        return "Nome: " + getNome() + ", latitude: " + getLatitude() + ", longitude: " + getLongitude() + ", referências: " + getComoChegar() + ", cidade: " + getCidade() + ", estado: " + getEstado()
                + perigoTubarao + propriaParaBanho + ", " + getTipoOrla();

    }
}
