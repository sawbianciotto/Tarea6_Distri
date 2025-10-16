package py.una.pol.sd.model;

import jakarta.persistence.*;

@Entity
public class Moneda {

    @Id
    private String codigoISO;

    private String nombre;

    // Getters y setters
    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}