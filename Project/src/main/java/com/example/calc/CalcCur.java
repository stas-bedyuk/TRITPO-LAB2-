package com.example.calc;

import javafx.scene.control.ChoiceBox;

import javax.swing.*;
import java.text.DecimalFormat;

public class CalcCur {

    double sum;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    void Sum(ChoiceBox<String> choos, BYN byn, Dollar dol, Euro eur, Rub rub, ParseCur a) {
        String result;
        switch (choos.getValue() ) {
            case "EUR":
                sum = eur.getEur()+((a.getDol() / a.getEur())*dol.getDol())+((rub.getRub()*a.getRub())/(100*a.getEur()))+(byn.getByn()/a.getEur());
                break;
            case "USD":
                sum = dol.getDol()+((a.getEur()/a.getDol())* eur.getEur())+((rub.getRub()*a.getRub())/(100*a.getDol()))+(byn.getByn()/a.getDol());
                break;
            case "RUB":
                sum = rub.getRub()+((byn.getByn()*100)/a.getRub())+((dol.getDol()*a.getDol()*100)/a.getRub())+((eur.getEur()*a.getEur()*100)/a.getRub());
                break;
            case "BYN":
                sum = byn.getByn()+eur.getEur()*a.getEur()+dol.getDol()*a.getDol()+((rub.getRub()/100)*a.getDol());
                break;
            default:
                JOptionPane.showMessageDialog(new JFrame(), "CHOOSE CURRENCY!", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                break;
        }
        DecimalFormat df = new DecimalFormat("#.00");
         result =df.format(sum);
         result = result.replace(',','.');
        sum =Double.parseDouble(result);
    }
}
