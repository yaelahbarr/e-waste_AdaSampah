/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import javax.swing.*;
import java.util.*;
import dao.UserDao;
import actionlistener.HapusActionListener;
import actionlistener.SimpanActionListener;
import actionlistener.UbahActionListener;
import actionlistener.CloseWindowActionListener;
import actionlistener.SaveToFileActionListener;

/**
 *
 * @author wdead
 */
public class UserFrame extends JFrame {
    private List<User> userList; // Daftar user
    private final JTextField textFieldNama; // TextField untuk nama
    private final JTextField textFieldEmail; // TextField untuk email
    private final JTextField textFieldPassword; // TextField untuk password
    private final ModelTable tableModel; // Model tabel untuk JTable
    private final JTable table; // Tabel untuk menampilkan user
    private final JButton buttonSimpanUbah; // Tombol untuk menyimpan atau mengubah user
    private final UserDao userDao; // Objek untuk mengakses data user dari database

    public UserFrame(UserDao userDao) {
        this.userDao = userDao; // Inisialisasi objek userDao
        this.userList = this.userDao.findAll(); // Mendapatkan daftar user dari database

        JLabel labelHeader = new JLabel("Form User", JLabel.CENTER); // Label untuk header form user
        labelHeader.setBounds(0, 20, 350, 10);

        JLabel labelNama = new JLabel("Nama: "); // Label untuk input nama
        labelNama.setBounds(15, 40, 350, 10);

        textFieldNama = new JTextField(); // TextField untuk input nama
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelEmail = new JLabel("Email: "); // Label untuk input Email
        labelEmail.setBounds(15, 100, 350, 10);

        textFieldEmail = new JTextField(); // TextField untuk input Email
        textFieldEmail.setBounds(15, 120, 350, 30);
        
        JLabel labelPassword = new JLabel("Password: "); // Label untuk input Password
        labelPassword.setBounds(15, 160, 350, 10);

        textFieldPassword = new JTextField(); // TextField untuk input Password
        textFieldPassword.setBounds(15, 180, 350, 30);

        JButton button = new JButton("Simpan"); // Tombol untuk menyimpan user baru
        button.setBounds(15, 380, 100, 40);

        JButton buttonUbah = new JButton("Ubah"); // Tombol untuk mengubah user yang ada
        buttonUbah.setBounds(125, 380, 100, 40);

        JButton buttonHapus = new JButton("Hapus"); // Tombol untuk menghapus user yang ada
        buttonHapus.setBounds(235, 380, 100, 40);

        buttonSimpanUbah = new JButton("Simpan Ubah"); // Tombol untuk menyimpan atau mengubah user
        buttonSimpanUbah.setBounds(345, 380, 150, 40);

        JButton refresh = new JButton("Refresh"); // Tombol untuk merefresh data pada tabel
        refresh.setBounds(15, 650, 100, 40);
        
        refresh.addActionListener(e -> {
            refreshUserTable(); // Menambahkan listener untuk merefresh tabel user
        });

        table = new JTable(); // Tabel untuk menampilkan user
        JScrollPane scrollableTable = new JScrollPane(table); // JScrollPane agar tabel bisa di-scroll
        scrollableTable.setBounds(15, 440, 500, 200);

        tableModel = new ModelTable(userList); // Model tabel untuk mengelola data pada tabel
        table.setModel(tableModel); // Mengatur model tabel

        JButton buttonFile = new JButton("Simpan ke File"); // Tombol untuk menyimpan data ke file
        buttonFile.setBounds(345, 650, 150, 40);

        SimpanActionListener simpanListener = new SimpanActionListener(this, userDao);
        button.addActionListener(simpanListener); // Menambahkan listener untuk tombol simpan

        UbahActionListener ubahListener = new UbahActionListener(this, userDao);
        buttonUbah.addActionListener(ubahListener); // Menambahkan listener untuk tombol ubah

        HapusActionListener hapusListener = new HapusActionListener(this, userDao);
        buttonHapus.addActionListener(hapusListener); // Menambahkan listener untuk tombol hapus

        SaveToFileActionListener saveToFileListener = new SaveToFileActionListener(this, userList);
        buttonFile.addActionListener(saveToFileListener); // Menambahkan listener untuk tombol simpan ke file

        CloseWindowActionListener closeWindowListener = new CloseWindowActionListener(this);
        this.addWindowListener(closeWindowListener); // Menambahkan listener untuk menangani penutupan window

        this.add(labelHeader);
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelEmail);
        this.add(textFieldEmail);
        this.add(labelPassword);
        this.add(textFieldPassword);
        this.add(button);
        this.add(buttonUbah);
        this.add(buttonHapus);
        this.add(buttonFile);
        this.add(scrollableTable);
        this.add(refresh);
        this.add(buttonSimpanUbah);

