/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netsyms.nanoffice.desktop;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Skylar
 */
public class NanofficeDesktop {

    public static ArrayList<Image> appicon = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] sizes = {"16", "24", "32", "48", "64", "96", "128", "256", "512"};
        for (String s : sizes) {
            appicon.add(new ImageIcon(
                    NanofficeDesktop.class.getResource("media/" + s + "x" + s + ".png")).getImage());
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new Splashscreen().setVisible(true);
    }

}
