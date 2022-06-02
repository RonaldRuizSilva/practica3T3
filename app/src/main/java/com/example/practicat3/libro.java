package com.example.practicat3;

public class libro {

    String titulo,resumen,autor,fecha_publicacion,tienda_1,tienda_2,tienda_3,imagen;


    public libro(String titulo, String resumen, String autor, String fecha_publicacion, String tienda_1, String tienda_2, String tienda_3, String imagen) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
        this.fecha_publicacion = fecha_publicacion;
        this.tienda_1 = tienda_1;
        this.tienda_2 = tienda_2;
        this.tienda_3 = tienda_3;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getTienda_1() {
        return tienda_1;
    }

    public void setTienda_1(String tienda_1) {
        this.tienda_1 = tienda_1;
    }

    public String getTienda_2() {
        return tienda_2;
    }

    public void setTienda_2(String tienda_2) {
        this.tienda_2 = tienda_2;
    }

    public String getTienda_3() {
        return tienda_3;
    }

    public void setTienda_3(String tienda_3) {
        this.tienda_3 = tienda_3;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
