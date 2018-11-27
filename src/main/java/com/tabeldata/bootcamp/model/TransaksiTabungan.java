package com.tabeldata.bootcamp.model;

import java.math.BigDecimal;
import java.util.Date;


public class TransaksiTabungan{
    private Integer id;

    private Integer jenisTransaksi;
    private Date tanggalTransaksi;
    private BigDecimal kredit;
    private BigDecimal debet;
    private BigDecimal saldo;

    public TransaksiTabungan(Integer id, Integer jenisTransaksi, BigDecimal debet, BigDecimal kredit, BigDecimal saldo, Date tanggalTransaksi){
        this.setId(id);
        this.setJenisTransaksi(jenisTransaksi);
        this.setTanggalTransaksi(tanggalTransaksi);
        this.setKredit(kredit);
        this.setDebet(debet);
        this.setSaldo(saldo);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(Integer jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public BigDecimal getKredit() {
        return kredit;
    }

    public void setKredit(BigDecimal kredit) {
        this.kredit = kredit;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getDebet() {
        return debet;
    }

    public void setDebet(BigDecimal debet) {
        this.debet = debet;
    }

    public String toString() {
        return String.format("{ id: %s, tabungan_id: %s, debet: %s, kredit: %s, saldo: %s, tanggal_transaksi: %s }",
                getId(),
                getJenisTransaksi(),
                getDebet(),
                getKredit(),
                getSaldo(),
                getTanggalTransaksi());
    }
}
