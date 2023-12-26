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
public class HapusActionListener implements ActionListener {
    // Variabel untuk menyimpan referensi ke UserFrame
    private final UserFrame userFrame;
    // Variabel untuk menyimpan referensi ke UserDao
    private final UserDao userDao;

    // Konstruktor untuk HapusActionListener
    public HapusActionListener(UserFrame userFrame, UserDao userDao) {
      // Inisialisasi variabel dengan nilai dari parameter konstruktor
      this.userFrame = userFrame;
      this.userDao = userDao;
    }

    // Metode yang dipanggil ketika aksi "Hapus" dilakukan
    public void actionPerformed(ActionEvent e) {
      // Mendapatkan baris dan kolom yang dipilih dari tabel
      int row = this.userFrame.getTable().getSelectedRow();
      int column = this.userFrame.getTable().getSelectedColumn();

      // Memeriksa apakah baris atau kolom tidak dipilih
      if (row == -1 || column == -1) {
        // Menampilkan pesan peringatan jika tidak ada baris atau kolom yang dipilih
        this.userFrame.showAlertFailed("dihapus");
        return;
      } else {
        // Mendapatkan nilai dari sel tabel yang dipilih
        String newValue = (String) this.userFrame.getTable().getModel().getValueAt(row, column);
        // Membuat objek User untuk menyimpan ID data yang akan dihapus
        User id = new User();
        // Variabel untuk menyimpan nama kolom yang akan dihapus
        String col = "";

        // Switch case untuk menentukan nama kolom yang sesuai dengan kolom yang dipilih
        switch (column) {
            case 0:
                col = "nama";
                break;
            case 1:
                col = "email";
                break;
            case 2:
                col = "password";
                break;
            default:
                // Menampilkan pesan di konsol jika kolom tidak ditemukan
                System.out.println("Kolom tidak ditemukan");
                break;
        }

        // Memanggil metode select dari UserDao untuk mendapatkan ID data yang akan dihapus
        id = this.userDao.select(col, newValue);

        // Menampilkan dialog konfirmasi penghapusan
        int confirmation = this.userFrame.showConfirmation("hapus");

        // Memeriksa apakah pengguna mengkonfirmasi penghapusan
        if (confirmation == 1) {
          // Menampilkan pesan peringatan jika pengguna membatalkan penghapusan
          this.userFrame.showAlertFailed("tidak dihapus");
          return;
        } else {
          // Menghapus data dari tabel dan database
          this.userFrame.deleteUser(id);
          this.userDao.delete(id);
          // Menampilkan pesan sukses setelah penghapusan
          this.userFrame.showAlertSuccess("dihapus");
        }
      }
    }
}
