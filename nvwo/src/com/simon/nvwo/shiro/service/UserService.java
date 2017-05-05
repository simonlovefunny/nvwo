package com.simon.nvwo.shiro.service;

import java.util.Set;

import com.simon.nvwo.shiro.entity.User;

public interface UserService {
	
    /**
     * �����û�
     * @param user
     */
    public User createUser(User user);
    
    /**
     * �����û�
     * @param user
     */   
    public void updateUser(User user);

    /**
     * �޸�����
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);

    /**
     * �����û�-��ɫ��ϵ
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(Long userId, Long... roleIds);


    /**
     * �Ƴ��û�-��ɫ��ϵ
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(Long userId, Long... roleIds);

    /**
     * �����û��������û�
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * �����û����������ɫ
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * �����û���������Ȩ��
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);
}