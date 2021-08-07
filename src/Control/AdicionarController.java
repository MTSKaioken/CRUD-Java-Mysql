/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.AdicionarView;
import java.awt.Color;

/**
 *
 * @author mtskaioken
 */
public class AdicionarController {
    private AdicionarView view;

     public AdicionarController(AdicionarView view) {
        this.view = view;
    }
    public void setPlaceHolder(String placeholder){
        if (view.getTxtNomeVendedor().getText().equals(placeholder)) {
        view.getTxtNomeVendedor().setText("");
        view.getTxtNomeVendedor().setForeground(Color.BLACK);
        }
    }
    public void clearPlaceHolder(String placeholder){
            if (view.getTxtNomeVendedor().getText().isEmpty()) {
            view.getTxtNomeVendedor().setForeground(Color.GRAY);
            view.getTxtNomeVendedor().setText(placeholder);
        }
    }
}
