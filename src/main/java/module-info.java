module sewagesystem {
    requires static lombok;
    requires org.slf4j;
    requires javafx.controls;
    requires javafx.graphics;
    exports pl.pwr.ite.dynak.gui;
    exports pl.pwr.ite.dynak.main;
    exports pl.pwr.ite.dynak.services;
}