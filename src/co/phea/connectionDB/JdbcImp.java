package co.phea.connectionDB;

import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;

public class JdbcImp {
    // connection database
    public DataSource dataSource(){
        PGSimpleDataSource simple = new PGSimpleDataSource();
        simple.setUser("postgres");
        simple.setPassword("12345");
        simple.setDatabaseName("postgres");
        return simple;
    }
}
