/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luca1teruzzi
 */
public class JavaThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conto conto =new Conto(1000);
        Sportello ATM1=new Sportello(conto,"mamma");
        Sportello ATM2=new Sportello(conto,"papa");
        Thread mamma=new Thread(ATM1);
        Thread papa=new Thread(ATM2);
        mamma.start();
        papa.start();
        int qualeThread;// 0 = mamma ; 1 = papà
        int cheOperazione;// 0 = versa ; 1 = preleva
        int quanto;
        while(true){
            qualeThread= (int) (Math.random()*2);
            cheOperazione=(int)(Math.random()*2);
            quanto=(int)(Math.random()*501);
            if(qualeThread==0){
                if(cheOperazione==0){
                    ATM1.versa(quanto);
                    System.out.println("Mamma Versa "+quanto+"€");
                }else{
                    ATM1.preleva(quanto);
                    System.out.println("Mamma Preleva "+quanto+"€");
                }  
            }else{
                if(cheOperazione==0){
                    ATM2.versa(quanto);
                    System.out.println("Papà Versa "+quanto+"€");
                }else{
                    ATM2.versa(quanto);
                    System.out.println("Papà Preleva "+quanto+"€");
                }
            }
            
            
            
            
            

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(JavaThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        Processo T1 = new Processo("T1");
////      Processo T2 = new Processo("T2");

        
    }

    
}
