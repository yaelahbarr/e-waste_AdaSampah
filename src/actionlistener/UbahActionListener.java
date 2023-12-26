/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionlistener;

import java.awt.event.*;
import user.UserFrame;
import dao.UserDao;

/**
 *
 * @author wdead
 */
public class UbahActionListener implements ActionListener {
    private final UserFrame userFrame; // Variable userFrame untuk menyimpan nilai userFrame
    private final UserDao userDao; // Variable userDao untuk menyimpan nilai userDao

    public UbahActionListener(UserFrame userFrame, UserDao userDao) {
        // Inisialisasi nilai dari userFrame dan userDao
        this.userFrame = userFrame;
        this.userDao = userDao;
    }

    public void actionPerformed(ActionEvent e) {
        // Variable row untuk menyimpan nilai baris yang dipilih
        int row = this.userFrame.getTable().getSelectedRow();

        // Variable column untuk menyimpan nilai kolom yang dipilih
        int column = this.userFrame.getTable().getSelectedColumn();

        // Variable userUbah untuk menyimpan nilai dari table yang diedit
        String userUbah = (String) this.userFrame.getTable().getModel().getValueAt(row, column);

        // Variable id untuk menyimpan nilai id dari user yang akan diubah
        String id = "";

        // Variable col untuk menyimpan nama kolom yang dipilih
        String col = "";

        // Switch case untuk menentukan nama kolom yang dipilih
        switch (column) {
            // Jika kolom bernilai 0
            case 0:
                // Set col dengan nama
                col = "nama";
                break;
            // Jika kolom bernilai 1
            case 1:
                // Set col dengan no_telepon
                col = "email";
                break;
            // Jika kolom bernilai 2
            case 2:
                // Set col dengan jenis_kelamin
                col = "password";
                break;
            // Jika kolom bernilai selain 0, 1, 2, dan 3
            default:
                // Tampilkan pesan kolom tidak ditemukan
                System.out.println("Kolom tidak ditemukan");
                break;
        }

        // Dapatkan id dari user yang akan diubah
        id = this.userDao.select(col, userUbah).getId();
        
        // Set nilai dari textFieldNama dengan user yang akan diubah
        this.userFrame.getNamaTextField().setText(this.userDao.select(col, userUbah).getNama());
        // Set nilai dari textFieldTelepon dengan user yang akan diubah
        this.userFrame.getEmailTextField().setText(this.userDao.select(col, userUbah).getEmail());

        // Set nilai dari textFieldAlamat dengan user yang akan diubah
        this.userFrame.getPasswordTextField().setText(this.userDao.select(col, userUbah).getPassword());

        // Instansiasi objek SimpanUbahActionListener dengan nama simpanUbahListener
        SimpanUbahActionListener simpanUbahListener = new SimpanUbahActionListener(
                this.userFrame,
                this.userDao,
                id);

        // Tambahkan action listener pada buttonSimpanUbah
        this.userFrame.getButtonSimpanUbah().addActionListener(simpanUbahListener);
    }
    
}
