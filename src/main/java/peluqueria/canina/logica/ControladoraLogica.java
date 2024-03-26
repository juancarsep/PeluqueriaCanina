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
    
    
}
