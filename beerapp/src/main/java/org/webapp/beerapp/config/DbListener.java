package org.webapp.beerapp.config;

import org.h2.Driver;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.Server;
import org.h2.util.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener
public class DbListener implements ServletContextListener {

    private static DbListener instance;
    private static final String CONNECTION = "connection";
    private static final String DATA_SOURCE = "datasource";
    private JdbcConnectionPool pool;
    private Connection conn; // backward compatibility
    private Server server;
    private String url;
    private String user;
    private String password;
    private String serverParams;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SERVLET INITIALIZED");
        instance = this;
        Driver.load();
        ServletContext sc = ctx(sce);
        loadParams(sc);
        startTheServerIfConfiguredToDoSo(sc);
        setUpConnectionPool(sc);
        setUpConnection(sc);
    }

    private void loadParams(ServletContext sc) {
            url = param(sc,"db.url","jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;");
            user = param(sc,"db.user","sa");
            password = param(sc,"db.password","password");
            serverParams = param(sc,"db.tcpServer",null);
    }

    private ServletContext ctx(ServletContextEvent sce) {
        return sce.getServletContext();
    }

    private String param(ServletContext ctx, String key, String defaultValue) {
        String initParameter = ctx.getInitParameter(key);
        return initParameter == null ? defaultValue : initParameter;
    }

    protected void startTheServerIfConfiguredToDoSo(ServletContext ctx) {
        if (serverParams != null) {
            String[] params = StringUtils.arraySplit(serverParams, ' ', true);
            try {
                server = Server.createTcpServer(params);
                server.start();
            } catch (SQLException e) {
                ctx.log("Error during H2 server startup", e);
            }
        }
    }

    protected void setUpConnectionPool(ServletContext ctx) {
        pool = JdbcConnectionPool.create(url,user, password);
        ctx.setAttribute(DATA_SOURCE, pool);
    }

    // backward compatibility
    protected void setUpConnection(ServletContext ctx) {
        try {

            URL resource = this.getClass().getClassLoader().getResource("db/schema.sql");
            BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line =reader.readLine()) != null) {
                builder.append(line);
            }
            String query = builder.toString();
            System.out.println("Query:");
            System.out.println(query);
            conn = pool.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.execute();
            ctx.setAttribute(CONNECTION, conn);
        } catch (SQLException e) {
            ctx.log("Error obtaining the H2 SQL connection", e);
        } catch (FileNotFoundException e) {
            ctx.log("Cannot find file", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = ctx(sce);
        closeAllOpenConnections(ctx);
        closeConnection(ctx);
        disposeConnectionPool(ctx);
        stopServer();
        instance = null;
    }

    protected void closeAllOpenConnections(ServletContext ctx) {
        try {
            Connection conn = pool.getConnection();
            try {
                Statement stat = conn.createStatement();
                try {
                    stat.execute("SHUTDOWN");
                } finally {
                    stat.close();
                }
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            ctx.log("Error during H2 Shutdown", ex);
        }
    }

    // backward compatibility
    protected void closeConnection(ServletContext ctx) {
        try {
            conn.close();
            ctx.removeAttribute(CONNECTION);
            conn = null;
        } catch (SQLException e) {
            ctx.log("Error closing the H2 SQL Connection", e);
        }
    }

    protected void disposeConnectionPool(ServletContext ctx) {
        pool.dispose();
        ctx.removeAttribute(DATA_SOURCE);
        pool = null;
    }

    protected void stopServer() {
        if (server != null) {
            server.stop();
            server = null;
        }
    }

    public static JdbcConnectionPool getConnectionPool() {
        return instance.pool;
    }

    public static DataSource getDataSource() {
        return instance.pool;
    }

    /**
     * This method should be compatible with previous version, but beware:
     * now you need to close the connections after using them!
     */
    public static Connection getConnection() throws SQLException {
        // alternatively this method may just return 'conn' field,
        // and made non-static + deprecated, to discourage the use.
        return instance.pool.getConnection();
    }

    public static Server getServer() {
        return instance.server;
    }




}
