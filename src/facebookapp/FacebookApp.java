
package facebookapp;

import facebook4j.FacebookException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jquesadaabeijon
 */

public class FacebookApp {
    
    public static void main(String[] args) throws FacebookException, MalformedURLException{
        
        Methods mt = new Methods();
        mt.keys();
        int op;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("1. Publicar estado \n2. Dar me gusta \n3. Publicar una imagen \n4. Buscar un post \n5. Publicar un comentario \n6. Mostrar comentarios \n7. Salir"));
                switch(op){
                    case 1:
                        mt.status(JOptionPane.showInputDialog("Introduce el nuevo Estado: "));
                        break;
                    case 2:
                        mt.like();
                        break;
                    case 3:
                        mt.postImage();
                        break;
                    case 4:
                        mt.searchPost(JOptionPane.showInputDialog("Escribe la palabra que quieres buscar: "));
                        break;
                    case 5:
                        mt.postComment(JOptionPane.showInputDialog("Escribe el comentario que quieres publicar: "));
                        break;  
                    case 6:
                        mt.showBiography();   
                        break;
                    case 7:
                        System.exit(0);
                        break;
                }
            }while(op!=0);
    }
    
}