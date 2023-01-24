import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prodotto {
    final String DB_URL = "jdbc:mysql://localhost:3306/newdb";

    final String USER = "root";

    final String PASS = "Velletri98";

    public Prodotto() throws SQLException {
    }

    public void createProdottoTable() throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        String createTableProdotti = ""
                + "CREATE TABLE newdb.prodotti ( "
                + "	Marca varchar(100) NULL, "
                + "	Tipo varchar(100) NULL, "
                + "	Modello varchar(100) NULL, "
                + "	Costo INT NULL, "
                + "	codice_prodotto INT auto_increment NOT NULL, "
                + "	CONSTRAINT prodotti_pk PRIMARY KEY (codice_prodotto) "
                + ")";

        statement.executeUpdate(createTableProdotti);
        connection.close();
    }
    public void insertProdottiIntoFornitori(String marca,String tipo,String modello,int costo) throws  SQLException{
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();

        String insertQuery = ""
                + "insert into newdb.prodotti (marca, tipo,modello,costo) " +
                "VALUES ('" + marca + "', '" + tipo + "', '" + modello + "','" + costo + "');";

        statement.executeUpdate(insertQuery);
        connection.close();
    }
}
