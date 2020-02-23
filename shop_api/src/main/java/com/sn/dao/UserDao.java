package com.sn.dao;


import com.sn.entity.User;

public interface UserDao {

    //��¼
    public User login(String username, String password);

    //����û�
    public void insert(User use);

    //��ѯ�û��Ƿ����
    public Boolean queryByUsername(String username);

    //�޸�����
    public void updatePassword(String username, String oldpwd, String newpwd);

    //�޸ĸ�����Ϣ
    public void updateMessage(User use);

}
