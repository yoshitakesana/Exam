package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * データベース接続を行う共通DAOクラス。
 * 他のDAOクラスはこのクラスを継承してDB接続機能を利用します。
 */
public class Dao {

    // データソースを1度だけ取得して再利用する
    static DataSource ds;

    /**
     * データベース接続を取得するメソッド。
     * @return Connection データベース接続オブジェクト
     * @throws Exception 接続に失敗した場合に例外がスローされます
     */
    public Connection getConnection() throws Exception {
        // データソースが未取得の場合はJNDIから取得する（初回のみ）
        if (ds == null) {
            InitialContext ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/test2"); // 環境に応じたJNDI名を使用
        }

        // データソースから接続を取得して返す
        return ds.getConnection();
    }
}
