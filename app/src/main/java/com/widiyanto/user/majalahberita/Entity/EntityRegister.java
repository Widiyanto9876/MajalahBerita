package com.widiyanto.user.majalahberita.Entity;

public class EntityRegister {
    String UserName;
    String Password;
    String email;
    String namaPengguna;
    String nomerHp;
    String alamat;

    public EntityRegister(String userName, String password, String email, String namaPengguna, String nomerHp, String alamat) {
        this.UserName = userName;
        this.Password = password;
        this.email = email;
        this.namaPengguna = namaPengguna;
        this.nomerHp = nomerHp;
        this.alamat = alamat;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
    }

    public String getNomerHp() {
        return nomerHp;
    }

    public void setNomerHp(String nomerHp) {
        this.nomerHp = nomerHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
