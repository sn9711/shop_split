package com.sn.service.impl;

import com.sn.dao.UserDao;
import com.sn.dao.UserDaoImpl;
import com.sn.entity.User;
import com.sn.service.UserService;
import com.sn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;


public class UserServiceImpl implements UserService {
    private static UserDao udao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {//��¼
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            User use = udao.login(username, password);
            conn.commit();
            return use;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��½ʧ��~~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void insert(User use) {//����û�
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            udao.insert(use);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("ע���û�ʧ��~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public Boolean queryByUsername(String username) {//��ѯ�û��Ƿ����
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            Boolean bool = udao.queryByUsername(username);
            conn.commit();
            return bool;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ѯ�û�ʧ��~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void updatePassword(String username, String oldpwd, String newpwd) {//�޸�����
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            udao.updatePassword(username, oldpwd, newpwd);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("ע�޸�����ʧ��~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void updateMessage(User use) {//�޸ĸ�����Ϣ
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            udao.updateMessage(use);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("�޸ĸ�����Ϣʧ��~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

}
