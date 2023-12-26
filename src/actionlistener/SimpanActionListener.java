/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionlistener;

import java.awt.event.*;
import java.util.UUID;
import user.User;
import user.UserFrame;
import dao.UserDao;

/**
 *
 * @author wdead
 */
public class SimpanActionListener implements ActionListener {
    private final UserFrame userFrame;
    private final UserDao userDao;

    // Constructor SimpanActionListener dengan dua parameter
    public SimpanActionListener(UserFrame userFrame, UserDao userDao) {
        // Inisialisasi nilai dari userFrame dan userDao
        this.userFrame = userFrame;
        this.userDao = userDao;
    }

    // Implementasi actionPerformed dari ActionListener
    public void actionPerformed(ActionEvent e) {

        // Ambil nilai dari inputan nama, telepon, dan alamat
        String nama = userFrame.getNama();
        String email = userFrame.getEmail();
        String password = userFrame.getPassword();

        // Validasi jika semua input kosong
        if (nama.equalsIgnoreCase("") && email.equalsIgnoreCase("") && password.equalsIgnoreCase("")) {
            this.userFrame.showAlertAllEmpty();
            return;
        } else {
            // Validasi jika nama kosong
            if (nama.equalsIgnoreCase("")) {
                this.userFrame.showAlertNameEmpty();
                return;
            }

            // Validasi jika telepon kosong
            if (email.equalsIgnoreCase("")) {
                this.userFrame.showAlertEmailEmpty();
                return;
            }

            // Validasi jika alamat kosong
            if (password.equalsIgnoreCase("")) {
                this.userFrame.showAlertPasswordEmpty();
                return;
            }
        }

        // Tampilkan konfirmasi untuk menambahkan user
        int confirmation = this.userFrame.showConfirmation("tambah");

        // Jika konfirmasi = Yes (0)
        if (confirmation == 0) {
            // Buat objek user
            User user = new User();

            // Set ID dengan nilai random
            user.setId(UUID.randomUUID().toString());
            // Set Nama dengan nilai dari inputan
            user.setNama(nama);
            // Set Nomor Telepon dengan nilai dari inputan
            user.setEmail(email);
            // Set Jenis Kelamin dengan nilai dari inputan
            user.setPassword(password);

            // Tambahkan user ke frame dan DAO
            this.userFrame.addUser(user);
            this.userDao.insert(user);

            // Tampilkan pesan sukses
            this.userFrame.showAlertSuccess("ditambahkan");
        } else {
            // Tampilkan pesan gagal
            this.userFrame.showAlertFailed("ditambahkan");
        }

        // Set semua inputan kembali ke kondisi kosong
        this.userFrame.getNamaTextField().setText("");
        this.userFrame.getEmailTextField().setText("");
        this.userFrame.getPasswordTextField().setText("");
    }
}
