package com.sn.service;

import com.sn.entity.Product;

import java.util.List;


public interface ProductService {
    //����id��ѯ��Ʒ
    public Product queryByid(Integer id);

    //�����Ʒ
    public void insert(Product pro);

    //ɾ����Ʒ
    public void deleteById(Integer id);

    //�޸���Ʒ
    public void update(Product pro);

    //��ʾ������Ʒ
    public Integer queryAllPage();

    //��ҳ��ѯ
    public List<Product> queryBypage(Integer page);

    //���ֲ�ѯ
    public List<Product> queryByname(String name);

    //���ֲ�ѯ��ҳ
    public List<Product> queryBynameAndpage(String name, Integer page);

    //����С��
    public List<Product> queryByname1(String name, Double price);

    //����С�ڲ�ѯ��ҳ
    public List<Product> queryByname1Andpage(String name, Double price, Integer page);

    //���ִ���
    public List<Product> queryByname2(String name, Double price);

    //���ִ��ڷ�ҳ
    public List<Product> queryByname2Andpage(String name, Double price, Integer page);

}
