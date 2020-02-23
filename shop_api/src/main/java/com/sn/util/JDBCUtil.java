package com.sn.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtil {
    private static Properties prop = new Properties();
    // ����һ��ThreadLocal���󣬰�connection����ǰ�߳�
    private static ThreadLocal<Connection> tol = new ThreadLocal<Connection>();

    // ��̬��ʼ����飬����ִ��ֻ��Ҫһ�εĲ���
    static {
        InputStream in = null;
        try {
            //ʹ��IO����ȡ�����ļ���Ϣ : ����Ϊ�����ļ���λ�ã� / б�ܴ������Ŀ��Ŀ¼��ʼ
            in = JDBCUtil.class.getResourceAsStream("/jdbc.properties");
            //ʹ��Properties����������е���Ϣ
            prop.load(in);
            // ��������
            Class.forName(prop.getProperty("driverClassName"));


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("��ȡ�����ļ�ʧ�ܣ�~");
        } finally {
            // �ر���
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // ��������
    public static Connection getConnection() {
        // �ӵ�ǰ�߳��Ȼ�ȡһ��conn
        Connection conn = tol.get();
        try {
            if (conn == null) {// ˵���ǵ�һ�ε��ù����ഴ�����ӣ���û����ǰ�̰߳�
                // ��������
                conn = DriverManager.getConnection(prop.getProperty("url")
                        , prop.getProperty("username"), prop.getProperty("password"));
                // �󶨵���ǰ�߳�
                tol.set(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // �ͷ���Դ
    public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
                // �ӵ�ǰ�߳��Ƴ�
                tol.remove();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // �ͷ���Դ
    public static void close(PreparedStatement pstm, Connection conn) {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
                tol.remove();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // �ͷ���Դ
    public static void close(Connection conn) {
        try {

            if (conn != null) {
                conn.close();
                tol.remove();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
