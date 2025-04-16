package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * データベース接続を行う共通DAOクラス。
 * 他のDAOクラスはこのクラスを継承して DB接続機能を使います。
 */
public class DAO {
    // データソースを1回だけ取得して使い回す（シングルトンっぽい使い方）
    private static DataSource ds;

    /**
     * データベース接続を取得するメソッド。
     * @return Connection データベース接続オブジェクト
     * @throws Exception 接続に失敗した場合に例外がスローされます
     */
    protected Connection getConnection() throws Exception {
        // 初回だけJNDIからDataSourceを取得（環境に応じて"jdbc/book"は変更）
        if (ds == null) {
            InitialContext ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
        }

        // データソースから接続を取得して返す
        return ds.getConnection();
    }
}