        this.setSize(550, 1000); // Mengatur ukuran frame
        this.setLayout(null); // Mengatur layout frame menjadi null
    }

    public String getNama() {
        return textFieldNama.getText(); // Mendapatkan nilai dari input nama
    }

    public JTextField getNamaTextField() {
        return textFieldNama; // Mendapatkan objek TextField untuk input nama
    }

    public String getEmail() {
        return textFieldEmail.getText(); // Mendapatkan nilai dari input nomor HP
    }

    public JTextField getEmailTextField() {
        return textFieldEmail; // Mendapatkan objek TextField untuk input nomor HP
    }
    
     public String getPassword() {
        return textFieldPassword.getText(); // Mendapatkan nilai dari input nomor HP
    }

    public JTextField getPasswordTextField() {
        return textFieldPassword; // Mendapatkan objek TextField untuk input nomor HP
    }

    public ModelTable getTableModel() {
        return this.tableModel; // Mendapatkan objek ModelTable untuk tabel user
    }

    public JTable getTable() {
        return this.table; // Mendapatkan objek tabel untuk menampilkan user
    }

    public JButton getButtonSimpanUbah() {
        return this.buttonSimpanUbah; // Mendapatkan objek tombol untuk menyimpan atau mengubah user
    }

    public void addUser(User user) {
        tableModel.add(user); // Menambahkan user ke model tabel
        textFieldNama.setText(""); // Mengosongkan input nama
        textFieldEmail.setText(""); // Mengosongkan input nomor HP
        textFieldPassword.setText(""); // Mengosongkan input nomor HP
       
    }

    public void updateUser(User user) {
        tableModel.update(user); // Mengubah user pada model tabel
        textFieldNama.setText(""); // Mengosongkan input nama
        textFieldEmail.setText(""); // Mengosongkan input nomor HP
        textFieldPassword.setText(""); // Mengosongkan input nomor HP
    }

    public void deleteUser(User user) {
        tableModel.delete(user); // Menghapus user dari model tabel
    }

    public void refreshUserTable() {
        this.userList = this.userDao.findAll(); // Mendapatkan daftar user terbaru dari database
        this.getTable().setModel(new ModelTable(this.userList)); // Mengatur model tabel dengan daftar user yang terbaru

        System.out.println("Table refreshed: ");
        if (userList.isEmpty()) {
            System.out.println("Table is empty");
        } else {
            for (User user : userList) {
                System.out.println(user.getNama() + " " + user.getEmail() + " " + user.getPassword() + " ");
            }
        }
        System.out.println();
    }

    public void showAlertAllEmpty() {
        JOptionPane.showMessageDialog(UserFrame.this, "Nama, Email dan Password belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE); // Menampilkan peringatan jika semua field belum terisi
    }

    public void showAlertNameEmpty() {
        JOptionPane.showMessageDialog(UserFrame.this, "Nama belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE); // Menampilkan peringatan jika field nama belum terisi
    }

    public void showAlertEmailEmpty() {
        JOptionPane.showMessageDialog(UserFrame.this, "Email belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE); // Menampilkan peringatan jika field telepon belum terisi
    }

    public void showAlertPasswordEmpty() {
        JOptionPane.showMessageDialog(UserFrame.this, "Password belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE); // Menampilkan peringatan jika field alamat belum terisi
    }

    public void showAlertSuccess(String message) {
        JOptionPane.showMessageDialog(UserFrame.this, "Data " + message, "Perhatian",
                JOptionPane.INFORMATION_MESSAGE); // Menampilkan pemberitahuan keberhasilan operasi
    }

    public void showAlertFailed(String message) {
        JOptionPane.showMessageDialog(UserFrame.this, "Data " + message, "Perhatian",
                JOptionPane.ERROR_MESSAGE); // Menampilkan peringatan kegagalan operasi
    }

    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(UserFrame.this,
                "Apakah anda yakin ingin " + message + " data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        // Menampilkan konfirmasi untuk tindakan tertentu
    }
}
