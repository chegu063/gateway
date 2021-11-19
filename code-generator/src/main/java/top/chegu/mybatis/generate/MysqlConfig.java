package top.chegu.mybatis.generate;

/**
 * @author chegu
 * @date 2021/4/15  12:14
 */
public class MysqlConfig {

    /**
     * mysql配置 url:port/db
     */
    private String database = "192.168.145.143:3306/gu_gate";
    private String user = "root";
    private String password = "root123";
    /**
     * 表
     */
    private String[] tables;
    /**
     * 表前缀
     */
    private String tablePrefix = "";

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String[] getTables() {
        return tables;
    }

    public void setTables(String[] tables) {
        this.tables = tables;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }
}
