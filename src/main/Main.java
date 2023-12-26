/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;
import dao.UserDao;
import user.UserFrame;

/**
 *
 * @author wdead
 */
// Mendefinisikan kelas Main
public class Main extends JFrame {
    private final UserDao userDao; // Mendeklarasikan variabel instance userDao
    private final UserFrame userFrame; // Mendeklarasikan variabel instance userFrame

    // Mendefinisikan konstruktor untuk kelas Main
    public Main() {
        this.setTitle("User"); //  Mengatur judul frame menjadi "User"
        this.setSize(400, 500); // Mengatur ukuran frame menjadi lebar 400 pixel dan tinggi 500 pixel
        this.userDao = new UserDao(); // Menginisialisasi variabel userDao
        this.userFrame = new UserFrame(userDao); // Menginisialisasi variabel userFrame
        this.userFrame.setVisible(true); // Menjadikan frame userFrame menjadi terlihat
    }

    // Metode main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
