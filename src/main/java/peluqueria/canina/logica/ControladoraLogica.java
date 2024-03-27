package peluqueria.canina.logica;

import java.util.ArrayList;
import java.util.List;
import peluqueria.canina.persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String razaMascota, String colorMascota, String observaciones, String nomDuenio, String celDuenio, String alergico, String atEsp) {
        Duenio duenio = new Duenio();
        duenio.setNombre(nomDuenio);
        duenio.setCelDuenio(celDuenio);
        
        
        Mascota masco = new Mascota();
        masco.setNombre(nombreMascota);
        masco.setRaza(razaMascota);
        masco.setColor(colorMascota);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atEsp);
        masco.setObservaciones(observaciones);
        masco.setDuenio(duenio);
        
        controlPersis.guardar(duenio,masco);
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
        
    }

    public void borrarMascota(int numCliente) {
        controlPersis.borrarMascota(numCliente);
    }

    public Mascota traerMascota(int numCliente) {
        return controlPersis.traerMascota(numCliente);
    }

    public void modificarMascota(Mascota masco, String nombreMascota, String razaMascota, String colorMascota, String observaciones,
            String nomDuenio, String celDuenio, String alergico, String atEsp) {
        masco.setNombre(nombreMascota);
        masco.setRaza(razaMascota);
        masco.setColor(colorMascota);
        masco.setObservaciones(observaciones);
        masco.setAtencionEspecial(atEsp);
        masco.setAlergico(alergico);
        controlPersis.modificarMascota(masco);
        
        
        Duenio duenio = this.buscarDuenio(masco.getDuenio().getIdDuenio());
        duenio.setNombre(nomDuenio);
        duenio.setCelDuenio(celDuenio);
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int idDuenio) {
        return controlPersis.traerDuenio(idDuenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarduenio(duenio);
    }
        
}
