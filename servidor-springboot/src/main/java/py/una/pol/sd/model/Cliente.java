package py.una.pol.sd.model;

import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    private String ci;

    private String nombre;
    private String apellido;

    // Getters y setters
    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}