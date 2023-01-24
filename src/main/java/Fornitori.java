import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Fornitori {

    final String DB_URL = "jdbc:mysql://localhost:3306/newdb";

    final String USER = "root";

    final String PASS = "Velletri98";

    public Fornitori() throws SQLException {
    }
/*
creare tabella fornitori dove aggiungo le varie colonne
prendo la query su db e la formatto a java
id not null - auto incrementale
 */
    public void createFornitoriTable() throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        String createTableFornitori = ""
                + "CREATE TABLE newdb.fornitori ( "
                + "	codice_fornitore INT auto_increment NOT NULL, "
                + "	nome varchar(100) NULL, "
                + "	indirizzo varchar(100) NULL, "
                + "	citta varchar(100) NULL, "
                + "	CONSTRAINT fornitori_pk PRIMARY KEY (codice_fornitore) "
                + ") ";

        statement.executeUpdate(createTableFornitori);
        connection.close();
    }
    /*
    inserico i fornitori all'interno della tabella
    con il comando select sulla tabella genero tramite SQL l'insert
     */
    public void insertTableFornitori(String nome,String indirizzo,String citta) throws SQLException{
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();

        String insertQuery = ""
        + "insert into newdb.fornitori (nome, indirizzo, citta) " +
                "VALUES ('" + nome + "', '" + indirizzo + "', '" + citta + "');";

        statement.executeUpdate(insertQuery);
        connection.close();
    }
}

