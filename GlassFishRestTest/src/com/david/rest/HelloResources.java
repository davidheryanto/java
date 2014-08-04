package com.david.rest;

import com.david.model.Book;
import com.google.gson.Gson;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Path("/hello")
public class HelloResources {
    private Gson gson;

    public HelloResources() {
        gson = new Gson();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPlainText(@DefaultValue("anonymous") @QueryParam("author") String author) {
        return "Received message from " + author;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<html><em>Hello </em>Mighty <strong>Robot</strong></html>";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Book book = new Book(2, "First Book");
        return gson.toJson(book);
    }

    @GET
    @Path("/authors/{author}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAuthor(@PathParam("author") String author) {
        return "Received message from " + author;
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public String postHtml(String message) {
        return "POST raw: " + message;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(String bookJson) {
        Book book = gson.fromJson(bookJson, Book.class);
        return "POST json Book object: " + book.toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String postUrlEncoded(@FormParam("author") String author) {
        return "POST urlencoded: " + author;
    }

    // http://stackoverflow.com/questions/14858321/jax-rs-accept-images-as-input
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String postFormData(
            @FormDataParam("file") InputStream in,
            @FormDataParam("file") FormDataContentDisposition fileMetadata)
            throws Exception {

        if (fileMetadata == null || fileMetadata.getFileName() == null) {
            return "No filename";
        }
        File file = new File(fileMetadata.getFileName());
        FileOutputStream outputStream = new FileOutputStream(file);

        byte[] buf = new byte[16384];
        int len = in.read(buf);

        while (len != -1) {
            outputStream.write(buf, 0, len);
            len = in.read(buf);
        }

        outputStream.close();
        return "File " + file.getName() + " received\n";
    }

}
