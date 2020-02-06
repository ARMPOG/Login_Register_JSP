package dao;


import db.DBConnectionProvider;
import model.User;

import java.sql.*;


public class UserDao {

    private static volatile UserDao instance = new UserDao();
    private Connection connection;

    private UserDao() {
    }

    public synchronized static UserDao getInstance() {
        return instance;
    }

    public User save(User user){
        connection = DBConnectionProvider.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO User (name,surname,password,email)" +
                                                                  " VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getName());
            statement.setString(2,user.getSurname());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getEmail());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                int id= resultSet.getInt(1);
                user.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getByEmailAndPassword(String email, String password){
        connection =DBConnectionProvider.getInstance().getConnection();
        User result = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User" +
                                                                     " WHERE email=? AND password=?");
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                result=(User.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .password(resultSet.getString("password"))
                .email(resultSet.getString("email"))
                .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }
}



