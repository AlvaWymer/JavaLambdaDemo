package com.amazonaws.lambda.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amazonaws.lambda.dto.RegisterInfo;
import com.amazonaws.lambda.exception.RegisterException;
import com.amazonaws.services.lambda.runtime.Context;

public class RegisterServiceImpl implements IRegisterService{
    /**
     * RDS数据库配置信息
     */
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private String url = null;
    private String username = null;
    private String password = null;
    private final String INSERT_SQL = "insert into user_info (user_name,password,email) value (?,?,?)";

    public void register(RegisterInfo info, Context context) throws RegisterException {
        url = System.getenv("DB_URL");      //数据库配置从环境变量获取
        username = System.getenv("USERNAME");
        password = System.getenv("PASSWORD");
//    	 url = "jdbc:mysql://mysql.c6xp4yqqen9s.eu-west-1.rds.amazonaws.com:3306/awsDemo";
//       username = "root";
//       password = "12345678";
        if(url == null || username == null || password == null) {
            throw new RegisterException(RegisterException.REGISTER_SYS_ERROR_CODE, "db config is null.");
        }
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RegisterException(RegisterException.REGISTER_SYS_ERROR_CODE,"mysql driver not found.");
        }
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,username,password);
            PreparedStatement statement = conn.prepareStatement(INSERT_SQL);
            statement.setString(1, info.getUsername());
            statement.setString(2, info.getPassword());
            statement.setString(3, info.getEmail());
            int count = statement.executeUpdate();
            conn.close();
            if(count != 1) {
                throw new RegisterException(RegisterException.REGISTER_DB_ERROR_CODE,"insert record failed.");
            }
        }catch(SQLException e) {
            throw new RegisterException(RegisterException.REGISTER_DB_ERROR_CODE,e.getMessage());
        }
    }
}