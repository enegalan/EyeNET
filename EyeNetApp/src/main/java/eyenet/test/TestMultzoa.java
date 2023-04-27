package eyenet.test;

import eyenet.controller.db.*;
import eyenet.controller.gestorDB;
import eyenet.model.Bill;
import eyenet.model.Erabiltzailea;
import eyenet.model.Hornitzaileak;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.suite.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static eyenet.controller.gestorDB.readURL;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@RunWith(JUnitPlatform.class) // Errorea?
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SelectPackages({"src/main/java/eyenet/controller/","src/main/java/eyenet/controller/db","src/main/java/eyenet/model"})
public class TestMultzoa{

    @RepeatedTest(3)
    @Test
    @DisplayName("AdminDB getRolId(rolName) Test")
    @Tag("Controller")
    public void test1() throws IOException {
        adminDB adminDB = new adminDB();
        int res = adminDB.getRolId("ceo"); // CRUD
        int exp = 4; // ceo-a id_langilea 4 da
        Assertions.assertEquals(exp,res);
    }
    @Test
    @DisplayName("TablesDB getColumns(table) Test")
    @Tag("Controller")
    public void test2() throws IOException {
        tablesDB tablesDB = new tablesDB();
        String[] notexp = new String[0];
        String[] res = tablesDB.getColumns("hornitzaileak"); // CRUD
        Assertions.assertNotEquals(notexp,res); // egia itzuli behar du
    }
    @Test
    @DisplayName("Connection Test")
    @Tag("Controller")
    public void test3() throws IOException {
        loginDB loginDB = new loginDB();
        Assertions.assertDoesNotThrow((Executable) () -> {
            loginDB.login();
        }, "No se esperaba una SQLException");
    }
    @AfterAll
    @Test
    @DisplayName("Disconnect Test")
    @Tag("Controller")
    public void test4() throws IOException {
        loginDB loginDB = new loginDB();
        Assertions.assertDoesNotThrow((Executable) () -> {
            loginDB.disconnect();
        }, "No se esperaba una SQLException");
    }
    @Test
    @DisplayName("Windows Test")
    public void test5()  {
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("windows")) {
            String filePath = "src/main/java/eyenet/config/config.txt";
            Assertions.assertTrue(new File(filePath).exists(), "El archivo no existe en la ruta especificada");
        } else {
            // El test se omite si no se está ejecutando en Windows
            assumeTrue(false, "Este test solo se puede ejecutar en Windows");
        }
    }
    @Test
    @DisplayName("CSV Test")
    public void test6() throws IOException {
        Assertions.assertNotEquals(null,readURL());
    }
    @Test
    @DisplayName("List Test")
    @Tag("Controller")
    public void test7() throws IOException, ParseException {
        tablesDB tablesDB = new tablesDB();
        Assertions.assertNotEquals(null,tablesDB.listPayrolls());
        Assertions.assertNotEquals(null,tablesDB.listProducts());
        Assertions.assertNotEquals(null,tablesDB.listWorkers());
        Assertions.assertNotEquals(null,tablesDB.listProductsQuery("queryTest"));
        Assertions.assertNotEquals(null,tablesDB.listWorkersQuery("queryTest"));
        Assertions.assertNotEquals(null,tablesDB.listPayrollsQuery("queryTest"));

        adminDB adminDB = new adminDB();
        Assertions.assertNotEquals(null,adminDB.listPerms());
        Assertions.assertNotEquals(null,adminDB.listConsultRequest());
        Assertions.assertNotEquals(null,adminDB.listWorkers());
        Assertions.assertNotEquals(null,adminDB.listInfoChangeRequest());
        Assertions.assertNotEquals(null,adminDB.getAllFunctionNames());

        workerDB workerDB = new workerDB();
        Assertions.assertNotEquals(null,workerDB.listWorker(1));
        Assertions.assertNotEquals(null,workerDB.listBills());
        Assertions.assertNotEquals(null,workerDB.listOrders());
        Assertions.assertNotEquals(null,workerDB.listInternalOrders());
        Assertions.assertNotEquals(null,workerDB.listProviders());
        Assertions.assertNotEquals(null,workerDB.listProducts());






    }
    @Test
    @DisplayName("Getter Test")
    public void test8() throws IOException {
        Erabiltzailea user = new Erabiltzailea(1,"enegalan","admin");
        Assertions.assertNotEquals(null,user.getRole());
        Assertions.assertNotEquals(0,user.getId_user());
        Assertions.assertNotEquals(null,user.getUsername());
        Assertions.assertNotEquals(null,user.getPassword());

        // Crear un objeto java.util.Date con la fecha 2016-10-08
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 9, 8); // El mes se cuenta desde 0 (enero=0, febrero=1, etc.)
        java.util.Date utilDate = calendar.getTime();
        // Convertir java.util.Date a java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Bill faktura = new Bill(1,sqlDate,4500.11);
        Assertions.assertNotEquals(0,faktura.getId_faktura());
        Assertions.assertNotEquals(null,faktura.getTotal());
        Assertions.assertNotEquals(null,faktura.getData());

        Hornitzaileak provider = new Hornitzaileak("Voyatouch","0 Rutledge Road","rroskilly0@shinystat.com");
        Assertions.assertNotEquals(null,provider.getIzena());
        Assertions.assertNotEquals(null,provider.getHelbidea());
        Assertions.assertNotEquals(null,provider.getKontaktua());


    }

    @BeforeAll
    @Test
    @DisplayName("BeforeAll Test")
    public void test9() throws IOException {
        System.out.println("Before");
    }
}
