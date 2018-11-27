package com.tabeldata.bootcamp.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Tabungan extends Nasabah {
    private Integer id;
    private Nasabah nasabah;
    private BigDecimal saldo;
    private String namaTabungan;
    private List<Tabungan> listTabungan = new ArrayList<>();

    public Tabungan(){}

    public Tabungan (Integer id, Integer nasabahID, BigDecimal saldo, String namaTabungan){
        super.setId(nasabahID);
        this.setId(id);
        this.setNasabah(nasabah);
        this.setSaldo(saldo);
        this.setNamaTabungan(namaTabungan);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    public String getNamaTabungan() {
        return namaTabungan;
    }

    public void setNamaTabungan(String namaTabungan) {
        this.namaTabungan = namaTabungan;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Tabungan> getListTabungan() {
        return listTabungan;
    }

    public void setListTabungan(List<Tabungan> listTabungan) {
        this.listTabungan = listTabungan;
    }

    @Override
    public String toString() {
        return String.format("{ id: %s, nasabah_id: %s, saldo: %s, nama_tabungan: %s }",
                getId(),
                getNasabah(),
                getSaldo(),
                getNamaTabungan());
    }




}
