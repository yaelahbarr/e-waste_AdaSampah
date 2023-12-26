/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author wdead
 */
public class User {
    // Variabel untuk menyimpan nilai id
    private String id;

    // Variabel untuk menyimpan nilai nama
    private String nama;

    // Variabel untuk menyimpan nilai email
    private String email;

    // Variabel untuk menyimpan nilai password
    private String password;
    
    // Metode untuk mengatur nilai id
    public void setId(String id) {
        this.id = id;
    }
    
    // Metode untuk mendapatkan nilai id
    public String getId() {
        return this.id;
    } 
    
    // Metode untuk mengatur nilai nama
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    // Metode untuk mendapatkan nilai nama
    public String getNama() {
        return this.nama;
    } 
    
    // Metode untuk mengatur nilai email
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Metode untuk mendapatkan nilai email
    public String getEmail() {
        return this.email;
    }
    
    // Metode untuk mengatur nilai password
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Metode untuk mendapatkan nilai password
    public String getPassword() {
        return this.password;
    }
    
}
