package com.sn.dao;

import com.sn.entity.Product;
import com.sn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements ProductDao {

    @Override
    public void insert(Product pro) {//�����Ʒ
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into shop_product values(shop_product_seq.nextval,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pro.getProductName());
            pstm.setDouble(2, pro.getPrice());
            pstm.setString(3, pro.getPicpath());
            pstm.setString(4, pro.getDiscription());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("�����Ʒʧ��~~~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

    @Override
    public void deleteById(Integer id) {//ɾ����Ʒ
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete from shop_product where id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ɾ����Ʒʧ��~~~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

    @Override
    public void update(Product pro) {//�޸���Ʒ
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update shop_product set productName=?,price=?,picpath=?,discription=?,"
                    + "where id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pro.getProductName());
            pstm.setDouble(2, pro.getPrice());
            pstm.setString(3, pro.getPicpath());
            pstm.setString(4, pro.getDiscription());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("�޸���Ʒʧ��~~~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

    @Override
    public List<Product> queryAll() {//��ʾ������Ʒ
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> lps = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id,productName,price,picpath,discription"
                    + " from shop_product";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            Product pro = null;
            while (rs.next()) {
                pro = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lps.add(pro);
            }
            return lps;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("��ѯ������Ʒʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryBypage(Integer page) {//��ҳ��ѯ
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> lps = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id,productName,price,picpath,discription"
                    + " from (select t1.id,t1.productName,t1.price,t1.picpath,"
                    + "t1.discription,rownum rn "
                    + "from shop_product t1) where rn >=? and rn<=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, page * 2 - 1);
            pstm.setInt(2, page * 2);
            rs = pstm.executeQuery();
            Product pro = null;
            while (rs.next()) {
                pro = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lps.add(pro);
            }
            return lps;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("��ҳ��ѯʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public Product queryByid(Integer id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id,productName,price,picpath,discription"
                    + " from shop_product where id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Product pro = null;
            while (rs.next()) {
                pro = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
            return pro;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("��ѯ��Ʒʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryByname(String name) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> lps = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id,productName,price,picpath,discription"
                    + " from shop_product where productname like '%'||?||'%'";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            rs = pstm.executeQuery();
            Product pro = null;
            while (rs.next()) {
                pro = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lps.add(pro);
            }
            return lps;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("��������ģ����ѯʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryByname1(String name, Double price) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> lps = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id,productName,price,picpath,discription"
                    + " from shop_product where productname like '%'||?||'%' and price<?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setDouble(2, price);
            rs = pstm.executeQuery();
            Product pro = null;
            while (rs.next()) {
                pro = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lps.add(pro);
            }
            return lps;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("��������С�ڲ�ѯʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryByname2(String name, Double price) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> lps = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id,productName,price,picpath,discription"
                    + " from shop_product where productname like '%'||?||'%' and price>?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setDouble(2, price);
            rs = pstm.executeQuery();
            Product pro = null;
            while (rs.next()) {
                pro = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lps.add(pro);
            }
            return lps;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("�������ִ��ڲ�ѯʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryBynameAndpage(String name, Integer page) {//���ֲ�ѯ��ҳ
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> lps = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id,productName,price,picpath,discription"
                    + " from (select t1.id,t1.productName,t1.price,t1.picpath,"
                    + "t1.discription,rownum rn from shop_product t1 where productname like '%'||?||'%')"
                    + " where rn >=? and rn<=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setInt(2, page * 2 - 1);
            pstm.setInt(3, page * 2);
            rs = pstm.executeQuery();
            Product pro = null;
            while (rs.next()) {
                pro = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lps.add(pro);
            }
            return lps;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("������ҳ��ѯʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryByname1Andpage(String name, Double price,
                                             Integer page) {//����С�ڲ�ѯ��ҳ
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> lps = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id,productName,price,picpath,discription"
                    + " from (select t1.id,t1.productName,t1.price,t1.picpath,"
                    + "t1.discription,rownum rn from shop_product t1 where productName like '%'||?||'%' and price<?)"
                    + " where rn >=? and rn<=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setDouble(2, price);
            pstm.setInt(3, page * 2 - 1);
            pstm.setInt(4, page * 2);
            rs = pstm.executeQuery();
            Product pro = null;
            while (rs.next()) {
                pro = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lps.add(pro);
            }
            return lps;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("����С�ڷ�ҳ��ѯʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryByname2Andpage(String name, Double price,
                                             Integer page) {//���ִ��ڷ�ҳ
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> lps = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select id,productName,price,picpath,discription"
                    + " from (select t1.id,t1.productName,t1.price,t1.picpath,"
                    + "t1.discription,rownum rn from shop_product t1 where productname like '%'||?||'%' and price>?)"
                    + " where rn >=? and rn<=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setDouble(2, price);
            pstm.setInt(3, page * 2 - 1);
            pstm.setInt(4, page * 2);
            rs = pstm.executeQuery();
            Product pro = null;
            while (rs.next()) {
                pro = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                lps.add(pro);
            }
            return lps;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("�������ڷ�ҳ��ѯʧ��~~~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }


}
