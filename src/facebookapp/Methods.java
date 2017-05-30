package facebookapp;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jquesadaabeijon
 */
public class Methods {

    public Facebook facebook;
    ResponseList<Post> results;

    /**
     * A través del objeto 'ConfigurationBuilder' se introducen las claves que
     * vamos a utilizar para conectar con la cuenta de Facebook.
     */
    public void keys() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("*")
                .setOAuthAppSecret("*")
                .setOAuthAccessToken("*")
                .setOAuthPermissions("*");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }

    /**
     * Publicar un estado en la cuenta de Facebook usando permisos de visibilidad.
     *
     * @param lastStatus
     */
    public void status(String lastStatus) {
        try {
            facebook.postStatusMessage(lastStatus);
        } catch (FacebookException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Dar 'Me gusta' a una publicación desde la cuenta de Facebook. Actualmente
     * no funciona.
     */
    public void like() {
        try {
            facebook.likePost(facebook.getId());
        } catch (FacebookException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Publica una imagen en la cuenta de Facebook.
     */
    public void postImage() {
        try {
            PostUpdate post = new PostUpdate(new URL("https://68.media.tumblr.com/"))
                    .picture(new URL("https://68.media.tumblr.com/20e196db7f001ed1e411a89d7eb67d5e/tumblr_n96ld57fsB1s5oxc0o1_500.jpg"))
                    .name("Briareos Hecatonchires")
                    .caption("tumblr.com")
                    .description("Appleseed");
            facebook.postFeed(post);
        } catch (MalformedURLException | FacebookException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Búsqueda de palabras en los post de la cuenta de Facebook.
     * @param word
     */
    public void searchPost(String word){
        try {
            ResponseList<Post> result = facebook.getPosts(word);
            System.out.println(result.toString());
        } catch (FacebookException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Publica un comentario en la cuenta de Facebook.
     * @param comment
     */
    public void postComment(String comment) {
        try {
            facebook.commentPost(results.get(1).getId(), comment);
        } catch (FacebookException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Muestra la biografía de la cuenta de Facebook.
     */
    public void showBiography() {
        try {
            ResponseList<Post> result = facebook.getFeed();
            System.out.println(result);
        } catch (FacebookException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
