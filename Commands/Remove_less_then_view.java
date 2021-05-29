package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.View;
import com.company.Printer;

import javax.print.attribute.standard.MediaPrintableArea;

public class Remove_less_then_view implements Command {
    @Override
    public void Execute(String command) {
        try{
            View w;
            while (true){
                Printer.getInstance().WriteLine("введите view");
                for (View w1 : View.values()) {
                    System.out.print("\t\t\t" + w1);
                }
                System.out.println();
                String s = Printer.getInstance().ReadLine();
                if(s.equals("null")){
                    w = null;
                    break;
                }
                else{
                    try {
                        w = View.valueOf(s);
                        break;
                    }
                    catch (Exception e){
                        Printer.getInstance().WriteLine("введите верное значение");
                    }
                }
            }
            View finalW = w;
            Main.tree.getList().removeIf(u -> u.getView().compareTo(finalW) < 0);
            Printer.getInstance().WriteLine("успешно");
        }
        catch (Exception e){
            Printer.getInstance().WriteLine("неправильно введена команда: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
