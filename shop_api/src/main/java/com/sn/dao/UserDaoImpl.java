package com.sn.dao;

import com.sn.entity.User;
import com.sn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDaoImpl implements UserDao {

    @Override
    public User login(String username, String password) {//��¼
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select username,password,name,zip,address from shop_user"
                    + " where username=? and password=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            User use = null;
            while (rs.next()) {
                use = new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)
                );
            }
            return use;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("��¼ʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public void insert(User use) {//����û�
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into shop_user values(?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, use.getUsername());
            pstm.setString(2, use.getPassword());
            pstm.setString(3, use.getName());
            pstm.setInt(4, use.getZip());
            pstm.setString(5, use.getAddress());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("����û�ʧ��~~~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

    @Override
    public Boolean queryByUsername(String username) {//��ѯ�û��Ƿ����
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select username from shop_user"
                    + " where username=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("��¼ʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public void updatePassword(String username, String oldpwd, String newpwd) {//�޸�����
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update shop_user set password=? where username=? and password=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, newpwd);
            pstm.setString(2, username);
            pstm.setString(3, oldpwd);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("������ϵ��ʧ��~~~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

    @Override
    public void updateMessage(User use) {//�޸ĸ�����Ϣ
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update shop_user set name=?,zip=?,address=? where username=? and password=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, use.getName());
            pstm.setInt(2, use.getZip());
            pstm.setString(3, use.getAddress());
            pstm.setString(4, use.getUsername());
            pstm.setString(5, use.getPassword());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("������ϵ��ʧ��~~~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

}
