import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Fornitori fornitori = new Fornitori();
        fornitori.createFornitoriTable();
        fornitori.insertTableFornitori("Ladroni ","Via Ostiense","Roma");
        fornitori.insertTableFornitori("Risparmietti ","Viale Marconi","Roma");
        fornitori.insertTableFornitori("Teleporto ","Via Roma","Milano");

        System.out.println("la tabella è stata creata");

        Prodotto prodotto = new Prodotto();
        prodotto.createProdottoTable();
        prodotto.insertProdottiIntoFornitori("Samsung","pc","xp12",1200);
        prodotto.insertProdottiIntoFornitori("apple","pc","mac ios",1500);
        prodotto.insertProdottiIntoFornitori("xiaomi","pc","12mm",1000);

        System.out.println("i prodotti sono aggiunti ai fornitori");

        Catalogo catalogo = new Catalogo();
        catalogo.createCatalogoTable();
        catalogo.insertValoriCatalogo();

        System.out.println("il catalogo contiene prodotti e fornitori");
    }
}
