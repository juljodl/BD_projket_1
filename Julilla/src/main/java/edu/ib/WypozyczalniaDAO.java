package edu.ib;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WypozyczalniaDAO
{
    private DBUtil dbUtil;

    public WypozyczalniaDAO(DBUtil dbUtil) { this.dbUtil = dbUtil; }

    //dostepne samochody do buttona pokaz dostepne + do klikania na nr rejestracji w choiceboxie
    public ObservableList<DostepneSamochody> showAllDostepneSamochody() throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM dostepne_samochody;";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<DostepneSamochody> dostepneSamochodyList = getDostepneSamochodyList(resultSet);

            return dostepneSamochodyList;


        } catch (SQLException e) {

            throw e;
        }

    }

    public DostepneSamochody showDostepnySamochodDane(String nrRej) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM dostepne_samochody where nr_rejestracyjny = " + '"' + nrRej + '"';

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            return getSamochod(resultSet);


        } catch (SQLException e) {

            throw e;
        }

    }


    public PodsumowanieWypozyczenia showUszkodzenia(String samochod) throws SQLException, ClassNotFoundException
    {
        String stmt = "SELECT uszkodzenia FROM podsumowanie_wypozyczenia where id_samochod = " +'"'+samochod+'"';

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(stmt);

            return getUszkodzenie(resultSet);





        } catch (SQLException e) {

            throw e;
        }
    }


    public PodsumowanieWypozyczenia showStartWypozyczenia(String samochod, String data_pocz) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM podsumowanie_wypozyczenia WHERE id_samochod = " + '"' + samochod + '"'+ "and data_wypozyczenia= " + '"'+data_pocz+'"';

        try {
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            return getStart(resultSet);
        } catch (SQLException e) {
            throw e;
        }

    }



    public ObservableList<PodsumowanieWypozyczenia> showKoniecWypozyczenia(String samochod, String data_pocz) throws SQLException, ClassNotFoundException {

        ObservableList<PodsumowanieWypozyczenia> part1 = FXCollections.observableArrayList();
        ObservableList<PodsumowanieWypozyczenia> part2 = FXCollections.observableArrayList();
        String selectStmt = "SELECT * FROM podsumowanie_wypozyczenia WHERE id_samochod = " + '"' + samochod + '"'+ "and data_wypozyczenia= " + '"'+data_pocz+'"';

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ResultSet resultSet1 = dbUtil.dbExecuteQuery(selectStmt);

            part1.add(getWypozyczenia1(resultSet));
            part1.add(getWypozyczenia2(resultSet1));



            return part1;


        } catch (SQLException e) {

            throw e;
        }

    }

    public ObservableList<PodsumowanieWypozyczenia> showHisoriaWypozyczen(String klient) throws SQLException, ClassNotFoundException {

        ObservableList<PodsumowanieWypozyczenia> historiaList = FXCollections.observableArrayList();
        String selectStmt = "SELECT * FROM podsumowanie_wypozyczenia WHERE id_klienta = " + '"' + klient + '"';

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

           historiaList = getWypozyczeniaList(resultSet);


            return historiaList;


        } catch (SQLException e) {

            throw e;
        }

    }

    public ObservableList<PodsumowanieWypozyczenia> showWypozyczeniaSamochoduOW(String samochod) throws SQLException, ClassNotFoundException {

        ObservableList<PodsumowanieWypozyczenia> wypozyczeniaSamochoduList = FXCollections.observableArrayList();
        String selectStmt = "SELECT * FROM podsumowanie_wypozyczenia WHERE id_samochod = '" + samochod +"';" ;

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<PodsumowanieWypozyczenia> lista = getWypozyczeniaList(resultSet);

            //wypozyczeniaSamochoduList = getWypozyczeniaList(resultSet);


            return lista;


        } catch (SQLException e) {

            throw e;
        }

    }

    public ObservableList<StanyBaterii> showStanyBateriiOW() throws SQLException, ClassNotFoundException {


        String selectStmt = "SELECT * FROM stany_baterii_samochodow;";

        try {
            if(dbUtil == null )
            System.out.println("dbUtil jest NULL !!!");
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

          ObservableList<StanyBaterii>  stanyBateriList = getStanyBaterii(resultSet);
            System.out.println(stanyBateriList);

            return stanyBateriList;


        } catch (SQLException e) {

            throw e;
        }

    }

    public ObservableList<StanyBaterii> showStanyBateriiJednegoOW(String samochod) throws SQLException, ClassNotFoundException {

        ObservableList<StanyBaterii> stanyBateriJednegoList = FXCollections.observableArrayList();
        String selectStmt = "SELECT * FROM stany_baterii_samochodow where nr_rejestracyjny= "+'"'+samochod+'"';

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            stanyBateriJednegoList = getStanyBaterii(resultSet);


            return stanyBateriJednegoList;


        } catch (SQLException e) {

            throw e;
        }

    }



    public ObservableList<Utarg> showUtargDniaOW(String data) throws SQLException, ClassNotFoundException {

        ObservableList<Utarg> utargDniaList = FXCollections.observableArrayList();
        String selectStmt = "SELECT * FROM wplaty_na_dany_dzien where data_wplaty =  "+'"'+data+'"';

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            utargDniaList = getUtarg(resultSet);


            return utargDniaList;


        } catch (SQLException e) {

            throw e;
        }

    }

    public ObservableList<Utarg> showSumaZaDzienOW(String data) throws SQLException, ClassNotFoundException {

        ObservableList<Utarg> sumaZaDzienList = FXCollections.observableArrayList();
        String selectStmt = "SELECT sum(wartosc) FROM wplaty_na_dany_dzien where data_wplaty = "+'"'+data+'"';

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            sumaZaDzienList = getUtarg(resultSet);


            return sumaZaDzienList;


        } catch (SQLException e) {

            throw e;
        }

    }



    private ObservableList<DostepneSamochody> getDostepneSamochodyList(ResultSet rs) throws SQLException {

        ObservableList<DostepneSamochody> dostepneList = FXCollections.observableArrayList();

        while (rs.next()) {

            DostepneSamochody ds = new DostepneSamochody();
            ds.setNrRejestracyjny(rs.getString("nr_rejestracyjny"));
            ds.setNazwa(rs.getString("nazwa"));
            ds.setMarka(rs.getString("marka"));
            ds.setLicznikKm(rs.getInt("licznik_km"));
            ds.setDystansKmNaLadowanie(rs.getInt("dystans_km_na_ladowanie"));
            ds.setStanBaterii(rs.getFloat("stan_baterii"));
            ds.setDataWygasnieciaPrzegladu(rs.getString("data_wygasniecia_przegladu"));
            //ds.setUszkodzenia(rs.getString("uszkodzenia"));
            dostepneList.add(ds);
        }

        return dostepneList;
    }

    private PodsumowanieWypozyczenia getWypozyczenia1(ResultSet rs) throws SQLException {

        PodsumowanieWypozyczenia pw = new PodsumowanieWypozyczenia();
        while (rs.next()) {

            pw.setIdWypozyczenia(rs.getInt("id_wypozyczenia"));
            pw.setIdSamochod(rs.getString("id_samochod"));
            pw.setDataWypozyczenia(rs.getString("data_wypozyczenia"));
            pw.setDataOddania(rs.getString("data_oddania"));
            pw.setDlGeoStart(rs.getFloat("dl_geo_start"));
            pw.setSzerGeoStart(rs.getFloat("szer_geo_start"));
        } return pw;
    }

    private PodsumowanieWypozyczenia getWypozyczenia2(ResultSet rs) throws SQLException {

        PodsumowanieWypozyczenia pw = new PodsumowanieWypozyczenia();
        while (rs.next()) {
            pw.setDlGeoStop(rs.getFloat("dl_geo_stop"));
            pw.setSzerGeoStop(rs.getFloat("szer_geo_stop"));
            pw.setDystans(rs.getFloat("dystans"));
            pw.setKwota(rs.getFloat("kwota"));
            pw.setUszkodzenia(rs.getString("uszkodzenia"));
        } return pw;
    }


    private PodsumowanieWypozyczenia getUszkodzenie(ResultSet rs) throws SQLException
    {
        StringBuilder sb = new StringBuilder();

        PodsumowanieWypozyczenia pw = new PodsumowanieWypozyczenia();
        while (rs.next())
        {
           if(rs.getString("uszkodzenia")!=null)
           sb.append(rs.getString("uszkodzenia")).append("\n");
        }
        pw.setUszkodzenia(sb.toString());

    return pw;
    }






    private DostepneSamochody getSamochod(ResultSet rs) throws SQLException {

        DostepneSamochody ds = new DostepneSamochody();

        while (rs.next()) {

            ds.setNrRejestracyjny(rs.getString("nr_rejestracyjny"));
            ds.setNazwa(rs.getString("nazwa"));
            ds.setMarka(rs.getString("marka"));
            ds.setLicznikKm(rs.getInt("licznik_km"));
            ds.setDystansKmNaLadowanie(rs.getInt("dystans_km_na_ladowanie"));
            ds.setStanBaterii(rs.getFloat("stan_baterii"));
            ds.setDataWygasnieciaPrzegladu(rs.getString("data_wygasniecia_przegladu"));
            //ds.setUszkodzenia(rs.getString("uszkodzenia"));
        }

        return ds;
    }


    private PodsumowanieWypozyczenia getStart(ResultSet rs) throws SQLException
    {
        PodsumowanieWypozyczenia pw = new PodsumowanieWypozyczenia();
        while (rs.next())
        {
            pw.setIdWypozyczenia(rs.getInt("id_wypozyczenia"));
            pw.setIdSamochod(rs.getString("id_samochod"));
            pw.setIdKlienta(rs.getString("id_klienta"));
            pw.setDataWypozyczenia(rs.getString("data_wypozyczenia"));
            pw.setDlGeoStart(rs.getFloat("dl_geo_start"));
            pw.setSzerGeoStart(rs.getFloat("szer_geo_start"));

        }
        return pw;
    }

    private ObservableList<PodsumowanieWypozyczenia> getWypozyczeniaList(ResultSet rs) throws SQLException {

        ObservableList<PodsumowanieWypozyczenia> wypozyczeniaList = FXCollections.observableArrayList();

        while (rs.next()) {

            PodsumowanieWypozyczenia pw = new PodsumowanieWypozyczenia();
            pw.setIdWypozyczenia(rs.getInt("id_wypozyczenia"));
            pw.setIdSamochod(rs.getString("id_samochod"));
            pw.setIdKlienta(rs.getString("id_klienta"));
            pw.setDataWypozyczenia(rs.getString("data_wypozyczenia"));
            pw.setDataOddania(rs.getString("data_oddania"));
            pw.setDlGeoStart(rs.getFloat("dl_geo_start"));
            pw.setSzerGeoStart(rs.getFloat("szer_geo_start"));
            pw.setDlGeoStop(rs.getFloat("dl_geo_stop"));
            pw.setSzerGeoStop(rs.getFloat("szer_geo_stop"));
            pw.setDystans(rs.getFloat("dystans"));
            pw.setKwota(rs.getFloat("kwota"));
            pw.setUszkodzenia(rs.getString("uszkodzenia"));
            wypozyczeniaList.add(pw);

        }

        return wypozyczeniaList;
    }

    private ObservableList<StanyBaterii> getStanyBaterii(ResultSet rs) throws SQLException {

        ObservableList<StanyBaterii> stanyBateriiList = FXCollections.observableArrayList();

        while (rs.next()) {

            StanyBaterii sb= new StanyBaterii();
            sb.setNrRejestracyjny(rs.getString("nr_rejestracyjny"));
            sb.setDystansNaLadowanie(rs.getInt("dystans_km_na_ladowanie"));
            sb.setStanBaterii(rs.getFloat("stan_baterii"));
            stanyBateriiList.add(sb);

        }

        return stanyBateriiList;
    }

    private ObservableList<Utarg> getUtarg(ResultSet rs) throws SQLException {

        ObservableList<Utarg> utargList = FXCollections.observableArrayList();

        while (rs.next()) {

            Utarg u = new Utarg();
            u.setDataWplaty(rs.getString("data_wplaty"));
            u.setKwota(rs.getFloat("wartosc"));
            utargList.add(u);


        }

        return utargList;
    }


    public void callWypozycz(String samochod, String klient)
    {
        String stmt = "call wypozycz("+'"'+samochod+'"'+","+'"'+klient+'"'+")";
        try {
            dbUtil.callProcedura(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void callOddaj(String samochod, String data)
    {
        String stmt="call oddaj("+'"'+samochod+'"'+","+'"'+data+'"'+")";
        try {
            dbUtil.callProcedura(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void callLaduj(String samochod)
    {
        String stmt = "call laduj("+'"'+samochod+'"'+")";
        try {
            dbUtil.callProcedura(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void callUszkodzenia(String samochod, String data, String uszk)
    {
        String stmt = "call wprowadz_uszkodzenia("+'"'+samochod+'"'+","+'"'+data+'"'+","+'"'+ uszk +'"'+")";
        try {
            dbUtil.callProcedura(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }




}//class
