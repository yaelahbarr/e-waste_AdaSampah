/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import user.User;

/**
 *
 * @author wdead
 */
public class UserDao {
    // Metode untuk menyimpan user ke dalam database
    public int insert(User user) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk melakukan operasi INSERT ke database
            PreparedStatement statement = connection.prepareStatement(
                    "Insert into user(id, nama, no_telepon, jenis_kelamin, alamat) values (?, ?, ?, ?, ?)");

            // Mengatur nilai parameter pada query
            statement.setString(1, user.getId());
            statement.setString(2, user.getNama());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());

            // Eksekusi query INSERT dan mendapatkan jumlah baris yang terpengaruh
            result = statement.executeUpdate();
            
            // Menampilkan informasi data yang berhasil di-insert
            System.out.println("Insert data: " + user.getId() + " " + user.getNama() + " "
                    + user.getEmail() + " " + user.getPassword());
        } catch (SQLException e) {
            // Menangani exception dengan mencetak stack trace
            e.printStackTrace();
        }
        // Mengembalikan hasil eksekusi query
        return result;
    }

    // Metode untuk mengupdate user dalam database
    public int update(User user) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk melakukan operasi UPDATE ke database
            PreparedStatement statement = connection.prepareStatement(
                    "update user set nama = ?, no_telepon = ?, jenis_kelamin = ?, alamat = ? where id = ?");

            // Mengatur nilai parameter pada query
            statement.setString(1, user.getNama());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(5, user.getId());

            // Eksekusi query UPDATE dan mendapatkan jumlah baris yang terpengaruh
            result = statement.executeUpdate();
            
            // Menampilkan informasi data yang berhasil di-update
            System.out.println("Update data: " + user.getId() + " " + user.getNama() + " "
                    + user.getEmail() + " " + user.getPassword());
        } catch (SQLException e) {
            // Menangani exception dengan mencetak stack trace
            e.printStackTrace();
        }
        // Mengembalikan hasil eksekusi query
        return result;
    }

    // Metode untuk menghapus user dari database
    public int delete(User user) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk melakukan operasi DELETE ke database
            PreparedStatement statement = connection.prepareStatement("delete from user where id = ?");

            // Mengatur nilai parameter pada query
            statement.setString(1, user.getId());

            // Eksekusi query DELETE dan mendapatkan jumlah baris yang terpengaruh
            result = statement.executeUpdate();
            
            // Menampilkan informasi data yang berhasil dihapus
            System.out.println("Delete data: " + user.getId() + " " + user.getNama() + " "
                    + user.getEmail() + " " + user.getPassword());
        } catch (SQLException e) {
            // Menangani exception dengan mencetak stack trace
            e.printStackTrace();
        }
        // Mengembalikan hasil eksekusi query
        return result;
    }

    // Metode untuk mendapatkan semua user dari database
    public List<User> findAll() {
        // Membuat list untuk menyimpan hasil query
        List<User> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            // Membuat ResultSet untuk menyimpan hasil dari query SELECT
            try (ResultSet resultSet = statement.executeQuery("select * from user")) {
                // Looping untuk membaca hasil query dan menyimpannya ke dalam list
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getString("id"));
                    user.setNama(resultSet.getString("nama"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    list.add(user);
                }
            } catch (SQLException e) {
                // Menangani exception dengan mencetak stack trace
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Menangani exception dengan mencetak stack trace
            e.printStackTrace();
        }
        // Mengembalikan list user
        return list;
    }

    // Metode untuk mendapatkan user dari database berdasarkan kolom dan nilai
    public User select(String column, String value) {
        // Membuat object user untuk menyimpan hasil query
        User user = new User();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            // Membuat ResultSet untuk menyimpan hasil dari query SELECT
            try (ResultSet resultSet = statement.executeQuery("select * from user where " + column+ " = '" + value + "'");) {
                // Looping untuk membaca hasil query dan menyimpannya ke dalam object user
                while (resultSet.next()) {
                    user.setId(resultSet.getString("id"));
                    user.setNama(resultSet.getString("nama"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                }
            } catch (SQLException e) {
                // Menangani exception dengan mencetak stack trace
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Menangani exception dengan mencetak stack trace
            e.printStackTrace();
        }
        // Mengembalikan object user
        return user;
    }
}
