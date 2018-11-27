package com.tabeldata.bootcamp;

import com.tabeldata.bootcamp.model.Nasabah;
import com.tabeldata.bootcamp.model.Tabungan;

import java.math.BigDecimal;
import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


public class App
{
    static String url = "jdbc:postgresql://127.0.0.1:5432/me";
    static String username = "me";
    static String password = "me";

    public static void main( String[] args )
    {
        Connection conn = null;

        try {
            List<Nasabah> nasabahs = new ArrayList<Nasabah>();
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);

            //Insert data ke tabel mst_nasabah
            String query = "insert into mst_nasabah values (?,?,?);";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, 1);
            statement.setString(2, "Dimas Maryanto");
            statement.setString(3, "Jl.bukit indan");
            statement.addBatch();
            statement.setInt(1, 2);
            statement.setString(2, "Hilman Ramadhan");
            statement.setString(3, "Ujung Berung");
            statement.addBatch();
            statement.executeBatch();


            //Select data ke tabel mst_nasabah
            query = "select * from mst_nasabah;";
            statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Nasabah nasabah = new Nasabah(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
                System.out.println(nasabah.toString());
                nasabahs.add(nasabah);
            }

            //Insert data ke tabel mst_tabungan
            query = "insert into mst_tabungan values (?,?,?,?);";
            statement = conn.prepareStatement(query);
            statement.setInt(1, 1);
            statement.setInt(2, 1);
            statement.setBigDecimal(3, BigDecimal.valueOf(250000));
            statement.setString(4, "Tabungan Umroh");
            statement.addBatch();

            statement.setInt(1, 2);
            statement.setInt(2, 1);
            statement.setBigDecimal(3, BigDecimal.valueOf(0));
            statement.setString(4, "Tabungan Mapan");
            statement.addBatch();

            statement.setInt(1, 3);
            statement.setInt(2, 2);
            statement.setBigDecimal(3, BigDecimal.valueOf(500000));
            statement.setString(4, "Tabungan Umroh");
            statement.addBatch();
            statement.executeBatch();


            //Select data ke tabel mst_tabungan

            List<Tabungan> listTabungan = new ArrayList<Tabungan>();
            query = "select * from mst_tabungan;";
            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Tabungan tabungan = new Tabungan(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getBigDecimal(3),
                        resultSet.getString(4));
                System.out.println(tabungan.toString());
                listTabungan.add(tabungan);
            }


            //Insert data ke tabel mst_trx_transaksi_tabungan
            query = "insert into trx_transaksi_tabungan values (?,?,?,?,?,?);";
            statement = conn.prepareStatement(query);

            statement.setInt(1, 1);
            statement.setInt(2, 1);
            statement.setBigDecimal(3, BigDecimal.valueOf(250000));
            statement.setBigDecimal(4, BigDecimal.valueOf(250000));
            statement.setBigDecimal(5, BigDecimal.valueOf(250000));
            statement.setDate(6, Date.valueOf("2017-03-20"));
            statement.addBatch();

            statement.setInt(1, 2);
            statement.setInt(2, 1);
            statement.setBigDecimal(3, BigDecimal.valueOf(250000));
            statement.setBigDecimal(4, BigDecimal.valueOf(250000));
            statement.setBigDecimal(5, BigDecimal.valueOf(250000));
            statement.setDate(6, Date.valueOf("2017-03-21"));
            statement.addBatch();

            statement.setInt(1, 3);
            statement.setInt(2, 2);
            statement.setBigDecimal(3, BigDecimal.valueOf(250000));
            statement.setBigDecimal(4, BigDecimal.valueOf(250000));
            statement.setBigDecimal(5, BigDecimal.valueOf(250000));
            statement.setDate(6, Date.valueOf("2017-03-22"));
            statement.addBatch();

            statement.setInt(1, 4);
            statement.setInt(2, 2);
            statement.setBigDecimal(3, BigDecimal.valueOf(250000));
            statement.setBigDecimal(4, BigDecimal.valueOf(250000));
            statement.setBigDecimal(5, BigDecimal.valueOf(250000));
            statement.setDate(6, Date.valueOf("2017-03-23"));
            statement.addBatch();

            statement.setInt(1, 5);
            statement.setInt(2, 2);
            statement.setBigDecimal(3, BigDecimal.valueOf(250000));
            statement.setBigDecimal(4, BigDecimal.valueOf(250000));
            statement.setBigDecimal(5, BigDecimal.valueOf(250000));
            statement.setDate(6, Date.valueOf("2017-03-24"));
            statement.addBatch();

            statement.setInt(1, 6);
            statement.setInt(2, 3);
            statement.setBigDecimal(3, BigDecimal.valueOf(250000));
            statement.setBigDecimal(4, BigDecimal.valueOf(250000));
            statement.setBigDecimal(5, BigDecimal.valueOf(250000));
            statement.setDate(6, Date.valueOf("2017-03-25"));
            statement.addBatch();

            statement.executeBatch();

            System.out.println("BERHASIL.....");

            conn.commit();
            statement.close();
            resultSet.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Gagal konek ke database");
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
