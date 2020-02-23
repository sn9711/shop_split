package com.sn.service.impl;

import com.sn.dao.ProductDao;
import com.sn.dao.ProductDaoImpl;
import com.sn.entity.Product;
import com.sn.service.ProductService;
import com.sn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class ProductServiceImpl implements ProductService {
    private static ProductDao pdao = new ProductDaoImpl();

    @Override
    public void insert(Product pro) {//�����Ʒ
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            pdao.insert(pro);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("�����Ʒʧ��~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void deleteById(Integer id) {//ɾ����Ʒ
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            pdao.deleteById(id);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("ɾ����Ʒʧ��~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void update(Product pro) {//�޸���Ʒ
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            pdao.update(pro);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("�޸���Ʒʧ��~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public Integer queryAllPage() {//��ʾ������Ʒ
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<Product> lps = pdao.queryAll();
            conn.commit();
            Integer pages = null;
            if (lps.size() % 2 > 0) {
                pages = lps.size() / 2 + 1;
            } else {
                pages = lps.size() / 2;
            }
            return pages;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ѯ������Ʒʧ��~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryBypage(Integer page) {//��ҳ��ѯ
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<Product> ls = pdao.queryBypage(page);
            conn.commit();
            return ls;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ҳʧ��~~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public Product queryByid(Integer id) {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            Product pro = pdao.queryByid(id);
            conn.commit();
            return pro;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ѯ������Ʒʧ��~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryByname(String name) {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<Product> ls = pdao.queryByname(name);
            conn.commit();
            return ls;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ҳʧ��~~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryByname1(String name, Double price) {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<Product> ls = pdao.queryByname1(name, price);
            conn.commit();
            return ls;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ҳʧ��~~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryByname2(String name, Double price) {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<Product> ls = pdao.queryByname2(name, price);
            conn.commit();
            return ls;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ҳʧ��~~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryBynameAndpage(String name, Integer page) {//���ֲ�ѯ��ҳ
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<Product> ls = pdao.queryBynameAndpage(name, page);
            conn.commit();
            return ls;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ҳʧ��~~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryByname1Andpage(String name, Double price,
                                             Integer page) {//����С�ڲ�ѯ��ҳ
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<Product> ls = pdao.queryByname1Andpage(name, price, page);
            conn.commit();
            return ls;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ҳʧ��~~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryByname2Andpage(String name, Double price,
                                             Integer page) {//���ִ��ڷ�ҳ
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<Product> ls = pdao.queryByname2Andpage(name, price, page);
            conn.commit();
            return ls;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("��ҳʧ��~~~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

}
