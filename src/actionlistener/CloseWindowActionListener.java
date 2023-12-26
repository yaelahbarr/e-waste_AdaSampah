/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionlistener;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import user.UserFrame;

/**
 *
 * @author wdead
 */
// Mendefinisikan kelas CloseWindowActionListener yang mengimplementasikan WindowListener
public class CloseWindowActionListener implements WindowListener {
    // Membuat variabel instance UserFrame untuk menyimpan referensi ke frame utama
    private final UserFrame userFrame;

    // Konstruktor kelas dengan parameter UserFrame
    public CloseWindowActionListener(UserFrame userFrame) {
        // Menginisialisasi variabel instance userFrame dengan nilai dari parameter konstruktor
        this.userFrame = userFrame;
    }

    // Override method windowClosing dari interface WindowListener
    public void windowClosing(WindowEvent e) {
        // Menampilkan dialog konfirmasi ketika pengguna menutup frame
        int confirmation = JOptionPane.showConfirmDialog(this.userFrame,
                "Apakah anda yakin ingin keluar aplikasi?\nSemua data yang belum disimpan, tidak akan tersimpan.",
                "Form User",
                JOptionPane.YES_NO_OPTION);

        // Jika pengguna memilih opsi "Yes" dalam dialog konfirmasi
        if (confirmation == JOptionPane.YES_OPTION) {
            // Keluar dari aplikasi
            System.exit(0);
        } else {
            // Jika batal keluar, atur tindakan penutupan frame menjadi DO_NOTHING_ON_CLOSE
            this.userFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    // Override method windowOpened dari interface WindowListener
    public void windowOpened(WindowEvent e) {
        // Tidak melakukan tindakan apa pun ketika jendela dibuka
    }

    // Override method windowClosed dari interface WindowListener
    public void windowClosed(WindowEvent e) {
        // Tidak melakukan tindakan apa pun ketika jendela ditutup
    }

    // Override method windowIconified dari interface WindowListener
    public void windowIconified(WindowEvent e) {
        // Tidak melakukan tindakan apa pun ketika jendela di-iconify (minimized)
    }

    // Override method windowDeiconified dari interface WindowListener
    public void windowDeiconified(WindowEvent e) {
        // Tidak melakukan tindakan apa pun ketika jendela di-deiconify (restored)
    }

    // Override method windowActivated dari interface WindowListener
    public void windowActivated(WindowEvent e) {
        // Tidak melakukan tindakan apa pun ketika jendela diaktifkan
    }

    // Override method windowDeactivated dari interface WindowListener
    public void windowDeactivated(WindowEvent e) {
        // Tidak melakukan tindakan apa pun ketika jendela dinonaktifkan
    }
}
