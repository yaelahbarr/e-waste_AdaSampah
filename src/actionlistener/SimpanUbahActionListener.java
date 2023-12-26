/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionlistener;

import java.awt.event.*;
import user.User;
import user.UserFrame;
import dao.UserDao;

/**
 *
 * @author wdead
 */
public class SimpanUbahActionListener implements ActionListener {
    private final UserFrame userFrame; // Variable userFrame untuk menyimpan nilai userFrame
    private final UserDao userDao; // Variable userDao untuk menyimpan nilai userDao
    private String id; // Variable id untuk menyimpan nilai id dari user yang akan diubah

    // Constructor SimpanActionListener
    public SimpanUbahActionListener(UserFrame userFrame, UserDao userDao, String id) {
        // Inisialisasi nilai dari userFrame, userDao, dan id
        this.userFrame = userFrame;
        this.userDao = userDao;
        this.id = id;
    }

    public void actionPerformed(ActionEvent e) {

        // Variable nama untuk menyimpan nilai dari objek textFieldNama (nama)
        String nama = this.userFrame.getNamaTextField().getText();
        // Variable telepon untuk menyimpan nilai dari objek textFieldTelepon (telepon)
        String email = this.userFrame.getEmailTextField().getText();
        // Variable alamat untuk menyimpan nilai dari objek txtOutput (alamat)
        String password = this.userFrame.getPasswordTextField().getText();

        // Jika nama, telepon dan alamat bernilai kosong
        if (nama.equalsIgnoreCase("") && email.equalsIgnoreCase("") && password.equalsIgnoreCase("")) {
            // Panggil method showAlertAllEmpty pada userFrame
            this.userFrame.showAlertAllEmpty();
            return;
        } else {
            // Jika nama bernilai kosong
            if (nama.equalsIgnoreCase("")) {
                // Panggil method showAlertNameEmpty pada userFrame
                this.userFrame.showAlertNameEmpty();
                return;
            }
            // Jika telepon bernilai kosong
            if (email.equalsIgnoreCase("")) {
                // Panggil method showAlertTelephoneEmpty pada userFrame
                this.userFrame.showAlertEmailEmpty();
                return;
            }
            // Jika alamat bernilai kosong
            if (password.equalsIgnoreCase("")) {
                // Panggil method showAlertAddressEmpty pada userFrame
                this.userFrame.showAlertPasswordEmpty();
                return;
            }
        }

        // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
        int confirmation = this.userFrame.showConfirmation("ubah");

        // Jika confirmation berinilai opsi yes
        if (confirmation == 0) {
            // Buat objek user untuk menyimpan nilai user yang akan diubah
            User user = new User();

            // Set id user dengan nilai this.id 
            user.setId(this.id);
            // Set nama user dengan nilai nama
            user.setNama(nama);
            // Set telepon user dengan nilai telepon
            user.setEmail(email);
            // Set alamat user dengan nilai alamat
            user.setPassword(password);

            // Panggil method updateUser pada userFrame dengan parameter user
            this.userFrame.updateUser(user);
            // Panggil method update pada userDao dengan parameter user
            this.userDao.update(user);

            // Panggil method showAlertSuccess pada userFrame dengan parameter "diubah"
            this.userFrame.showAlertSuccess("diubah");

            // Kembalikan nilai id ke kondisi kosong
            this.id = null;
        }
        // Jika confirmation nilai opsi no
        else {
            // Panggil method showAlertFailed pada userFrame dengan parameter "diubah"
            this.userFrame.showAlertFailed("diubah");
        }

        // Kembalikan isi textFieldNama ke kondisi kosong
        this.userFrame.getNamaTextField().setText("");
        // Kembalikan isi textFieldTelepon ke kondisi kosong
        this.userFrame.getEmailTextField().setText("");
        // Kembalikan isi textare ke kondisi kosong
        this.userFrame.getPasswordTextField().setText("");

        // Hapus action listener dari button simpan ubah
        this.userFrame.getButtonSimpanUbah().removeActionListener(this);
    }
    
}
