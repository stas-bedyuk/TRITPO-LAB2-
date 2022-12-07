package com.example.calc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;




public class ParseCur {

    private double dol;
    private double rub;
    private double eur;

    public double getDol() {
        return dol;
    }

    public void setDol(double dol) {
        this.dol = dol;
    }

    public double getRub() {
        return rub;
    }

    public void setRub(double rub) {
        this.rub = rub;
    }


    public double getEur() {
        return eur;
    }

    public void setEur() throws IOException {
        setEur();
    }

    public void setEur(double eur)  {
        this.eur = eur;
    }
    void Parse() throws IOException
    {
        try {
            Document doc = Jsoup.connect("https://www.nbrb.by/").get();
            Elements tables = doc.getElementsByTag("tbody");
            Element our_table = tables.get(6);
            Elements elements_from_table = our_table.children();


            Element euro_all = elements_from_table.get(3);
            Elements euro_all2 = euro_all.children();           //евро
            Element euro = euro_all2.get(1);

            Element dollar_all = elements_from_table.get(2);
            Elements dollar_all2 = dollar_all.children();           //доллар
            Element dollar = dollar_all2.get(1);

            Element rub_rus_all = elements_from_table.get(1);
            Elements rub_rus2 = rub_rus_all.children();           //рос рубль
            Element rub_rus = rub_rus2.get(1);


            System.out.println("\n1 Euro: " + euro.text() + "\n1 Dollar: " + dollar.text() + "\n100 Ros Rubles: " + rub_rus.text());

            eur = Double.parseDouble(euro.text().replace(',', '.'));
            dol = Double.parseDouble(dollar.text().replace(',', '.'));
            rub = Double.parseDouble(rub_rus.text().replace(',', '.'));
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(new JFrame(), "CHECK INTERNET CONNECTION", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
        }
    }

