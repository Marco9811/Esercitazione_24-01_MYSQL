import java.sql.*;

public class Catalogo {
    final String DB_URL = "jdbc:mysql://localhost:3306/newdb";

    final String USER = "root";

    final String PASS = "Velletri98";

    public Catalogo() throws SQLException {
    }

    public void createCatalogoTable() throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        String catalogoQuery = ""
                + "CREATE TABLE newdb.catalogo ( "
                + "	codice_fornitore INT NOT NULL, "
                + "	codice_prodotto INT NOT NULL, "
                + "	costo INT NULL, "
                + "	CONSTRAINT catalogo_pk PRIMARY KEY (codice_fornitore,codice_prodotto), "
                + "	CONSTRAINT catalogo_FK FOREIGN KEY (codice_fornitore) REFERENCES newdb.fornitori(codice_fornitore), "
                + "	CONSTRAINT catalogo_FK_1 FOREIGN KEY (codice_prodotto) REFERENCES newdb.prodotti(codice_prodotto) "
                + ") ";

        statement.executeUpdate(catalogoQuery);
        connection.close();
    }
    public void insertValoriCatalogo() throws SQLException{
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();

        Integer fornitore_id = null;
        Integer prodotto_id = null;
        Integer costo =  null;

        String selectQuery = ""
                + "SELECT codice_fornitore, codice_prodotto, costo "
                + "FROM newdb.fornitori,newdb.prodotti;";

        statement.executeUpdate(selectQuery);


        ResultSet resultSet = statement.executeQuery(selectQuery);
        while (resultSet.next()){
            fornitore_id = resultSet.getInt("codice_fornitore");
            prodotto_id = resultSet.getInt("codice_prodotto");
            costo = resultSet.getInt("costo");
        }
        statement.executeUpdate("insert into newdb.catalogo (codice_fornitore, codice_prodotto, costo) " +
                "VALUES ('" + fornitore_id + "', '" + prodotto_id + "', '" + costo + "');");
        connection.close();
    }
    }

