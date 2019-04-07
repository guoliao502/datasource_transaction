package studio.guoliao;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * User: guoliao
 * Date: 2019/4/7
 * Time: 下午6:13
 * Description:
 */
public class CustomDataSource implements DataSource {

    private Collection<DataSource> sources;

    public CustomDataSource(Collection<DataSource> sources) {
        this.sources = sources;
        check();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    private void check() {
        if(sources == null){
            throw new NullPointerException();
        }
        if(sources.isEmpty()){
            throw new IllegalArgumentException();
        }
        sources.forEach(item->{
            if(item == null){
                throw new NullPointerException();
            }
        });
    }
}
